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
package se.litsec.eidas.opensaml.metadata;

import java.security.cert.X509Certificate;

import org.junit.Assert;
import org.junit.Test;
import org.opensaml.xmlsec.signature.support.SignatureException;

import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@code MetadataServiceList} and {@code MetadataServiceListSignatureValidator}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataServiceListTest extends OpenSAMLTestBase {
  
  /**
   * Tests that we can parse a "real life" metadata service list.
   * @throws Exception for errors
   */
  @Test
  public void testDecode() throws Exception {
                
    MetadataServiceList mdsl = OpenSAMLTestBase.unmarshall(loadElement("mdservicelist.xml"), MetadataServiceList.class);
    
    Assert.assertTrue(mdsl.isSigned());
    
    Assert.assertEquals(MetadataServiceListVersion.VERSION_10, mdsl.getVersion());
    Assert.assertEquals("Swedish E-Identification Board", mdsl.getSchemeInformation().getIssuerName());
    Assert.assertEquals("urn:se:elegnamnden:eidas:mdlist:local", mdsl.getSchemeInformation().getSchemeIdentifier());
    Assert.assertEquals("SE", mdsl.getSchemeInformation().getSchemeTerritory());
    Assert.assertEquals(14, mdsl.getMetadataLists().size());
    Assert.assertEquals("file:///opt/webapp/configEidas/aggregation/mdServiceList.xml", 
      mdsl.getDistributionPoints().getDistributionPoints().get(0).getValue());
  }
  
  /**
   * Tests signature validation.
   * @throws Exception for errors
   */
  @Test
  public void testSignatureValidate() throws Exception {
    MetadataServiceList mdsl = OpenSAMLTestBase.unmarshall(loadElement("mdservicelist.xml"), MetadataServiceList.class);
    X509Certificate cert = loadCertificate("eidas-servicelist-validation-cert.crt");
    
    MetadataServiceListSignatureValidator validator = new MetadataServiceListSignatureValidator();
    validator.validateSignature(mdsl, cert);
  }
  
  /**
   * Tests that signature validation fails if we supply the wrong cert.
   * @throws Exception for errors
   */
  @Test(expected = SignatureException.class)
  public void testSignatureValidateWrongCert() throws Exception {
    MetadataServiceList mdsl = OpenSAMLTestBase.unmarshall(loadElement("mdservicelist.xml"), MetadataServiceList.class);
    X509Certificate cert = loadCertificate("Litsec_SAML_Signing.crt");
    
    MetadataServiceListSignatureValidator validator = new MetadataServiceListSignatureValidator();
    validator.validateSignature(mdsl, cert);    
  }
  
  /**
   * Tests that signature validation fails if the signature is bad.
   * @throws Exception for errors
   */
  @Test(expected = SignatureException.class)
  public void testSignatureValidateBadSignature() throws Exception {
    MetadataServiceList mdsl = OpenSAMLTestBase.unmarshall(loadElement("mdservicelist-badsign.xml"), MetadataServiceList.class);
    X509Certificate cert = loadCertificate("eidas-servicelist-validation-cert.crt");
    
    MetadataServiceListSignatureValidator validator = new MetadataServiceListSignatureValidator();
    validator.validateSignature(mdsl, cert);    
  }  

}
