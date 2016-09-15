/*
 * The eidas-opensaml project is an open-source package that extends OpenSAML
 * with definitions for the eIDAS Framework.
 *
 * More details on <https://github.com/litsec/eidas-opensaml>
 * Copyright (C) 2016 Litsec AB
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package se.litsec.eidas.opensaml.ext.attributes;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.XMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS type {@code CurrentAddressStructuredType}.
 * 
 * <pre>
 * {@code 
 * <xsd:complexType name="CurrentAddressStructuredType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Current address of the natural person.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:sequence>
 *     <xsd:element name="PoBox" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="LocatorDesignator" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="LocatorName" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="CvaddressArea" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="Thoroughfare" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="PostName" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="AdminunitFirstline" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="AdminunitSecondline" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="PostCode" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *   </xsd:sequence>
 * </xsd:complexType>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface CurrentAddressStructuredType extends XMLObject {

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "CurrentAddressStructuredType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

  /**
   * Assigns the Post box element.
   * 
   * @param poBox
   *          the Post box
   */
  void setPoBox(String poBox);

  /**
   * Returns the Post box element
   * 
   * @return the Post box element or {@code null} if no such element is available
   */
  String getPoBox();

  /**
   * Assigns the locator designator element.
   * <p>
   * About a locator designator from <a href=
   * "http://mapping.semic.eu/vdm/description.vsp?namespace=cv&type=63915929e74ac20f49eaa549ea877d92&id=&format=">
   * mapping.semic.eu</a>:
   * </p>
   * <blockquote> The locator designator is a number or a sequence of characters that uniquely identifies the locator
   * within the relevant scope(s). The full identification of the locator could include one or more locator designators.
   * [INSPIRE] In simpler terms, this is the building number, apartment number, etc. It is characteristic that these
   * designators, according to tradition or to a specific set of rules, are assigned systematically. For example address
   * numbers are most often assigned in ascending order with odd and even numbers on each side of the thoroughfare.
   * Another example is the floor identifier that in a standardized way expresses on which level the address is located.
   * [INSPIRE] The key difference between a locator designator and a locator name is that the latter is a proper name
   * and is unlikely to include digits. </blockquote>
   * 
   * @param locatorDesignator
   *          the locator designator
   */
  void setLocatorDesignator(String locatorDesignator);

  /**
   * Returns the locator designator element.
   * 
   * @return the locator designator element or {@code null} if no such element is available
   */
  String getLocatorDesignator();

  /**
   * Assigns the locator name element.
   * <p>
   * A locator name is typically a building, site or room name.
   * </p>
   * 
   * @param locatorName
   *          the locator name
   */
  void setLocatorName(String locatorName);

  /**
   * Returns the locator name element.
   * 
   * @return the locator name element or {@code null} if no such element is available.
   */
  String getLocatorName();

  /**
   * Assigns the Cvaddress area element.
   * 
   * @param cvaddressArea
   *          the Cvaddress area element
   */
  void setCvaddressArea(String cvaddressArea);

  /**
   * Returns the Cvaddress area element.
   * 
   * @return the Cvaddress area element or {@code null} if no such element is available
   */
  String getCvaddressArea();

  /**
   * Assigns the Thoroughfare element.
   * <p>
   * The element contains information about the thoroughfare - for example, the street, avenue, or boulevard - on which
   * an address is located.
   * </p>
   * 
   * @param thoroughfare
   *          the Thoroughfare element
   */
  void setThoroughfare(String thoroughfare);

  /**
   * Returns the Thoroughfare element.
   * 
   * @return the Thoroughfare element or {@code null} if no such element is available
   */
  String getThoroughfare();

  /**
   * Assigns the post name element.
   * <p>
   * The post name is generally the city-part of the address.
   * </p>
   * 
   * @param postName
   *          the post name
   */
  void setPostName(String postName);

  /**
   * Returns the post name element.
   * 
   * @return the post name element or {@code null} if no such element is available
   */
  String getPostName();

  /**
   * Assigns the admin unit first line element.
   * 
   * @param adminunitFirstline
   *          the admin unit first line element
   */
  void setAdminunitFirstline(String adminunitFirstline);

  /**
   * Returns the the admin unit first line element.
   * 
   * @return the the admin unit first line element or {@code null} if no such element is available
   */
  String getAdminunitFirstline();

  /**
   * Assigns the admin unit second line element.
   * 
   * @param adminunitSecondline
   *          the admin unit second line element
   */
  void setAdminunitSecondline(String adminunitSecondline);

  /**
   * Returns the the admin unit second line element.
   * 
   * @return the the admin unit second line element or {@code null} if no such element is available
   */
  String getAdminunitSecondline();

  /**
   * Assigns the Post code element.
   * 
   * @param postCode
   *          the Post code element
   */
  void setPostCode(String postCode);

  /**
   * Returns the Post code element.
   * 
   * @return the Post code element or {@code null} if no such element is available
   */
  String getPostCode();

}
