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
package se.litsec.eidas.opensaml.examples;

import java.io.InputStream;

import org.junit.Test;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeStatement;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;

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
    Assertion assertion = (Assertion) XMLObjectSupport.unmarshallFromInputStream(XMLObjectProviderRegistrySupport.getParserPool(), is);
    
    printAssertion(assertion);
  }

}
