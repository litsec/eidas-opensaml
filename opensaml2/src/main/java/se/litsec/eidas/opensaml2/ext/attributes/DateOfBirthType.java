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
package se.litsec.eidas.opensaml2.ext.attributes;

import javax.xml.namespace.QName;

import org.joda.time.LocalDate;
import org.opensaml.xml.XMLObject;

import se.litsec.eidas.opensaml2.common.EidasConstants;

/**
 * The eIDAS {@code DateOfBirthType}.
 * 
 * <pre>{@code 
 * <xsd:simpleType name="DateOfBirthType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Date of Birth for the Natural Person (Based on xsd:date i.e. YYYY-MM-DD format).
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:restriction base="xsd:date"/>
 * </xsd:simpleType>}
 * </pre>
 * 
 * Example:
 * 
 * <pre>{@code
 * <saml:Attribute
 *       FriendlyName="DateOfBirth"
 *       Name="http://eidas.europa.eu/attributes/naturalperson/DateOfBirth"
 *       NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
 *   <saml:AttributeValue xsi:type="eidas:DateOfBirthType">
 *     1970-05-28
 *   </saml:AttributeValue>
 * </saml:Attribute>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface DateOfBirthType extends XMLObject {

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "DateOfBirthType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NP_NS, TYPE_LOCAL_NAME, EidasConstants.EIDAS_NP_PREFIX);

  /**
   * Assigns the date.
   * 
   * @param date
   *          the date to assign
   * @see #setDate(java.time.LocalDate)
   */
  void setDate(org.joda.time.LocalDate date);

  /**
   * Assigns the date by giving the year, month and day of month.
   * 
   * @param year
   *          the year (four digits)
   * @param month
   *          the month (1-12)
   * @param dayOfMonth
   *          the day of month (1-31)
   */
  void setDate(int year, int month, int dayOfMonth);

  /**
   * Returns the birth date.
   * 
   * @return the date
   * @see #getDateJava()
   */
  LocalDate getDate();

  /**
   * Formats the birth date according to the formatting rules of xsd:date (YYYY-MM-DD).
   * 
   * @return a formatted date string
   */
  String formatDate();

}
