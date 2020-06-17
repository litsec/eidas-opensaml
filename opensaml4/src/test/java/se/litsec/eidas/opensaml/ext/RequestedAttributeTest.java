/*
 * Copyright 2016-2020 Litsec AB
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
import org.opensaml.saml.saml2.core.Attribute;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;
import se.litsec.eidas.opensaml.common.EidasConstants;
import se.litsec.eidas.opensaml.ext.attributes.AttributeConstants;

/**
 * Test cases for {@link RequestedAttribute}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class RequestedAttributeTest extends OpenSAMLTestBase {

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {
    
    RequestedAttribute ra = OpenSAMLTestBase.createSamlObject(RequestedAttribute.class, RequestedAttribute.DEFAULT_ELEMENT_NAME);
    
    ra.setName(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME);
    ra.setFriendlyName(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME);
    ra.setIsRequired(Boolean.TRUE);
    ra.setNameFormat(Attribute.URI_REFERENCE);
    Assert.assertTrue(ra.getAttributeValues().isEmpty());
    Assert.assertEquals(EidasConstants.EIDAS_NS, ra.getElementQName().getNamespaceURI());
    Assert.assertEquals(RequestedAttribute.DEFAULT_ELEMENT_LOCAL_NAME, ra.getElementQName().getLocalPart());
    Assert.assertEquals(EidasConstants.EIDAS_PREFIX, ra.getElementQName().getPrefix());
    
    Element element = OpenSAMLTestBase.marshall(ra);    
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME, element.getAttribute(Attribute.NAME_ATTTRIB_NAME));
    Assert.assertEquals(AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME, element.getAttribute(Attribute.FRIENDLY_NAME_ATTRIB_NAME));
    Assert.assertEquals(Boolean.TRUE.toString(), element.getAttribute(org.opensaml.saml.saml2.metadata.RequestedAttribute.IS_REQUIRED_ATTRIB_NAME));
    Assert.assertEquals(Attribute.URI_REFERENCE, element.getAttribute(Attribute.NAME_FORMAT_ATTRIB_NAME));
    
    RequestedAttribute ra2 = OpenSAMLTestBase.unmarshall(element, RequestedAttribute.class);
    Assert.assertEquals(ra.getName(), ra2.getName());
    Assert.assertEquals(ra.getFriendlyName(), ra2.getFriendlyName());
    Assert.assertEquals(ra.getNameFormat(), ra2.getNameFormat());
    Assert.assertEquals(ra.isRequiredXSBoolean(), ra2.isRequiredXSBoolean());
    Assert.assertEquals(ra.getElementQName(), ra2.getElementQName());
    Assert.assertTrue(ra2.getAttributeValues().isEmpty());
  }

}
