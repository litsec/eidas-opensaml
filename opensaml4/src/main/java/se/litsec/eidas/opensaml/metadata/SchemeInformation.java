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
package se.litsec.eidas.opensaml.metadata;

import javax.xml.namespace.QName;

import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Definition of the {@code SchemeInformation} type.
 * 
 * The following schema fragment defines the SchemeInformationType complex type:
 * 
 * <pre>
 * {@code
 * <xs:complexType name="SchemeInformationType">
 *   <xs:annotation>
 *     <xs:documentation>
 *       Scheme information about a published metadata service list, where the publisher 
 *       and territory are included.
 *     </xs:documentation>
 *   </xs:annotation>
 *   <xs:sequence>
 *     <xs:element name="IssuerName" type="xs:string" />
 *     <xs:element name="SchemeIdentifier" type="xs:anyURI" />
 *     <xs:element name="SchemeTerritory" type="xs:string" />
 *   </xs:sequence>
 * </xs:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface SchemeInformation extends SAMLObject {

  /** Name of the element. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "SchemeInformation";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "SchemeInformationType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);
  
  /** Name of the IssuerName element. */
  public static final String ISSUER_NAME_LOCAL_NAME = "IssuerName";
  
  /** Name of the SchemeIdentifier element. */
  public static final String SCHEME_IDENTIFIER_LOCAL_NAME = "SchemeIdentifier";
  
  /** Name of the SchemeTerritory element. */
  public static final String SCHEME_TERRITORY_LOCAL_NAME = "SchemeTerritory";

  /**
   * Returns the name of the organization that issued a metadata service list.
   * 
   * @return issuer name
   */
  String getIssuerName();

  /**
   * Assigns the name of the organization that issued a metadata service list.
   * 
   * @param issuerName
   *          issuer name
   */
  void setIssuerName(String issuerName);

  /**
   * Returns the unique scheme identifier for the metadata service list.
   * 
   * @return scheme identifier
   */
  String getSchemeIdentifier();

  /**
   * Assigns the scheme identifier for the metadata service list.
   * 
   * @param schemeIdentifier
   *          scheme identifier
   */
  void setSchemeIdentifier(String schemeIdentifier);

  /**
   * Returns the two-letter country code for the "territory" of this scheme.
   * 
   * @return country code
   */
  String getSchemeTerritory();

  /**
   * Assigns the two-letter country code for the "territory" of this scheme.
   * 
   * @param schemeTerritory
   *          country code
   */
  void setSchemeTerritory(String schemeTerritory);

}
