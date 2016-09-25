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

import org.junit.Assert;
import org.junit.Test;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml2.OpenSAMLTestBase;
import se.litsec.eidas.opensaml2.ext.attributes.DateOfBirthType;

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
    
    System.out.println(XMLHelper.prettyPrintXML(xml));
    
    DateOfBirthType date2 = OpenSAMLTestBase.unmarshall(xml, DateOfBirthType.class);
    Assert.assertEquals(date.getDate(), date2.getDate());
  }
  
}
