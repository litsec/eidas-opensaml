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
    
    SPType type2 = OpenSAMLTestBase.createSamlObject(SPType.class);
    Assert.assertNotNull(type2);
  }

}
