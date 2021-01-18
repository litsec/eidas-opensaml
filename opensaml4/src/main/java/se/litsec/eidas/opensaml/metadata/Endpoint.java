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

import org.opensaml.core.xml.AttributeExtensibleXMLObject;
import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Definition of the {@code MsEndpointType} type.
 * 
 * The following schema fragment defines the MsEndpointType complex type:
 * 
 * <pre>
 * {@code
 * <xs:complexType name="MsEndpointType">
 *   <xs:annotation>
 *     <xs:documentation>
 *       Defines a member state "endpoint" (eIDAS node).
 *     </xs:documentation>
 *   </xs:annotation>
 *   <xs:attribute name="EndpointType" type="xs:anyURI" use="required">
 *     <xs:annotation>
 *       <xs:documentation>
 *         The type of endpoint. Currently defined URI:s are:
 *         http://eidas.europa.eu/metadata/ept/ProxyService for an eIDAS Proxy Service, and,
 *         http://eidas.europa.eu/metadata/ept/Connector for an eIDAS Connector.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 *   <xs:attribute name="EntityID" type="xs:anyURI" use="required">
 *     <xs:annotation>
 *       <xs:documentation>
 *         The SAML entityID of the endpoint. For an eIDAS connector this is the entityID for
 *         the SP-part of the node, and for an eIDAS Proxy Service this is the entityID for the
 *         IdP-part of the node.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 *   <xs:anyAttribute namespace="##any" processContents="lax" />
 * </xs:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface Endpoint extends SAMLObject, AttributeExtensibleXMLObject {

  /** Name of the element. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "Endpoint";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "MsEndpointType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Attribute label for the Location attribute. */
  public static final String ENDPOINT_TYPE_ATTR_NAME = "EndpointType";

  /** Attribute label for the Location attribute. */
  public static final String ENTITY_ID_ATTR_NAME = "EntityID";

  /** Identifier for a proxy service endpoint type. */
  public static final String PROXY_SERVICE_ENDPOINT_TYPE = "http://eidas.europa.eu/metadata/ept/ProxyService";

  /** Identifier for a connector endpoint type. */
  public static final String CONNECTOR_ENDPOINT_TYPE = "http://eidas.europa.eu/metadata/ept/Connector";

  /**
   * Returns the endpoint type URI.
   * 
   * @return the endpoint type
   */
  String getEndpointType();

  /**
   * Assigns the endpoint type URI.
   * 
   * @param endpointType
   *          the endpoint type
   */
  void setEndpointType(String endpointType);

  /**
   * Returns the entityID for the endpoint.
   * 
   * @return the entityID
   */
  String getEntityID();

  /**
   * Assigns the entityID for the endpoint.
   * 
   * @param entityID
   *          the entityID
   */
  void setEntityID(String entityID);

  /**
   * For the Swedish eIDAS configuration, the {@code Suspend} attribute is used to indicate whether an endpoint has been
   * suspended. This method is just a shortcut instead of using {@link #getUnknownAttributes()}.
   * 
   * @return if the {@code Suspend} attribute has been set to {@code true} this method returns {@code true}, otherwise
   *         {@code false} 
   */
  boolean getSuspend();

  /**
   * Assigns the {@code Suspend} attribute. See {@link #getSuspend()}.
   * 
   * @param suspendFlag
   *          the suspend flag
   */
  void setSuspend(boolean suspendFlag);

  /**
   * For the Swedish eIDAS configuration, the {@code HideFromDiscovery} attribute is used to indicate whether the proxy
   * service within an endpoint should be hidden from the connector "select country view". This method is just a
   * shortcut instead of using {@link #getUnknownAttributes()}.
   * 
   * @return if the {@code HideFromDiscovery} attribute has been set to {@code true} this method returns {@code true},
   *         otherwise {@code false}
   */
  boolean getHideFromDiscovery();

  /**
   * Assigns the {@code HideFromDiscovery} attribute. See {@link #getHideFromDiscovery()}.
   * 
   * @param hideFlag
   *          the "HideFromDiscovery" flag
   */
  void setHideFromDiscovery(boolean hideFlag);

}
