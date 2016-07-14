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
   * @return a {@code RequestedAttribute} object representing the PersonIdentifier attribute
   */
  public static RequestedAttribute PERSON_IDENTIFIER(Boolean isRequired) {
    return create(AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_FRIENDLY_NAME,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the CurrentFamilyName attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @return a {@code RequestedAttribute} object representing the CurrentFamilyName attribute
   */
  public static RequestedAttribute CURRENT_FAMILY_NAME(Boolean isRequired) {
    return create(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the CurrentGivenName attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @return a {@code RequestedAttribute} object representing the CurrentGivenName attribute
   */
  public static RequestedAttribute CURRENT_GIVEN_NAME(Boolean isRequired) {
    return create(AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_FRIENDLY_NAME,
      Attribute.URI_REFERENCE, isRequired);
  }

  /**
   * Creates a {@code RequestedAttribute} object for the DateOfBirth attribute.
   * 
   * @param isRequired
   *          flag to tell whether the attribute is required
   * @return a {@code RequestedAttribute} object representing the DateOfBirth attribute
   */
  public static RequestedAttribute DATE_OF_BIRTH(Boolean isRequired) {
    return create(AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME,
      AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME,
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
