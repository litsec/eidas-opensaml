/*
 * Copyright 2016-2017 Litsec AB
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

import javax.xml.namespace.QName;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code CurrentAddressType}.
 * 
 * <pre>
 * {@code 
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
 * <pre>
 * {@code 
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
public interface CurrentAddressType extends CurrentAddressStructuredType, EidasAttributeValueType {

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "CurrentAddressType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

  /**
   * Within the Swedish eID Framework only string-valued attributes are released. It would be possible to simply release
   * the Base64-blob and let attribute consumers decode and parse it, but the "Attribute Specification for the Swedish
   * eID Framework" is a little bit more helpful. It mandates that the eIDAS
   * {@code http://eidas.europa.eu/attributes/naturalperson/CurrentAddress} attribute is converted into the the
   * attribute {@code eidasNaturalPersonAddress} (urn:oid:1.2.752.201.3.9). This attribute holds a string value which
   * contains URL-encoded key-value pairs separated by semicolons.
   * 
   * <p>
   * The XML-snippet below:
   * </p>
   * 
   * <pre>{@code 
   * <eidas:LocatorDesignator>22</eidas:LocatorDesignator>
   * <eidas:Thoroughfare>Arcacia Avenue</eidas:Thoroughfare>
   * <eidas:PostName>London</eidas:PostName>
   * <eidas:PostCode>SW1A 1AA</eidas:Postcode>}</pre>
   * 
   * will be represented as: {@code "LocatorDesignator=22;Thoroughfare=Arcacia%20Avenue;PostName=London;PostCode=SW1A%201AA"}.
   * 
   * 
   * @return the address represented as a name-value string
   * @see #toStringValue()
   */
  String toSwedishEidString();

}
