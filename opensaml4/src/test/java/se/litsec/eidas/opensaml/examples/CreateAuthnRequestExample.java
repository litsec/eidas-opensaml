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
package se.litsec.eidas.opensaml.examples;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
 * <a href="https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20SAML%20Message%20Format%20v.1.2%20Final.pdf">eIDAS SAML Message Format</a>
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
    request.setIssueInstant(Instant.now());

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
    authnContextClassRef.setURI(loa.getUri());
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
    String loaUri = authnRequest2.getRequestedAuthnContext().getAuthnContextClassRefs().get(0).getURI();
    Assert.assertEquals("Expected requested LoA URI to be \"high\"", EidasLoaEnum.LOA_HIGH.getUri(), loaUri);
  }

}
