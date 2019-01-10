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
package se.litsec.eidas.opensaml.ext;

import org.junit.Assert;
import org.junit.Test;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;
import se.litsec.eidas.opensaml.ext.impl.SPTypeBuilder;

/**
 * Test cases for building, marshalling and unmarshalling of {@code SPType} elements.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SPTypeTest extends OpenSAMLTestBase {

  /**
   * Test building a {@code SPType} element.
   * 
   * @throws Exception
   */
  @Test
  public void testBuild() throws Exception {    
    
    SPTypeBuilder builder = new SPTypeBuilder();
    SPType type = builder.buildObject();
    Assert.assertNotNull(type);
    type.setType(SPTypeEnumeration.PRIVATE);
    
    SPType type2 = OpenSAMLTestBase.createSamlObject(SPType.class, SPType.DEFAULT_ELEMENT_NAME);
    Assert.assertNotNull(type2);
  }

}
