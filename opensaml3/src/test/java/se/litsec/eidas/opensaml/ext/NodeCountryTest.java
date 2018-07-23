/*
 * Copyright 2016-2018 Litsec AB
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
package se.litsec.eidas.opensaml.ext;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for building, marshalling and unmarshalling of {@code NodeCountry} elements.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class NodeCountryTest extends OpenSAMLTestBase {

  /**
   * Test building a {@code NodeCountry} element.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void test() throws Exception {
    NodeCountry nc = OpenSAMLTestBase.createSamlObject(NodeCountry.class, NodeCountry.DEFAULT_ELEMENT_NAME);
    Assert.assertNotNull(nc);
    nc.setNodeCountry("SE");

    Element element = OpenSAMLTestBase.marshall(nc);
    Assert.assertEquals("SE", element.getTextContent());

    NodeCountry nc2 = OpenSAMLTestBase.unmarshall(element, NodeCountry.class);
    Assert.assertEquals("SE", nc2.getNodeCountry());
  }

  /**
   * Tests that we convert to uppercase national code.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testConvert() throws Exception {
    NodeCountry nc = OpenSAMLTestBase.createSamlObject(NodeCountry.class, NodeCountry.DEFAULT_ELEMENT_NAME);
    Assert.assertNotNull(nc);
    nc.setNodeCountry("se");

    Assert.assertEquals("SE", nc.getNodeCountry());
  }

  /**
   * Tests that only valid ISO 3166-1 codes are accepted.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testBadInput() throws Exception {
    
    NodeCountry nc = OpenSAMLTestBase.createSamlObject(NodeCountry.class, NodeCountry.DEFAULT_ELEMENT_NAME);
    
    try {
      nc.setNodeCountry(null);
      Assert.fail("Expected IllegalArgumentException since null was supplied");
    }
    catch (IllegalArgumentException e) {      
    }
    
    try {
      nc.setNodeCountry("s");
      Assert.fail("Expected IllegalArgumentException since 's' was supplied");
    }
    catch (IllegalArgumentException e) {      
    }
    
    try {
      nc.setNodeCountry("sve");
      Assert.fail("Expected IllegalArgumentException since 'sve' was supplied");
    }
    catch (IllegalArgumentException e) {      
    }

  }

}
