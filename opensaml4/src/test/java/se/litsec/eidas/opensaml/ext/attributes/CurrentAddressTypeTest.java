/*
 * Copyright 2016-2021 Litsec AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.litsec.eidas.opensaml.ext.attributes;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Test;
import org.opensaml.core.xml.Namespace;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.XMLObjectBuilderFactory;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import net.shibboleth.utilities.java.support.codec.Base64Support;
import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;
import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Test cases for {@link CurrentAddressType} and {@link CurrentAddressStructuredType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressTypeTest extends OpenSAMLTestBase {

  /**
   * Tests marshalling and unmarshalling of {@code CurrentAddressStructuredType}.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallAndUnmarshallStructured() throws Exception {

    XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport.getBuilderFactory();

    Object object = builderFactory.getBuilder(CurrentAddressStructuredType.TYPE_NAME).buildObject(CurrentAddressStructuredType.TYPE_NAME
      .getNamespaceURI(), CurrentAddressStructuredType.TYPE_NAME.getLocalPart(), "eidas");
    CurrentAddressStructuredType address = CurrentAddressStructuredType.class.cast(object);

    fill(address);

    // Marshall
    Element element = OpenSAMLTestBase.marshall(address);
    Assert.assertNotNull(element);

    // Unmarshall element
    CurrentAddressStructuredType address2 = OpenSAMLTestBase.unmarshall(element, CurrentAddressStructuredType.class);

    verify(address, address2);

    // Test unmarshall again
    String xml = SerializeSupport.prettyPrintXML(element);
    Document doc = XMLObjectProviderRegistrySupport.getParserPool().parse(new ByteArrayInputStream(xml.toString().getBytes("UTF-8")));

    CurrentAddressStructuredType address3 = OpenSAMLTestBase.unmarshall(doc.getDocumentElement(), CurrentAddressStructuredType.class);
    verify(address, address3);
  }

  /**
   * Tests marshalling and unmarshalling of {@code CurrentAddressType}.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {

    XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport.getBuilderFactory();

    Object object = builderFactory.getBuilder(CurrentAddressType.TYPE_NAME).buildObject(CurrentAddressType.TYPE_NAME.getNamespaceURI(),
      CurrentAddressType.TYPE_NAME.getLocalPart(), "eidas");
    CurrentAddressType address = CurrentAddressType.class.cast(object);

    fill(address);

    // Marshall
    Element element = OpenSAMLTestBase.marshall(address);
    Assert.assertNotNull(element);

    // Verify that we got one child element that is the Base64 encoding.
    NodeList childs = element.getChildNodes();
    Assert.assertEquals(1, childs.getLength());
    String base64 = childs.item(0).getNodeValue();
    byte[] bytes = Base64Support.decode(base64);
    Assert.assertTrue((new String(bytes)).startsWith("<eidas:"));

    // Unmarshall element
    CurrentAddressType address2 = OpenSAMLTestBase.unmarshall(element, CurrentAddressType.class);

    verify(address, address2);
    
    String swedishEidString = address2.toSwedishEidString();
    Assert.assertEquals("LocatorDesignator=6%20tr;LocatorName=10;Thoroughfare=Korta%20gatan;PostName=Solna;PostCode=19174", swedishEidString);

    // Test unmarshall again
    String xml = SerializeSupport.prettyPrintXML(element);
    Document doc = XMLObjectProviderRegistrySupport.getParserPool().parse(new ByteArrayInputStream(xml.toString().getBytes("UTF-8")));

    CurrentAddressType address3 = OpenSAMLTestBase.unmarshall(doc.getDocumentElement(), CurrentAddressType.class);
    verify(address, address3);

  }

  /**
   * Test unmarshalling an attribute holding a CurrentAddress type. Example is from eIDAS specs.
   * <p>
   * The example contains the Base64-encoding of the following XML-snippet:
   * 
   * <pre>
   *  <eidas:LocatorDesignator>22</eidas:LocatorDesignator>
   *  <eidas:Thoroughfare>Arcacia Avenue</eidas:Thoroughfare>
   *  <eidas:PostName>London</eidas:PostName>
  *   <eidas:PostCode>SW1A 1AA</eidas:Postcode>
   * </pre>
   * </p>
   * 
   * @throws Exception
   *           for errors.
   */
  @Test
  public void testUnmarshallExampleAttribute() throws Exception {

    final String xml = "<saml:Attribute FriendlyName=\"CurrentAddress\" Name=\"http://eidas.europa.eu/attributes/naturalperson/CurrentAddress\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\" xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
        + "<saml:AttributeValue xmlns:eidas=\"http://eidas.europa.eu/attributes/naturalperson\" xsi:type=\"eidas:CurrentAddressType\">"
        + "PGVpZGFzOkxvY2F0b3JEZXNpZ25hdG9yPjIyPC9laWRhczpMb2NhdG9yRGVzaWduYX\n"
        + "Rvcj48ZWlkYXM6VGhvcm91Z2hmYXJlPkFyY2FjaWEgQXZlbnVlPC9laWRhczpUaG9y\n"
        + "b3VnaGZhcmU+DQo8ZWlkYXM6UG9zdE5hbWU+TG9uZG9uPC9laWRhczpQb3N0TmFtZT\n"
        + "4NCjxlaWRhczpQb3N0Q29kZT5TVzFBIDFBQTwvZWlkYXM6UG9zdENvZGU+"
        + "</saml:AttributeValue>"
        + "</saml:Attribute>";

    Document doc = XMLObjectProviderRegistrySupport.getParserPool().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    Element elm = doc.getDocumentElement();

    Attribute attribute = OpenSAMLTestBase.unmarshall(elm, Attribute.class);
    Assert.assertNotNull(attribute);
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME, attribute.getName());
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME, attribute.getFriendlyName());

    List<XMLObject> values = attribute.getAttributeValues();
    Assert.assertTrue(values.size() == 1);
    Assert.assertTrue(values.get(0) instanceof CurrentAddressType);
    CurrentAddressType address = (CurrentAddressType) values.get(0);
    Assert.assertEquals("22", address.getLocatorDesignator());
    Assert.assertEquals("Arcacia Avenue", address.getThoroughfare());
    Assert.assertEquals("London", address.getPostName());
    Assert.assertEquals("SW1A 1AA", address.getPostCode());
  }

  /**
   * Test that creates an attribute and places a CurrentAddessType as a value.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testAttributeCreate() throws Exception {

    Attribute attribute = OpenSAMLTestBase.createSamlObject(Attribute.class, Attribute.DEFAULT_ELEMENT_NAME);
    attribute.getNamespaceManager().registerNamespaceDeclaration(new Namespace(EidasConstants.EIDAS_NP_NS, "eidas"));
    attribute.setName(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME);
    attribute.setFriendlyName(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME);
    attribute.setNameFormat(Attribute.URI_REFERENCE);

    XMLObjectBuilder<CurrentAddressType> builder = OpenSAMLTestBase.getBuilder(CurrentAddressType.TYPE_NAME);
    CurrentAddressType address = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, 
      new QName(EidasConstants.EIDAS_NP_NS, CurrentAddressType.TYPE_NAME.getLocalPart(), "eidas"));
    fill(address);

    attribute.getAttributeValues().add(address);

    Element attrElement = OpenSAMLTestBase.marshall(attribute);

    System.out.println(SerializeSupport.prettyPrintXML(attrElement));

    // Make sure we inserted the correct namespace prefix while marshalling the CurrentAddressType
    Assert.assertTrue((new String(Base64Support.decode(attrElement.getFirstChild().getFirstChild().getNodeValue()))).startsWith("<eidas:"));

    // Unmarshall
    Attribute attribute2 = OpenSAMLTestBase.unmarshall(attrElement, Attribute.class);

    Assert.assertNotNull(attribute2);
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME, attribute2.getName());
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME, attribute2.getFriendlyName());

    List<XMLObject> values = attribute.getAttributeValues();
    Assert.assertTrue(values.size() == 1);
    Assert.assertTrue(values.get(0) instanceof CurrentAddressType);
    CurrentAddressType address2 = (CurrentAddressType) values.get(0);
    verify(address, address2);
  }

  private static void fill(CurrentAddressStructuredType address) {
    address.setLocatorDesignator("6 tr");
    address.setLocatorName("10");
    address.setThoroughfare("Korta gatan");
    address.setPostName("Solna");
    address.setPostCode("19174");
  }

  private static void verify(CurrentAddressStructuredType expected, CurrentAddressStructuredType actual) {
    Assert.assertEquals(expected.getElementQName(), actual.getElementQName());
    Assert.assertEquals(expected.getLocatorDesignator(), actual.getLocatorDesignator());
    Assert.assertEquals(expected.getLocatorName(), actual.getLocatorName());
    Assert.assertEquals(expected.getThoroughfare(), actual.getThoroughfare());
    Assert.assertEquals(expected.getPostName(), actual.getPostName());
    Assert.assertEquals(expected.getPostCode(), actual.getPostCode());

    Assert.assertEquals(expected.getCvaddressArea(), actual.getCvaddressArea());
  }

}
