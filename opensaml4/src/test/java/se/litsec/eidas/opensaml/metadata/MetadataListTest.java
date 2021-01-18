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
package se.litsec.eidas.opensaml.metadata;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@code MetadataList}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataListTest extends OpenSAMLTestBase {

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {

    MetadataList mdl = OpenSAMLTestBase.createSamlObject(MetadataList.class, MetadataList.DEFAULT_ELEMENT_NAME);
    mdl.setTerritory("SE");
    mdl.getMetadataLocations().add(MetadataLocationTest.createMetadataLocation());

    Element element = OpenSAMLTestBase.marshall(mdl);

    MetadataList mdl2 = OpenSAMLTestBase.unmarshall(element, MetadataList.class);

    Assert.assertEquals(mdl.getTerritory(), mdl2.getTerritory());
    Assert.assertEquals(mdl.getMetadataLocations().size(), mdl2.getMetadataLocations().size());
    Assert.assertFalse(mdl.getSuspend());
    Assert.assertFalse(mdl2.getSuspend());
  }

  /**
   * Tests the suspend-attribute
   * 
   * @throws Exception
   */
  @Test
  public void testSuspendAnyAttribute() throws Exception {

    MetadataList mdl = OpenSAMLTestBase.createSamlObject(MetadataList.class, MetadataList.DEFAULT_ELEMENT_NAME);
    mdl.setTerritory("SE");
    mdl.setSuspend(true);
    mdl.getMetadataLocations().add(MetadataLocationTest.createMetadataLocation());

    Element element = OpenSAMLTestBase.marshall(mdl);

    MetadataList mdl2 = OpenSAMLTestBase.unmarshall(element, MetadataList.class);

    Assert.assertEquals(mdl.getTerritory(), mdl2.getTerritory());
    Assert.assertEquals(mdl.getMetadataLocations().size(), mdl2.getMetadataLocations().size());
    Assert.assertTrue(mdl.getSuspend());
    Assert.assertTrue(mdl2.getSuspend());

    mdl = OpenSAMLTestBase.createSamlObject(MetadataList.class, MetadataList.DEFAULT_ELEMENT_NAME);
    mdl.setTerritory("SE");
    mdl.setSuspend(false);
    mdl.getMetadataLocations().add(MetadataLocationTest.createMetadataLocation());

    element = OpenSAMLTestBase.marshall(mdl);

    mdl2 = OpenSAMLTestBase.unmarshall(element, MetadataList.class);

    Assert.assertEquals(mdl.getTerritory(), mdl2.getTerritory());
    Assert.assertEquals(mdl.getMetadataLocations().size(), mdl2.getMetadataLocations().size());
    Assert.assertFalse(mdl.getSuspend());
    Assert.assertFalse(mdl2.getSuspend());
  }

}
