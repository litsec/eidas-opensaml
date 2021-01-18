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
package se.litsec.eidas.opensaml.ext.attributes;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@link DateOfBirthType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DateOfBirthTypeTest extends OpenSAMLTestBase {

  /**
   * Test to marhall and unmarshall the object.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallUnmarshall() throws Exception {

    DateOfBirthType date = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date.setDate(1969, 11, 29);

    Element xml = OpenSAMLTestBase.marshall(date);
    Assert.assertEquals("1969-11-29", xml.getTextContent());

    System.out.println(SerializeSupport.prettyPrintXML(xml));

    DateOfBirthType date2 = OpenSAMLTestBase.unmarshall(xml, DateOfBirthType.class);
    Assert.assertEquals(date.getDate(), date2.getDate());
    Assert.assertEquals("1969-11-29", date2.toStringValue());

    // Create Java Time
    date = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date.setDate(java.time.LocalDate.of(1969, 11, 29));

    xml = OpenSAMLTestBase.marshall(date);
    Assert.assertEquals("1969-11-29", xml.getTextContent());

    date2 = OpenSAMLTestBase.unmarshall(xml, DateOfBirthType.class);
    Assert.assertEquals(date.getDate(), date2.getDate());

    DateOfBirthType date3 = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date3.parseStringValue("1969-11-29");

    xml = OpenSAMLTestBase.marshall(date);
    Assert.assertEquals("1969-11-29", xml.getTextContent());

    DateOfBirthType date4 = OpenSAMLTestBase.unmarshall(xml, DateOfBirthType.class);
    Assert.assertEquals(date3.getDate(), date4.getDate());
    Assert.assertEquals("1969-11-29", date4.toStringValue());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseError() throws Exception {
    DateOfBirthType date = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date.parseStringValue("NOT_A_DATE");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmpty() throws Exception {
    DateOfBirthType date = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date.parseStringValue("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseBadYear() throws Exception {
    DateOfBirthType date = OpenSAMLTestBase.createSamlObject(DateOfBirthType.class, DateOfBirthType.TYPE_NAME);
    date.parseStringValue("69-11-29"); // Not a full year
  }

}
