/*
 * Copyright 2016-2018 Litsec AB
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

import java.security.cert.X509Certificate;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.saml.common.SAMLObject;
import org.opensaml.xmlsec.signature.KeyInfo;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Definition of the {@code MetadataLocation} type.
 * 
 * The following schema fragment defines the MetadataLocationType complex type:
 * 
 * <pre>
 * {@code
 *  <xs:complexType name="MetadataLocationType">
 *    <xs:sequence>
 *      <xs:element name="Endpoint" type="ser:MsEndpointType" minOccurs="0" maxOccurs="unbounded">
 *        <xs:annotation>
 *          <xs:documentation>
 *            A list of eIDAS endpoints (nodes) for the current location.
 *          </xs:documentation>
 *        </xs:annotation>
 *      </xs:element>
 *      <xs:element ref="ds:KeyInfo" minOccurs="0">
 *        <xs:annotation>
 *          <xs:documentation>
 *            Key material (usually a certificate) that should be used to verify the signature
 *            of the downloaded metadata for this metadata location.
 *          </xs:documentation>
 *        </xs:annotation>
 *      </xs:element>
 *    </xs:sequence>
 *    <xs:attribute name="Location" type="xs:anyURI" use="required">
 *      <xs:annotation>
 *        <xs:documentation>
 *          The URL from where the metadata for the endpoint(s) can be obtained.
 *        </xs:documentation>
 *      </xs:annotation>
 *    </xs:attribute>
 *  </xs:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface MetadataLocation extends SAMLObject {

  /** Name of the element. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "MetadataLocation";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "MetadataLocationType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Attribute label for the Location attribute. */
  public static final String LOCATION_ATTR_NAME = "Location";

  /**
   * Returns the list of endpoints.
   * 
   * @return endpoint list
   */
  List<Endpoint> getEndpoints();

  /**
   * Returns the key info element to be used when verifying downloaded metadata.
   * 
   * @return key info element, or {@code null}
   */
  KeyInfo getKeyInfo();

  /**
   * Assigns the key info element to be used when verifying downloaded metadata.
   * 
   * @param keyInfo
   *          key info element
   * @see #setX509Certificate(X509Certificate)
   */
  void setKeyInfo(KeyInfo keyInfo);

  /**
   * Utility method that creates a {@link KeyInfo} object and assigns the supplied certificate to it before invoking
   * {@link #setKeyInfo(KeyInfo)}.
   * 
   * @param certificate
   *          the X.509 certificate to assign to a key info
   */
  void setX509Certificate(X509Certificate certificate);

  /**
   * Returns the location attribute, i.e., the URL from where the metadata endpoint(s) can be obtained.
   * 
   * @return URL
   */
  String getLocation();

  /**
   * Assigns the location attribute, i.e., the URL from where the metadata endpoint(s) can be obtained.
   * 
   * @param location
   *          URL
   */
  void setLocation(String location);

}
