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

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code CurrentGivenNameType}.
 * 
 * <pre>{@code 
 * <xsd:complexType name="CurrentGivenNameType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Current given names of the natural person.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:simpleContent>
 *     <xsd:extension base="xsd:string">
 *       <xsd:attribute ref="LatinScript"/>
 *     </xsd:extension>
 *   </xsd:simpleContent>
 * </xsd:complexType>}
 * </pre>
 * 
 * Example:
 * <pre>{@code 
 * <saml:Attribute
 *       FriendlyName="FirstName"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/CurrentGivenName"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:CurrentGivenNameType">
 *     Sarah
 *   </saml:AttributeValue>
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface CurrentGivenNameType extends TransliterationStringType {
    
  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "CurrentGivenNameType"; 
      
  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);  

}
