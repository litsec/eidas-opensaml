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
 * Test cases for {@code Endpoint}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class EndpointTest extends OpenSAMLTestBase {

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {
    
    Endpoint ep = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep.setEntityID("http://eidas.node.se");
    
    Element element = OpenSAMLTestBase.marshall(ep);
        
    Endpoint ep2 = OpenSAMLTestBase.unmarshall(element, Endpoint.class);
    Assert.assertEquals(ep.getEndpointType(), ep2.getEndpointType());
    Assert.assertEquals(ep.getEntityID(), ep2.getEntityID());    
  }
  
  /**
   * Tests the suspend-attribute
   * 
   * @throws Exception
   */
  @Test
  public void testSuspendAnyAttribute() throws Exception {
    
    Endpoint ep = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep.setEntityID("http://eidas.node.se");
    ep.setSuspend(true);
    
    Element element = OpenSAMLTestBase.marshall(ep);
        
    Endpoint ep2 = OpenSAMLTestBase.unmarshall(element, Endpoint.class);
    Assert.assertEquals(ep.getEndpointType(), ep2.getEndpointType());
    Assert.assertEquals(ep.getEntityID(), ep2.getEntityID());
    Assert.assertTrue(ep2.getSuspend());
    
    ep = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep.setEntityID("http://eidas.node.se");
    ep.setSuspend(false);
    
    element = OpenSAMLTestBase.marshall(ep);
        
    ep2 = OpenSAMLTestBase.unmarshall(element, Endpoint.class);
    Assert.assertEquals(ep.getEndpointType(), ep2.getEndpointType());
    Assert.assertEquals(ep.getEntityID(), ep2.getEntityID());
    Assert.assertFalse(ep2.getSuspend());    
  }
  
  /**
   * Tests the HideFromDiscovery-attribute
   * 
   * @throws Exception
   */
  @Test
  public void testHideFromDiscoveryAttribute() throws Exception {
    Endpoint ep = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep.setEntityID("http://eidas.node.se");
    ep.setHideFromDiscovery(true);
    
    Element element = OpenSAMLTestBase.marshall(ep);
        
    Endpoint ep2 = OpenSAMLTestBase.unmarshall(element, Endpoint.class);
    Assert.assertEquals(ep.getEndpointType(), ep2.getEndpointType());
    Assert.assertEquals(ep.getEntityID(), ep2.getEntityID());
    Assert.assertTrue(ep2.getHideFromDiscovery());
    
    ep = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep.setEntityID("http://eidas.node.se");
    
    element = OpenSAMLTestBase.marshall(ep);
        
    ep2 = OpenSAMLTestBase.unmarshall(element, Endpoint.class);
    Assert.assertEquals(ep.getEndpointType(), ep2.getEndpointType());
    Assert.assertEquals(ep.getEntityID(), ep2.getEntityID());
    Assert.assertFalse(ep2.getHideFromDiscovery());
  }
  
}
