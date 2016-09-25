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
package se.litsec.eidas.opensaml.ext.attributes;

import javax.xml.namespace.QName;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code CurrentAddressType}.
 * 
 * <pre>{@code 
 * <xsd:simpleType name="CurrentAddressType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Current address of the natural person as a base64 encoded string.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:restriction base="xsd:string"/>
 * </xsd:simpleType>}
 * </pre>
 * 
 * <p>
 * This attribute describes the current address for the natural person as registered with the MS authority.
 * </p>
 * <p>
 * Address data is structured by nature and is defined in the attribute schema as a structured XML sequence of
 * {@code xsd:string} elements. Where appropriate this structure address data follows the Core ISA Vocabulary type
 * CvAddressType although this has been simplified to a sequence of {@code xsd:string} elements.
 * </p>
 * <p>
 * To enable this data to be passed in a single attribute value this data MUST first be base64 encoded as described in
 * section 2.2.3 Responding Attributes, of the eIDAS Message Format specification.
 * </p>
 * 
 * Example:
 * 
 * <pre>{@code 
 * <saml:Attribute
 *       FriendlyName="CurrentAddress"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/CurrentAddress"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:CurrentAddressType">
 *     PGVpZGFzOkxvY2F0b3JEZXNpZ25hdG9yPjIyPC9laWRhczpMb2NhdG9yRGVzaWduYX
 *     Rvcj48ZWlkYXM6VGhvcm91Z2hmYXJlPkFyY2FjaWEgQXZlbnVlPC9laWRhczpUaG9y
 *     b3VnaGZhcmU+DQo8ZWlkYXM6UG9zdE5hbWU+TG9uZG9uPC9laWRhczpQb3N0TmFtZT
 *     4NCjxlaWRhczpQb3N0Q29kZT5TVzFBIDFBQTwvZWlkYXM6UG9zdENvZGU+
 *   </saml:AttributeValue>
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 * @see CurrentAddressStructuredType
 */
public interface CurrentAddressType extends CurrentAddressStructuredType {

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "CurrentAddressType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

}
