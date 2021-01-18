/*
 * Copyright 2016-2021 Litsec AB
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
package se.litsec.eidas.opensaml.ext;

import javax.xml.namespace.QName;

import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code <eidas:SPType>} element.
 * 
 * <pre> {@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <xsd:schema
 *      xmlns="http://eidas.europa.eu/saml-extensions"
 *      xmlns:xsd="http://www.w3.org/2001/XMLSchema"
 *      targetNamespace="http://eidas.europa.eu/saml-extensions"
 *      elementFormDefault="qualified"
 *      attributeFormDefault="unqualified"
 *      version="1">
 *    
 *   <xs:element name="SPType" type="SPTypeType"/>
 *   
 *   <xs:simpleType name="SPTypeType">
 *     <xs:restriction base="xs:string">
 *       <xs:enumeration value="public"/>
 *       <xs:enumeration value="private"/>
 *     </xs:restriction>
 *   </xs:simpleType>
 *   
 * </xsd:schema>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface SPType extends SAMLObject {

  /** Local Name of SPType. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "SPType";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);
  
  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "SPTypeType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_PREFIX);  

  /**
   * Returns the SP type.
   * 
   * @return the SP type
   */
  SPTypeEnumeration getType();

  /**
   * Assigns the SP type
   * 
   * @param type
   *          the type
   */
  void setType(SPTypeEnumeration type);
}
