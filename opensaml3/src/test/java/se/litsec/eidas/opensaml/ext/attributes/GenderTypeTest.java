/*
 * Copyright 2016-2019 Litsec AB
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
 * Test cases for {@link GenderType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class GenderTypeTest extends OpenSAMLTestBase {

  /**
   * Test to marhall and unmarshall the object.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallUnmarshall() throws Exception {
    
    GenderType gender = OpenSAMLTestBase.createSamlObject(GenderType.class, GenderType.TYPE_NAME);
    gender.setGender(GenderTypeEnumeration.MALE);
    
    Element xml = OpenSAMLTestBase.marshall(gender);
    Assert.assertEquals(GenderTypeEnumeration.MALE.getValue(), xml.getTextContent());
    
    System.out.println(SerializeSupport.prettyPrintXML(xml));
    
    GenderType gender2 = OpenSAMLTestBase.unmarshall(xml, GenderType.class);
    Assert.assertEquals(gender.getGender(), gender2.getGender());
    
  }
  
}
