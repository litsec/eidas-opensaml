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
package se.litsec.eidas.opensaml.ext;

import javax.xml.namespace.QName;

import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * * The eIDAS {@code <eidas:NodeCountry>} element.
 * 
 * <pre>
 *  {@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <xsd:schema 
 *      xmlns="http://eidas.europa.eu/saml-extensions"
 *      xmlns:xsd="http://www.w3.org/2001/XMLSchema"
 *      targetNamespace="http://eidas.europa.eu/saml-extensions"
 *      elementFormDefault="qualified"
 *      attributeFormDefault="unqualified"
 *      version="1">
 *      
 *   <xsd:element name="NodeCountry" type="eidas:NodeCountryType"/>
 *   
 *   <xsd:simpleType name="NodeCountryType">
 *     <xsd:restriction base="xsd:string">
 *       <xsd:pattern value="[A-Z][A-Z]"/>
 *     </xsd:restriction>
 *   </xsd:simpleType>
 *   
 * </xsd:schema>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface NodeCountry extends SAMLObject {

  /** Local name of NodeCountry. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "NodeCountry";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "NodeCountryType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_PREFIX);

  /**
   * Returns the node country.
   * 
   * @return the nationality code of the country or international organization in ISO 3166-1 alpha-2 format
   */
  String getNodeCountry();

  /**
   * Assigns the node country.
   * <p>
   * The {@code nodeCountry} parameter must be the nationality code of the country or international organization in ISO
   * 3166-1 alpha-2 format.
   * </p>
   * 
   * @param nodeCountry
   *          the country code
   * @throws IllegalArgumentException
   *           if the {@code nodeCountry} parameter is not given in ISO 3166-1 alpha-2 format
   */
  void setNodeCountry(String nodeCountry) throws IllegalArgumentException;

}
