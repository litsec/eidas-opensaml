/*
 * Copyright 2016-2017 Litsec AB
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
package se.litsec.eidas.opensaml2.ext.attributes.impl;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.opensaml.xml.AbstractXMLObject;
import org.opensaml.xml.XMLObject;

import se.litsec.eidas.opensaml2.ext.attributes.DateOfBirthType;

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
  public void setDate(LocalDate date) {
    this.birthDate = this.prepareForAssignment(this.birthDate, date);
  }

  /** {@inheritDoc} */
  @Override
  public void setDate(int year, int month, int dayOfMonth) {
    this.setDate(new LocalDate(year, month, dayOfMonth));
  }

  /** {@inheritDoc} */
  @Override
  public LocalDate getDate() {
    return this.birthDate;
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

}
