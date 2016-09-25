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
package se.litsec.eidas.opensaml2.ext.attributes;

import javax.xml.namespace.QName;

import org.opensaml.xml.XMLObject;

import se.litsec.eidas.opensaml2.common.EidasConstants;

/**
 * The eIDAS {@code GenderType}.
 * 
 * <pre>{@code
 * <xsd:simpleType name="GenderType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Gender of the natural person.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:restriction base="xsd:string">
 *     <xsd:enumeration value="Male"/>
 *     <xsd:enumeration value="Female"/>
 *     <xsd:enumeration value="Unspecified"/>
 *   </xsd:restriction>
 * </xsd:simpleType>}
 * </pre>
 * 
 * Example:
 * 
 * <pre>{@code 
 * <saml:Attribute
 *       FriendlyName="Gender"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/Gender"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:GenderType">
 *     Female
 *   </saml:AttributeValue>
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface GenderType extends XMLObject {

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "GenderType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

  /**
   * Assigns the gender.
   * 
   * @param gender
   *          the gender
   */
  void setGender(GenderTypeEnumeration gender);

  /**
   * Returns the gender.
   * 
   * @return the gender
   */
  GenderTypeEnumeration getGender();

}
