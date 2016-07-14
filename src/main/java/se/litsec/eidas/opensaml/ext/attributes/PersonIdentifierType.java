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

import org.opensaml.core.xml.schema.XSString;
import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code PersonIdentifierType}.
 * 
 * <pre>
 * <xsd:simpleType name="PersonIdentifierType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Unique identifier for the natural person as defined by the eIDAS Regulation.
 *     </xsd:documentation>
 *   </xsd:annotation>
 * <xsd:restriction base="xsd:string"/>
 * </xsd:simpleType>
 * </pre>
 * 
 * Example:
 * 
 * <pre>
 *  <saml:Attribute
 *        FriendlyName="PersonIdentifier"
 *        Name="http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier"
 *        NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *    <saml:AttributeValue xsi:type="eidasnp:PersonIdentifierType">
 *      ES/AT/02635542Y
 *    </saml:AttributeValue>
 *  </saml:Attribute>
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
 * Example: ES/AT/02635542Y (Spanish eIDNumber for an Austrian SP)
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface PersonIdentifierType extends XSString, SAMLObject {

//  /** Element local name. */
//  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "PersonIdentifierType";
//
//  /** Default element name. */
//  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_NP_NS, DEFAULT_ELEMENT_LOCAL_NAME,
//      EidasConstants.EIDAS_NP_PREFIX);
  
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
   * Example: ES</<b>AT</b>/02635542Y
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
   * Example: ES</AT/<b>02635542Y</b>
   * </p>
   * 
   * @return the identifier string of the uniqueness identifier
   */
  String getIdentifierString();

}
