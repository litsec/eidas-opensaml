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
package se.litsec.eidas.opensaml.ext;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.saml.saml2.core.Attribute;

import se.litsec.eidas.opensaml.ext.attributes.AttributeConstants;

/**
 * Utility methods for use when {@code RequestedAttribute} elements are inserted in an {@code AuthnRequest} extension.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class RequestedAttributeTemplates {

  /**
   * Creates a {@code RequestedAttribute} object for the PersonIdentifier attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the PersonIdentifier attribute
   */
  public static RequestedAttribute PERSON_IDENTIFIER(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the CurrentFamilyName attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the CurrentFamilyName attribute
   */
  public static RequestedAttribute CURRENT_FAMILY_NAME(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the CurrentGivenName attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the CurrentGivenName attribute
   */
  public static RequestedAttribute CURRENT_GIVEN_NAME(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the DateOfBirth attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the DateOfBirth attribute
   */
  public static RequestedAttribute DATE_OF_BIRTH(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the Gender attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the Gender attribute
   */
  public static RequestedAttribute GENDER(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_GENDER_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_GENDER_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the CurrentAddress attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @param includeFriendlyName
   *          flag that tells whether the friendly name should be included
   * @return a {@code RequestedAttribute} object representing the CurrentAddress attribute
   */
  public static RequestedAttribute CURRENT_ADDRESS(Boolean isRequired, boolean includeFriendlyName) {
    return create(AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME,
      includeFriendlyName ? AttributeConstants.EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME : null,
      Attribute.URI_REFERENCE, isRequired);
  }
    
  /**
   * Creates a {@code RequestedAttribute} object for the given attribute name.
   * 
   * @param name
   *          the attribute name
   * @param friendlyName
   *          the attribute friendly name (optional)
   * @param nameFormat
   *          the name format (defaults to {@code urn:oasis:names:tc:SAML:2.0:attrname-format:uri} if the value is not
   *          supplied)
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @return a {@code RequestedAttribute} object
   */
  public static RequestedAttribute create(String name, String friendlyName, String nameFormat, Boolean isRequired) {
    XMLObjectBuilder<? extends XMLObject> builder = XMLObjectProviderRegistrySupport.getBuilderFactory().getBuilder(
      RequestedAttribute.DEFAULT_ELEMENT_NAME);
    Object object = builder.buildObject(RequestedAttribute.DEFAULT_ELEMENT_NAME);
    RequestedAttribute ra = RequestedAttribute.class.cast(object);
    ra.setName(name);
    ra.setFriendlyName(friendlyName);
    ra.setNameFormat(nameFormat != null ? nameFormat : Attribute.URI_REFERENCE);
    ra.setIsRequired(isRequired);
    return ra;
  }

  private RequestedAttributeTemplates() {
  }

}
