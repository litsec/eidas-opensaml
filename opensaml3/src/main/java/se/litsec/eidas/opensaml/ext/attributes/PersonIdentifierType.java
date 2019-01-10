/*
 * Copyright 2016-2019 Litsec AB
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

import org.opensaml.core.xml.schema.XSString;
import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code PersonIdentifierType}.
 * 
 * <pre>{@code 
 * <xsd:simpleType name="PersonIdentifierType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Unique identifier for the natural person as defined by the eIDAS Regulation.
 *     </xsd:documentation>
 *   </xsd:annotation>
 * <xsd:restriction base="xsd:string"/>
 * </xsd:simpleType>}
 * </pre>
 * 
 * Example:
 * 
 * <pre>{@code
 *  <saml:Attribute
 *        FriendlyName="PersonIdentifier"
 *        Name="http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier"
 *        NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *    <saml:AttributeValue xsi:type="eidasnp:PersonIdentifierType">
 *      ES/AT/02635542Y
 *    </saml:AttributeValue>
 *  </saml:Attribute>}
 * </pre>
 * 
 * The uniqueness identifier consists of:
 * <ol>
 * <li>
 * The first part is the Nationality Code of the identifier. This is one of the ISO 3166-1 alpha-2 codes, followed
 * by a slash (“/“)).
 * </li>
 * <li>
 * The second part is the Nationality Code of the destination country or international
 * organization. This is one of the ISO 3166-1 alpha-2 codes, followed by a slash (“/“).
 * </li>
 * <li>
 * The third part a combination of readable characters. This uniquely identifies the identity asserted in the
 * country of origin but does not necessarily reveal any discernible correspondence with the subject's actual identifier
 * (for example, username, fiscal number etc).
 * </li>
 * </ol>
 * 
 * <p>
 * Example: {@code ES/AT/02635542Y} (Spanish eIDNumber for an Austrian SP)
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface PersonIdentifierType extends XSString, SAMLObject, EidasAttributeValueType {
  
  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "PersonIdentifierType"; 
      
  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

  /**
   * Returns the first part of the uniqueness identifier that is the Nationality Code of the identifier. This is an ISO
   * 3166-1 alpha-2 code.
   * <p>
   * Example: <b>ES</b>/AT/02635542Y
   * </p>
   * 
   * @return the Nationality Code of the identifier
   */
  String getNationalityCode();

  /**
   * Returns the second part of the uniqueness identifier that is the Nationality Code of the destination country or
   * international organization. This is an ISO 3166-1 alpha-2 code.
   * 
   * <p>
   * Example: ES/<b>AT</b>/02635542Y
   * </p>
   * 
   * @return the destination Nationality Code of the identifier
   */
  String getDestinationNationalityCode();

  /**
   * returns the third part of the uniqueness identifier that is a combination of readable characters. This uniquely
   * identifies the identity asserted in the country of origin but does not necessarily reveal any discernible
   * correspondence with the subject's actual
   * identifier (for example, username, fiscal number etc).
   *
   * <p>
   * Example: {@code ES</AT/<b>02635542Y</b>}
   * </p>
   * 
   * @return the identifier string of the uniqueness identifier
   */
  String getIdentifierString();
  
  

}
