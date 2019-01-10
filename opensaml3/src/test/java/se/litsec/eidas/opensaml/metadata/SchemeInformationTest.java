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
package se.litsec.eidas.opensaml.metadata;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@code SchemeInformation}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SchemeInformationTest extends OpenSAMLTestBase {

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {
    
    SchemeInformation info = OpenSAMLTestBase.createSamlObject(SchemeInformation.class, SchemeInformation.DEFAULT_ELEMENT_NAME);
    info.setIssuerName("E-identification board");
    info.setSchemeIdentifier("123456");    
    info.setSchemeTerritory("SE");
    
    Element element = OpenSAMLTestBase.marshall(info);
    
    SchemeInformation info2 = OpenSAMLTestBase.unmarshall(element, SchemeInformation.class);
    Assert.assertEquals(info.getIssuerName(), info2.getIssuerName());
    Assert.assertEquals(info.getSchemeIdentifier(), info2.getSchemeIdentifier());
    Assert.assertEquals(info.getSchemeTerritory(), info2.getSchemeTerritory());
  }
  
  /**
   * Tests assigning null child elements
   * @throws Exception
   */
  @Test
  public void testNull() throws Exception {
    SchemeInformation info = OpenSAMLTestBase.createSamlObject(SchemeInformation.class, SchemeInformation.DEFAULT_ELEMENT_NAME);
    info.setIssuerName(null);
    info.setSchemeIdentifier("123456");
    info.setSchemeTerritory(null);
    
    Element element = OpenSAMLTestBase.marshall(info);
    
    SchemeInformation info2 = OpenSAMLTestBase.unmarshall(element, SchemeInformation.class);
    Assert.assertNull(info2.getIssuerName()); 
    Assert.assertEquals(info.getSchemeIdentifier(), info2.getSchemeIdentifier());
    Assert.assertNull(info2.getSchemeTerritory());
  }

}
