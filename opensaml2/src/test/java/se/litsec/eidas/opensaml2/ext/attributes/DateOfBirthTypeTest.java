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
