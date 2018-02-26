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

import java.util.List;

import javax.xml.namespace.QName;

import org.joda.time.DateTime;
import org.opensaml.saml.common.SignableSAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * Definition of the {@code MetadataServiceListType} type.
 * 
 * The following schema fragment defines the MetadataServiceListType complex type:
 * 
 * <pre>
 * {@code
 * <xs:complexType name="MetadataServiceListType">
 *   <xs:annotation>
 *     <xs:documentation>
 *       The MetadataServiceListType is the root type for representing a metadata service list. It holds
 *       scheme information, metadata locations for each member state and optionally distribution point(s).
 *     </xs:documentation>
 *   </xs:annotation>
 *   <xs:sequence>
 *     <xs:element name="SchemeInformation" type="ser:SchemeInformationType" />
 *     <xs:element name="MetadataList" type="ser:MetadataSchemeEndpointListType" minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="DistributionPoints" type="ser:DistributionPointsType" />
 *     <xs:element ref="ds:Signature" minOccurs="0" />
 *   </xs:sequence>
 *   <xs:attribute name="Version" type="xs:string" use="required">
 *     <xs:annotation>
 *       <xs:documentation>
 *         The version of a metadata service list.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 *   <xs:attribute name="IssueDate" type="xs:dateTime" use="required">
 *     <xs:annotation>
 *       <xs:documentation>
 *         Issuance time for a metadata service list.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 *   <xs:attribute name="NextUpdate" type="xs:dateTime">
 *     <xs:annotation>
 *       <xs:documentation>
 *         Time when the next metadata service list will be published.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 *   <xs:attribute name="ID" type="xs:ID">
 *     <xs:annotation>
 *       <xs:documentation>
 *         The unique ID for a metadata service list.
 *       </xs:documentation>
 *     </xs:annotation>
 *   </xs:attribute>
 * </xs:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface MetadataServiceList extends SignableSAMLObject {

  /** Name of the element. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "MetadataServiceList";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "MetadataServiceListType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_SERVICELIST_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_SERVICELIST_PREFIX);

  /** Attribute label for the IssueDate attribute. */
  public static final String ISSUE_DATE_ATTR_NAME = "IssueDate";

  /** Attribute label for the NextUpdate attribute. */
  public static final String NEXT_UPDATE_ATTR_NAME = "NextUpdate";

  /** Attribute label for the ID attribute. */
  public static final String ID_ATTR_NAME = "ID";

  /** Attribute label for the Version attribute. */
  public static final String VERSION_ATTR_NAME = "Version";

  /**
   * Returns the version for this metadata service list.
   * 
   * @return the version
   */
  MetadataServiceListVersion getVersion();

  /**
   * Assigns the version for this metadata service list.
   * 
   * @param version
   *          the version
   */
  void setVersion(MetadataServiceListVersion version);

  /**
   * Sets the ID of this list.
   * 
   * @return the ID
   */
  String getID();

  /**
   * Assigns the ID of this list.
   * 
   * @param id
   *          the ID
   */
  public void setID(String id);

  /**
   * Returns the issue date attribute value.
   * 
   * @return the issue date
   */
  DateTime getIssueDate();

  /**
   * Assigns the issue date attribute value.
   * 
   * @param issueDate
   *          the issue date
   */
  void setIssueDate(DateTime issueDate);

  /**
   * Returns the next-update attribute value.
   * 
   * @return the next update
   */
  DateTime getNextUpdate();

  /**
   * Assigns the next-update attribute value.
   * 
   * @param nextUpdate
   *          the next update
   */
  void setNextUpdate(DateTime nextUpdate);

  /**
   * Returns the scheme information element for this list.
   * 
   * @return scheme information
   */
  SchemeInformation getSchemeInformation();

  /**
   * Assigns the scheme information element for this list.
   * 
   * @param schemeInformation
   *          scheme information
   */
  void setSchemeInformation(SchemeInformation schemeInformation);

  /**
   * Returns a reference to the list of metadata lists held.
   * 
   * @return a list of metadata lists
   */
  List<MetadataList> getMetadataLists();

  /**
   * Returns the distribution points element.
   * 
   * @return the distribution points element
   */
  DistributionPoints getDistributionPoints();

  /**
   * Assigns the distribution points element.
   * 
   * @param distributionPoints
   *          distribution points
   */
  void setDistributionPoints(DistributionPoints distributionPoints);

}
