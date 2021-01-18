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

import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.AttributeExtensibleXMLObject;
import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Definition of the {@code MetadataSchemeEndpointListType} type.
 * 
 * The following schema fragment defines the MetadataSchemeEndpointListType complex type:
 * 
 * <pre>
 * {@code
 * <xs:complexType name="MetadataSchemeEndpointListType">
 *   <xs:annotation>
 *     <xs:documentation>
 *       Defines the metadata location(s) for a specific member state (territory).
 *     </xs:documentation>
 *   </xs:annotation>
 *   <xs:sequence>
 *     <xs:element type="ser:MetadataLocationType" name="MetadataLocation" minOccurs="0" maxOccurs="unbounded" />
 *   </xs:sequence>
 *   <xs:attribute name="Territory" type="xs:string" use="required" />
 *   <xs:anyAttribute namespace="##any" processContents="lax" />
 * </xs:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface MetadataList extends SAMLObject, AttributeExtensibleXMLObject {

  /** Name of the element. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "MetadataList";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "MetadataSchemeEndpointListType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Attribute label for the Territory attribute. */
  public static final String TERRITORY_ATTR_NAME = "Territory";

  /**
   * Returns a reference to the list of metadata location elements.
   * 
   * @return metadata location elements
   */
  List<MetadataLocation> getMetadataLocations();

  /**
   * Returns the territory country identifier for this metadata list.
   * 
   * @return country code
   */
  String getTerritory();

  /**
   * Assigns the territory country identifier for this metadata list.
   * 
   * @param territory
   *          country code
   */
  void setTerritory(String territory);

  /**
   * For the Swedish eIDAS configuration, a flag, {@code Suspend} is used to indicate whether a metadata list for a
   * specific territory is suspended. This method is just a short cut instead of using {@link #getUnknownAttributes()}.
   * 
   * @return if the {@code Suspend} flag has been set to {@code true} this method returns {@code true}, otherwise
   *         {@code false} 
   */
  boolean getSuspend();

  /**
   * Assigns the {@code Suspend} flag. See {@link #getSuspend()}.
   * 
   * @param suspendFlag
   *          the suspend flag
   */
  void setSuspend(boolean suspendFlag);

}
