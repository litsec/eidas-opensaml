/*
 * The eidas-opensaml project is an open-source package that extends OpenSAML
 * with definitions for the eIDAS Framework.
 *
 * More details on <https://github.com/litsec/eidas-opensaml>
 * Copyright (C) 2016 Litsec AB
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package se.litsec.eidas.opensaml.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.opensaml.core.xml.Namespace;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AuthnContextClassRef;
import org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration;
import org.opensaml.saml.saml2.core.AuthnRequest;
import org.opensaml.saml.saml2.core.Extensions;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.NameID;
import org.opensaml.saml.saml2.core.NameIDPolicy;
import org.opensaml.saml.saml2.core.NameIDType;
import org.opensaml.saml.saml2.core.RequestedAuthnContext;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;
import se.litsec.eidas.opensaml.common.EidasConstants;
import se.litsec.eidas.opensaml.common.EidasLoaEnum;
import se.litsec.eidas.opensaml.ext.RequestedAttribute;
import se.litsec.eidas.opensaml.ext.RequestedAttributes;
import se.litsec.eidas.opensaml.ext.SPType;
import se.litsec.eidas.opensaml.ext.SPTypeEnumeration;
import se.litsec.eidas.opensaml.ext.attributes.AttributeConstants;

/**
 * Example code for how to create an eIDAS SAML AuthnRequest.
 * <p>
 * We create an {@code AuthnRequest} message as given as an example in section 6.3 of
 * <a href="https://joinup.ec.europa.eu/sites/default/files/eidas_message_format_v1.0.pdf">eIDAS SAML Message Format</a>
 * .
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CreateAuthnRequestExample extends OpenSAMLTestBase {

  /**
   * Creates an eIDAS {@code AuthnRequest} message.
   * 
   * @param requestID
   *          the ID of the request
   * @param destination
   *          the destination to where the request is to be sent
   * @param spEntityID
   *          the entityID of the entity creating the request
   * @param spType
   *          the eIDAS SP type (public or private)
   * @param requstedAttributes
   *          a list of requested attributes to be included as an eIDAS request extension
   * @param loa
   *          the eIDAS Level of Assurance to be included as a requested authentication context
   * @return a (non-signed) {@code AuthnRequest} message
   */
  public AuthnRequest createAuthnRequest(
      String requestID,
      String destination,
      String spEntityID,
      SPTypeEnumeration spType,
      List<String> requstedAttributes,
      EidasLoaEnum loa) {

    AuthnRequest request = OpenSAMLTestBase.createSamlObject(AuthnRequest.class, AuthnRequest.DEFAULT_ELEMENT_NAME);
    request.getNamespaceManager().registerNamespaceDeclaration(new Namespace(EidasConstants.EIDAS_NS, EidasConstants.EIDAS_PREFIX));

    // Add the request attributes.
    //
    request.setID(requestID);
    request.setDestination(destination);
    request.setIssueInstant(new DateTime());

    // Add the issuer element (the entity that issues this request).
    //
    Issuer issuer = OpenSAMLTestBase.createSamlObject(Issuer.class, Issuer.DEFAULT_ELEMENT_NAME);
    issuer.setFormat(NameIDType.ENTITY);
    issuer.setValue(spEntityID);
    request.setIssuer(issuer);

    Extensions extensions = OpenSAMLTestBase.createSamlObject(Extensions.class, Extensions.DEFAULT_ELEMENT_NAME);

    // Add the type of SP as an extension.
    //
    SPType spTypeElement = OpenSAMLTestBase.createSamlObject(SPType.class, SPType.DEFAULT_ELEMENT_NAME);
    spTypeElement.setType(spType);
    extensions.getUnknownXMLObjects().add(spTypeElement);

    // Add the eIDAS requested attributes as an extension.
    //
    if (requstedAttributes != null && !requstedAttributes.isEmpty()) {
      RequestedAttributes requestedAttributesElement = OpenSAMLTestBase.createSamlObject(RequestedAttributes.class,
        RequestedAttributes.DEFAULT_ELEMENT_NAME);
      
      // Also see the RequestedAttributeTemplates class ...

      for (String attr : requstedAttributes) {
        RequestedAttribute reqAttr = OpenSAMLTestBase.createSamlObject(RequestedAttribute.class, RequestedAttribute.DEFAULT_ELEMENT_NAME);
        reqAttr.setName(attr);
        reqAttr.setNameFormat(Attribute.URI_REFERENCE);
        reqAttr.setIsRequired(true);
        requestedAttributesElement.getRequestedAttributes().add(reqAttr);
      }
      extensions.getUnknownXMLObjects().add(requestedAttributesElement);
    }
    request.setExtensions(extensions);

    // Set the requested NameID policy to "persistent".
    //
    NameIDPolicy nameIDPolicy = OpenSAMLTestBase.createSamlObject(NameIDPolicy.class, NameIDPolicy.DEFAULT_ELEMENT_NAME);
    nameIDPolicy.setFormat(NameID.PERSISTENT);
    nameIDPolicy.setAllowCreate(true);
    request.setNameIDPolicy(nameIDPolicy);

    // Create the requested authentication context and assign the "level of assurance" that we require
    // the authentication to be performed under.
    //
    RequestedAuthnContext requestedAuthnContext = OpenSAMLTestBase.createSamlObject(RequestedAuthnContext.class,
      RequestedAuthnContext.DEFAULT_ELEMENT_NAME);
    requestedAuthnContext.setComparison(AuthnContextComparisonTypeEnumeration.MINIMUM); // Should be exact!
    AuthnContextClassRef authnContextClassRef = OpenSAMLTestBase.createSamlObject(AuthnContextClassRef.class,
      AuthnContextClassRef.DEFAULT_ELEMENT_NAME);
    authnContextClassRef.setAuthnContextClassRef(loa.getUri());
    requestedAuthnContext.getAuthnContextClassRefs().add(authnContextClassRef);
    request.setRequestedAuthnContext(requestedAuthnContext);

    return request;
  }
  
  /**
   * Calls {@link #createAuthnRequest(String, String, String, SPTypeEnumeration, List, EidasLoaEnum)} and parses the
   * result.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void createAuthnRequest() throws Exception {

    // Create an authentication request ...
    // (This example does not sign the request)
    //

    List<String> requiredAttributesNames = Arrays.asList(
      AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME);

    AuthnRequest authnRequest = createAuthnRequest(
      "_171ccc6b39b1e8f6e762c2e4ee4ded3a", /* The ID of the request */
      "https://eidas-service.eu/post", /* The destination URL - This is found in the IdP metadata */
      "https://eidas-connector.eu", /* The entityID of the requesting SP */
      SPTypeEnumeration.PUBLIC, /* Public or private SP type (eIDAS specific) */
      requiredAttributesNames, /* eIDAS required attributes */
      EidasLoaEnum.LOA_HIGH /* The required eIDAS LoA */);

    // Marshall and print the XML
    //
    Element authnRequestElement = XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(authnRequest).marshall(
      authnRequest);
    System.out.println("eIDAS AuthnRequest:");
    System.out.println(SerializeSupport.prettyPrintXML(authnRequestElement));

    // Unmarshall and assert eIDAS specific elements ...
    //
    AuthnRequest authnRequest2 = AuthnRequest.class.cast(
      XMLObjectProviderRegistrySupport.getUnmarshallerFactory()
        .getUnmarshaller(authnRequestElement)
        .unmarshall(authnRequestElement));

    // The SPType extension
    Optional<SPTypeEnumeration> spType = authnRequest2.getExtensions()
      .getUnknownXMLObjects()
      .stream()
      .filter(o -> SPType.class.isInstance(o))
      .map(SPType.class::cast)
      .map(t -> t.getType())
      .findFirst();
    Assert.assertTrue("Expected SPType in AuthnRequest extension", spType.isPresent());
    Assert.assertEquals("Expected SPType to be PUBLIC", SPTypeEnumeration.PUBLIC, spType.get());

    // The requested attributes ...
    Optional<RequestedAttributes> requestedAttributes = authnRequest2.getExtensions()
      .getUnknownXMLObjects()
      .stream()
      .filter(o -> RequestedAttributes.class.isInstance(o))
      .map(RequestedAttributes.class::cast)
      .findFirst();
    Assert.assertTrue("Expected RequestedAttributes in AuthnRequest extension", requestedAttributes.isPresent());

    Optional<RequestedAttribute> personIdentifierAttr = requestedAttributes.get()
      .getRequestedAttributes()
      .stream()
      .filter(a -> a.getName().equals(AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME))
      .findFirst();
    Assert.assertTrue("Expected PersonIdentifier attribute among the RequestedAttributes", personIdentifierAttr.isPresent());
    // We have hard-wired the isRequired attribute to true.
    Assert.assertTrue("Expected isRequired to be true", personIdentifierAttr.get().isRequired());
    
    // OK, you get it. Make sure we got all requested attributes ...
    
    List<String> requestedAttributesNames2 = requestedAttributes.get()
      .getRequestedAttributes()
      .stream()
      .map(a -> a.getName())
      .collect(Collectors.toList());
    Assert.assertEquals(requiredAttributesNames, requestedAttributesNames2); 
    
    // The RequestedAuthnContext
    String loaUri = authnRequest2.getRequestedAuthnContext().getAuthnContextClassRefs().get(0).getAuthnContextClassRef();
    Assert.assertEquals("Expected requested LoA URI to be \"high\"", EidasLoaEnum.LOA_HIGH.getUri(), loaUri);
  }

}
