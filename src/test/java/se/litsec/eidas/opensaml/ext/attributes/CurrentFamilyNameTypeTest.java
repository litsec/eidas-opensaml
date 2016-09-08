/*
 * The eidas-opensaml project is an open-source package that extends OpenSAML
 * with definitions for the eIDAS Framework.
 *
 * More details on <https://github.com/litsec/eidas-opensaml>
 * Copyright (C) 2016 Litsec AB
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package se.litsec.eidas.opensaml.ext.attributes;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@link CurrentFamilyNameType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentFamilyNameTypeTest extends OpenSAMLTestBase {

  /**
   * Test to marhall and unmarshall the object.
   * 
   * @throws Exception
   *           for errors
   */
  @Test
  public void testMarshallUnmarshall() throws Exception {
    
    CurrentFamilyNameType cfn = OpenSAMLTestBase.createSamlObject(CurrentFamilyNameType.class, CurrentFamilyNameType.TYPE_NAME);    
    cfn.setValue("Karlsson");
    
    Assert.assertEquals("Karlsson", cfn.getValue());
    Assert.assertTrue(cfn.getLatinScript());
    Assert.assertNull(cfn.getLatinScriptXSBooleanValue());
    
    Element element = OpenSAMLTestBase.marshall(cfn); 
    Assert.assertNotNull(element);
    
    //System.out.println(SerializeSupport.prettyPrintXML(element));
    
    System.out.println(SerializeSupport.nodeToString(element));
    
    CurrentFamilyNameType cfn2 = OpenSAMLTestBase.unmarshall(element, CurrentFamilyNameType.class);
    Assert.assertEquals(cfn.getValue(), cfn2.getValue());
    Assert.assertEquals(cfn.getLatinScript(), cfn2.getLatinScript());
    Assert.assertEquals(cfn.getElementQName(), cfn2.getElementQName());
  }

}
