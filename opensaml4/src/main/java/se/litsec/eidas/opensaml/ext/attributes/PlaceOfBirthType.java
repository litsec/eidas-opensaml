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

import org.opensaml.core.xml.schema.XSString;
import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code PlaceOfBirthType}.
 * 
 * <pre>
 * {@code
 * <xsd:complexType name="PlaceOfBirthType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Place of birth for a natural person.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:simpleContent>
 *     <xsd:extension base="xsd:string">
 *     </xsd:extension>
 *   </xsd:simpleContent>
 * </xsd:complexType>}
 * </pre>
 * 
 * Example:
 * <pre>{@code
 * <saml:Attribute
 *       FriendlyName="PlaceOfBirth"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/PlaceOfBirth"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:PlaceOfBirthType">
 *     Peterborough
 *   </saml:AttributeValue>
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface PlaceOfBirthType extends XSString, SAMLObject, EidasAttributeValueType {
  
  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "PlaceOfBirthType"; 
      
  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);  
}
