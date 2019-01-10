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
 * Test cases for {@code DistributionPoints}. 
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DistributionPointsTest extends OpenSAMLTestBase {

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {
   
    DistributionPoints points = OpenSAMLTestBase.createSamlObject(DistributionPoints.class, DistributionPoints.DEFAULT_ELEMENT_NAME);
    
    DistributionPoint dp1 = OpenSAMLTestBase.createSamlObject(DistributionPoint.class, DistributionPoint.DEFAULT_ELEMENT_NAME);
    dp1.setValue("https://www.example.com/1");
    
    DistributionPoint dp2 = OpenSAMLTestBase.createSamlObject(DistributionPoint.class, DistributionPoint.DEFAULT_ELEMENT_NAME);
    dp2.setValue("https://www.example.com/2");
    
    points.getDistributionPoints().add(dp1);
    points.getDistributionPoints().add(dp2);

    Element element = OpenSAMLTestBase.marshall(points);
        
    DistributionPoints points2 = OpenSAMLTestBase.unmarshall(element, DistributionPoints.class);
    Assert.assertEquals(points.getDistributionPoints().size(), points2.getDistributionPoints().size());
    Assert.assertEquals(points.getDistributionPoints().get(0).getValue(), points2.getDistributionPoints().get(0).getValue());
    Assert.assertEquals(points.getDistributionPoints().get(1).getValue(), points2.getDistributionPoints().get(1).getValue());
  }

}
