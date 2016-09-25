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

import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.BaseXMLObjectUnmarshaller;

import se.litsec.eidas.opensaml.ext.attributes.DateOfBirthType;

/**
 * Thread-safe unmarshaller for {@link DateOfBirthType} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DateOfBirthTypeUnmarshaller extends BaseXMLObjectUnmarshaller {

  /** {@inheritDoc} */
  protected void processElementContent(XMLObject xmlObject, String elementContent) {
    DateOfBirthType date = (DateOfBirthType) xmlObject;

    date.setDate(new LocalDate(elementContent, ISOChronology.getInstanceUTC()));
  }

}
