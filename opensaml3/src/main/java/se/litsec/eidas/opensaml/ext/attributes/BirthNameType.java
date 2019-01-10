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

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code BirthNameType}.
 * 
 * <pre>
 * {@code 
 * <xsd:complexType name="BirthNameType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       First name(s) and family name(s) of the natural person at birth.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:simpleContent>
 *     <xsd:extension base="xsd:string">
 *       <xsd:attribute ref="LatinScript" />
 *     </xsd:extension>
 *   </xsd:simpleContent>
 * </xsd:complexType>}
 * </pre>
 * 
 * Example:
 * <pre>{@code
 * <saml:Attribute
 *       FriendlyName="BirthName"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/BirthName"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:BirthNameType">
 *     Sarah Jane Booth
 *   </saml:AttributeValue
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface BirthNameType extends TransliterationStringType {
  
  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "BirthNameType"; 
      
  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);  
}
