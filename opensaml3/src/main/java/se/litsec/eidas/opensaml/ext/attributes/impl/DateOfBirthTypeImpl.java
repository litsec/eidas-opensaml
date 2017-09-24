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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;

import se.litsec.eidas.opensaml.ext.attributes.DateOfBirthType;

/**
 * Implementation of {@link DateOfBirthType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DateOfBirthTypeImpl extends AbstractXMLObject implements DateOfBirthType {

  /** The birth date. */
  private org.joda.time.LocalDate birthDate;

  /** The date time formatter to use. */
  private DateTimeFormatter formatter;

  /**
   * Constructor.
   * 
   * @param namespaceURI
   *          the namespace the element is in
   * @param elementLocalName
   *          the local name of the XML element this Object represents
   * @param namespacePrefix
   *          the prefix for the given namespace
   */
  protected DateOfBirthTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.formatter = ISODateTimeFormat.date().withChronology(ISOChronology.getInstanceUTC());
  }

  /** {@inheritDoc} */
  @Override
  public void setDate(org.joda.time.LocalDate date) {
    this.birthDate = this.prepareForAssignment(this.birthDate, date);
  }

  /** {@inheritDoc} */
  @Override
  public void setDate(java.time.LocalDate date) {
    this.setDate(date != null ? new org.joda.time.LocalDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth()) : null);
  }

  /** {@inheritDoc} */
  @Override
  public void setDate(int year, int month, int dayOfMonth) {
    this.setDate(new org.joda.time.LocalDate(year, month, dayOfMonth));
  }

  /** {@inheritDoc} */
  @Override
  public org.joda.time.LocalDate getDate() {
    return this.birthDate;
  }

  /** {@inheritDoc} */
  @Override
  public java.time.LocalDate getDateJava() {
    if (this.birthDate == null) {
      return null;
    }
    return java.time.LocalDate.of(this.birthDate.getYear(), this.birthDate.getMonthOfYear(), this.birthDate.getDayOfMonth());
  }
  
  /** {@inheritDoc} */
  @Override
  public String formatDate() {
    if (this.birthDate == null) {
      return null;
    }
    return this.formatter.print(this.birthDate);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    return Collections.emptyList();
  }

  /** {@inheritDoc} */
  @Override
  public String toStringValue() {
    return this.formatDate();
  }

  /** {@inheritDoc} */
  @Override
  public void parseStringValue(String value) {
    LocalDate d = this.formatter.parseLocalDate(value);
    // The parser allows dates on the format YY-MM-DD (commonly used in Sweden), but we require 4 digits for year.
    if (d.getCenturyOfEra() == 0) {
      throw new IllegalArgumentException("Illegal date format - YYYY-MM-DD is required");
    }
    this.setDate(d);
  }

}
