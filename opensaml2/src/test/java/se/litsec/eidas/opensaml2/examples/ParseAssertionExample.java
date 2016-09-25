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
package se.litsec.eidas.opensaml2.examples;

import java.io.InputStream;

import org.junit.Test;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.xml.Configuration;

import se.litsec.eidas.opensaml2.OpenSAMLTestBase;

/**
 * Example code for how to process an eIDAS SAML {@code Assertion}.
 * <p>
 * We parse the {@code Assertion} given as an example in section 6.5 of
 * <a href="https://joinup.ec.europa.eu/sites/default/files/eidas_message_format_v1.0.pdf">eIDAS SAML Message Format</a>.
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class ParseAssertionExample extends OpenSAMLTestBase {
  
  public static void printAssertion(Assertion assertion) {
    
    System.out.println("Attributes:");
    if (assertion.getAttributeStatements().isEmpty()) {
      System.out.println("  No attribute statement available in assertion");
    }
    else {
      AttributeStatement as = assertion.getAttributeStatements().get(0);
      for (Attribute attr : as.getAttributes()) {
        System.out.println("  " + attr.getName());        
      }
    }
    
    // TODO
    
  }

  @Test
  public void parseAssertionExample() throws Exception {
    InputStream is = this.getClass().getResourceAsStream("/example-assertion.xml");
    Assertion assertion = (Assertion) OpenSAMLTestBase.unmarshallFromInputStream(Configuration.getParserPool(), is);
    
    printAssertion(assertion);
  }

}
