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
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml2.OpenSAMLTestBase;

/**
 * Test cases for {@link BirthNameType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class BirthNameTypeTest extends OpenSAMLTestBase {

  /**
   * Test to marhall and unmarshall the object.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallUnmarshall() throws Exception {

    BirthNameType bnt = OpenSAMLTestBase.createSamlObject(BirthNameType.class, BirthNameType.TYPE_NAME);
    bnt.setValue("Elsie Adela Lindström");

    Assert.assertEquals("Elsie Adela Lindström", bnt.getValue());
    Assert.assertTrue(bnt.getLatinScript());
    Assert.assertNull(bnt.getLatinScriptXSBooleanValue());

    Element element = OpenSAMLTestBase.marshall(bnt);
    Assert.assertNotNull(element);

    BirthNameType bnt2 = OpenSAMLTestBase.unmarshall(element, BirthNameType.class);
    Assert.assertEquals(bnt.getValue(), bnt2.getValue());
    Assert.assertEquals(bnt.getLatinScript(), bnt2.getLatinScript());
    Assert.assertEquals(bnt.getElementQName(), bnt2.getElementQName());
  }
  
}
