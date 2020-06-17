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

import javax.xml.namespace.QName;

import org.opensaml.core.xml.XMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

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
public interface GenderType extends XMLObject, EidasAttributeValueType {

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
