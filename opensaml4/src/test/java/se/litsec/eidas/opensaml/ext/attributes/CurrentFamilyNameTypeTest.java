/*
 * Copyright 2016-2020 Litsec AB
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
import java.io.InputStream;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeValue;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@link CurrentFamilyNameType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentFamilyNameTypeTest extends OpenSAMLTestBase {

  /**
   * Test to marhall and unmarshall the object.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallUnmarshall() throws Exception {

    CurrentFamilyNameType cfn = OpenSAMLTestBase.createSamlObject(CurrentFamilyNameType.class, CurrentFamilyNameType.TYPE_NAME);
    cfn.setValue("Karlsson");

    Assert.assertEquals("Karlsson", cfn.getValue());
    Assert.assertTrue(cfn.getLatinScript());
    Assert.assertNull(cfn.getLatinScriptXSBooleanValue());

    Element element = OpenSAMLTestBase.marshall(cfn);
    Assert.assertNotNull(element);

    CurrentFamilyNameType cfn2 = OpenSAMLTestBase.unmarshall(element, CurrentFamilyNameType.class);
    Assert.assertEquals(cfn.getValue(), cfn2.getValue());
    Assert.assertEquals(cfn.getLatinScript(), cfn2.getLatinScript());
    Assert.assertEquals(cfn.getElementQName(), cfn2.getElementQName());
  }

  /**
   * Verifies that we can unmarshall the example given in section 2.4 of
   * <a href="https://joinup.ec.europa.eu/sites/default/files/eidas_saml_attribute_profile_v1.0_2.pdf">eIDAS SAML
   * Attribute Profile</a>.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testUnmarshallExample() throws Exception {
    InputStream is = this.getClass().getResourceAsStream("/example-transliteration.xml");
    Attribute attribute = (Attribute) XMLObjectSupport.unmarshallFromInputStream(XMLObjectProviderRegistrySupport.getParserPool(), is);
    Assert.assertNotNull(attribute);

    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME, attribute.getName());
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME, attribute.getFriendlyName());
    Assert.assertEquals(Attribute.URI_REFERENCE, attribute.getNameFormat());

    Assert.assertTrue(attribute.getAttributeValues().size() == 2);
    Assert.assertTrue(attribute.getAttributeValues().get(0) instanceof CurrentFamilyNameType);
    Assert.assertTrue(attribute.getAttributeValues().get(1) instanceof CurrentFamilyNameType);

    CurrentFamilyNameType v1 = (CurrentFamilyNameType) attribute.getAttributeValues().get(0);
    Assert.assertTrue(v1.getLatinScript());
    Assert.assertNull(v1.getLatinScriptXSBooleanValue());
    Assert.assertEquals("Onasis", v1.getValue());

    CurrentFamilyNameType v2 = (CurrentFamilyNameType) attribute.getAttributeValues().get(1);
    Assert.assertFalse(v2.getLatinScript());
    Assert.assertNotNull(v2.getLatinScriptXSBooleanValue());
    Assert.assertEquals("Ωνασης", v2.getValue());
    Assert.assertEquals("&#937;&#957;&#945;&#963;&#951;&#962;", StringEscapeUtils.escapeXml(v2.getValue()));
  }

  /**
   * Test creating and marshalling/unmarshalling an attribute with a name represented in two ways.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testTransliteratedAttribute() throws Exception {
    Attribute attribute = OpenSAMLTestBase.createSamlObject(Attribute.class, Attribute.DEFAULT_ELEMENT_NAME);
    attribute.setName(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME);
    attribute.setNameFormat(Attribute.URI_REFERENCE);

    XMLObjectBuilder<CurrentFamilyNameType> builder = OpenSAMLTestBase.getBuilder(CurrentFamilyNameType.TYPE_NAME);

    CurrentFamilyNameType name1 = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, CurrentFamilyNameType.TYPE_NAME);
    name1.setValue("Onasis");

    CurrentFamilyNameType name2 = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, CurrentFamilyNameType.TYPE_NAME);
    name2.setValue("Ωνασης");
    name2.setLatinScript(false);

    attribute.getAttributeValues().add(name1);
    attribute.getAttributeValues().add(name2);

    Element xml = OpenSAMLTestBase.marshall(attribute);

    Attribute attribute2 = OpenSAMLTestBase.unmarshall(xml, Attribute.class);
    Assert.assertEquals(((CurrentFamilyNameType) attribute.getAttributeValues().get(0)).getValue(), ((CurrentFamilyNameType) attribute2
      .getAttributeValues().get(0)).getValue());
    Assert.assertEquals(((CurrentFamilyNameType) attribute.getAttributeValues().get(1)).getValue(), ((CurrentFamilyNameType) attribute2
      .getAttributeValues().get(1)).getValue());

    // Unmarshall again, but this time from the XML string ...
    String xmlString = SerializeSupport.prettyPrintXML(xml);

    Attribute attribute3 = (Attribute) XMLObjectSupport.unmarshallFromInputStream(XMLObjectProviderRegistrySupport.getParserPool(),
      new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
    Assert.assertEquals(((CurrentFamilyNameType) attribute.getAttributeValues().get(0)).getValue(), ((CurrentFamilyNameType) attribute3
      .getAttributeValues().get(0)).getValue());
    Assert.assertEquals(((CurrentFamilyNameType) attribute.getAttributeValues().get(1)).getValue(), ((CurrentFamilyNameType) attribute3
      .getAttributeValues().get(1)).getValue());
  }

}
