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

import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.BaseXMLObjectUnmarshaller;

import se.litsec.eidas.opensaml2.ext.attributes.DateOfBirthType;

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
