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
package se.litsec.eidas.opensaml2.metadata;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml2.OpenSAMLTestBase;

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
    
    IssuerName issuerName = OpenSAMLTestBase.createSamlObject(IssuerName.class, IssuerName.DEFAULT_ELEMENT_NAME);
    issuerName.setValue("E-identification board");
    info.setIssuerName(issuerName);
    
    SchemeIdentifier id = OpenSAMLTestBase.createSamlObject(SchemeIdentifier.class, SchemeIdentifier.DEFAULT_ELEMENT_NAME);
    id.setValue("123456");
    info.setSchemeIdentifier(id);
    
    SchemeTerritory c = OpenSAMLTestBase.createSamlObject(SchemeTerritory.class, SchemeTerritory.DEFAULT_ELEMENT_NAME);
    c.setValue("SE");
    info.setSchemeTerritory(c);
    
    Element element = OpenSAMLTestBase.marshall(info);
    
    SchemeInformation info2 = OpenSAMLTestBase.unmarshall(element, SchemeInformation.class);
    Assert.assertEquals(info.getIssuerNameString(), info2.getIssuerName().getValue());
    Assert.assertEquals(info.getSchemeIdentifierString(), info2.getSchemeIdentifier().getValue());
    Assert.assertEquals(info.getSchemeTerritoryString(), info2.getSchemeTerritory().getValue());
  }
  
  /**
   * Tests the direct string setters for SchemeInformation.
   * 
   * @throws Exception
   */
  @Test
  public void testStringSetters() throws Exception {
    
    SchemeInformation info = OpenSAMLTestBase.createSamlObject(SchemeInformation.class, SchemeInformation.DEFAULT_ELEMENT_NAME);
    info.setIssuerName("E-identification board");
    info.setSchemeIdentifier("123456");
    info.setSchemeTerritory("SE");
    
    Element element = OpenSAMLTestBase.marshall(info);
    
    SchemeInformation info2 = OpenSAMLTestBase.unmarshall(element, SchemeInformation.class);
    Assert.assertEquals(info.getIssuerName().getValue(), info2.getIssuerNameString());
    Assert.assertEquals(info.getSchemeIdentifier().getValue(), info2.getSchemeIdentifierString());
    Assert.assertEquals(info.getSchemeTerritory().getValue(), info2.getSchemeTerritoryString());    
  }
  
  /**
   * Tests assigning null child elements
   * @throws Exception
   */
  @Test
  public void testNull() throws Exception {
    SchemeInformation info = OpenSAMLTestBase.createSamlObject(SchemeInformation.class, SchemeInformation.DEFAULT_ELEMENT_NAME);
    info.setIssuerName((IssuerName) null);
    info.setSchemeIdentifier("123456");
    info.setSchemeTerritory((String) null);
    
    Element element = OpenSAMLTestBase.marshall(info);
    
    SchemeInformation info2 = OpenSAMLTestBase.unmarshall(element, SchemeInformation.class);
    Assert.assertNull(info2.getIssuerName());
    Assert.assertNull(info2.getIssuerNameString()); 
    Assert.assertEquals(info.getSchemeIdentifier().getValue(), info2.getSchemeIdentifierString());
    Assert.assertNull(info2.getSchemeTerritory());
    Assert.assertNull(info2.getSchemeTerritoryString());
  }

}
