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

import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.junit.Assert;
import org.junit.Test;
import org.opensaml.security.x509.X509Support;
import org.opensaml.xmlsec.signature.KeyInfo;
import org.opensaml.xmlsec.signature.X509Data;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.codec.Base64Support;
import net.shibboleth.utilities.java.support.codec.EncodingException;
import se.litsec.eidas.opensaml.OpenSAMLTestBase;

/**
 * Test cases for {@code MetadataLocation}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataLocationTest extends OpenSAMLTestBase {

  private static final String PEM_CERT = "-----BEGIN CERTIFICATE-----" + "\n" +
      "MIIDLDCCAhSgAwIBAgIUCfpIbZSBf3OU/ZtDgB9euCA3NMswDQYJKoZIhvcNAQEL" + "\n" +
      "BQAwHjEcMBoGA1UEAwwTZXVub2RlLmVpZGFzdGVzdC5zZTAeFw0xNjExMDIxMTMx" + "\n" +
      "MDlaFw0zNjExMDIxMTMxMDlaMB4xHDAaBgNVBAMME2V1bm9kZS5laWRhc3Rlc3Qu" + "\n" +
      "c2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCQHpcf7llXXzEqfUzZ" + "\n" +
      "MF8HKrdFJSu6T/dxIf0nD+I6D9p2yMrEjfDy2hF+y8AwTWH5sTrFqtvYNF9aubzM" + "\n" +
      "JsX3C9LzdLXMhtXE1zoiuSfvh6aKSTkqWzU+3c+cRTuBPFdaj/UCWrbEyuAVt3br" + "\n" +
      "lfXyEsh3MsL7M9t+wbwK00Vk4jDwiWGqLD5ACwVb/BqKubagDY3QAAC2pZg8FAOz" + "\n" +
      "3MrQ9FykKhtBGVjGN/Q0el2ROeECAV8pePjagkOQd/f8sNkfGSuF8jx6MtnAi1Gw" + "\n" +
      "vSW7wAtCF1/mHrUBiG3SUeD44Q8bXntIoVwJs7o8w/ZHcETpnzkMtTqQqv3ApVQo" + "\n" +
      "ubJ7AgMBAAGjYjBgMB0GA1UdDgQWBBR04hoofjW1qWbDPzv5Q1YuTa0V5TA/BgNV" + "\n" +
      "HREEODA2ghNldW5vZGUuZWlkYXN0ZXN0LnNlhh9odHRwczovL2V1bm9kZS5laWRh" + "\n" +
      "c3Rlc3Quc2UvaWRwMA0GCSqGSIb3DQEBCwUAA4IBAQCLVCNkeAdQp71EpknGfCUA" + "\n" +
      "DTvYhFUHpqCmTdxFmPrNE5ZWyk5ajOP2Uzk5FZYqki7cVqDWbwFOvEfFJNEljc+3" + "\n" +
      "3jOqDmToeJiWkI91JC03TFBeXB+1jh0YIJomklLTVG78HNL6mtCWsPyWCpdVDeKJ" + "\n" +
      "2JRG9+CFcjJLD7isx0YPBSy89HAeR/yXp4tjMDuB7NlSwWgvkh4tOWsJ+zH/WH9k" + "\n" +
      "DQ9vOQH6PCN+lQfb+X6x7UF7Fap0DEz7cz5myElPMMSiho3Tk4yBwzgDrg466dUH" + "\n" +
      "y82Wc5xMSbKEroIHfyRtaNG7qJxeha1I1x4fejlZRtGOPP+i+RjXq8GbksSxTYPV" + "\n" +
      "-----END CERTIFICATE-----";

  private static X509Certificate CERTIFICATE;

  static {
    try {
      CERTIFICATE = X509Support.decodeCertificate(PEM_CERT.getBytes());
    }
    catch (CertificateException e) {
      throw new SecurityException(e);
    }
  }

  /**
   * Test marshalling and unmarshalling.
   * 
   * @throws Exception
   */
  @Test
  public void testMarshallAndUnmarshall() throws Exception {
    
    MetadataLocation mdl = createMetadataLocation();


    Element element = OpenSAMLTestBase.marshall(mdl);

    MetadataLocation mdl2 = OpenSAMLTestBase.unmarshall(element, MetadataLocation.class);
    Assert.assertEquals(mdl.getEndpoints().size(), mdl2.getEndpoints().size());
    Assert.assertEquals(mdl.getEndpoints().get(0).getEndpointType(), mdl2.getEndpoints().get(0).getEndpointType());
    Assert.assertEquals(mdl.getEndpoints().get(0).getEntityID(), mdl2.getEndpoints().get(0).getEntityID());
    Assert.assertEquals(mdl.getEndpoints().get(1).getEndpointType(), mdl2.getEndpoints().get(1).getEndpointType());
    Assert.assertEquals(mdl.getEndpoints().get(1).getEntityID(), mdl2.getEndpoints().get(1).getEntityID());

    Assert.assertEquals(mdl.getKeyInfo().getX509Datas().get(0).getX509Certificates().get(0).getValue(), 
      mdl2.getKeyInfo().getX509Datas().get(0).getX509Certificates().get(0).getValue());
    
    Assert.assertEquals(mdl.getLocation(), mdl2.getLocation());
  }
  
  public static MetadataLocation createMetadataLocation() throws CertificateEncodingException, EncodingException {
    MetadataLocation mdl = OpenSAMLTestBase.createSamlObject(MetadataLocation.class, MetadataLocation.DEFAULT_ELEMENT_NAME);

    Endpoint ep1 = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep1.setEndpointType(Endpoint.PROXY_SERVICE_ENDPOINT_TYPE);
    ep1.setEntityID("http://eidas.node.se/proxy");

    Endpoint ep2 = OpenSAMLTestBase.createSamlObject(Endpoint.class, Endpoint.DEFAULT_ELEMENT_NAME);
    ep2.setEndpointType(Endpoint.CONNECTOR_ENDPOINT_TYPE);
    ep2.setEntityID("http://eidas.node.se/connector");

    mdl.getEndpoints().add(ep1);
    mdl.getEndpoints().add(ep2);

    // KeyInfo
    {
      org.opensaml.xmlsec.signature.X509Certificate cert = OpenSAMLTestBase.createSamlObject(
        org.opensaml.xmlsec.signature.X509Certificate.class, org.opensaml.xmlsec.signature.X509Certificate.DEFAULT_ELEMENT_NAME);
      cert.setValue(Base64Support.encode(CERTIFICATE.getEncoded(), true));

      X509Data x509Data = OpenSAMLTestBase.createSamlObject(X509Data.class, X509Data.DEFAULT_ELEMENT_NAME);
      x509Data.getX509Certificates().add(cert);

      KeyInfo keyInfo = OpenSAMLTestBase.createSamlObject(KeyInfo.class, KeyInfo.DEFAULT_ELEMENT_NAME);
      keyInfo.getX509Datas().add(x509Data);

      mdl.setKeyInfo(keyInfo);
    }
    mdl.setLocation("https://eid.litsec.se/eidas/metadatalist");
    
    return mdl;
  }
  
  /**
   * Tests the setX509Certificate method.
   * 
   * @throws Exception
   */
  @Test
  public void testSetX509Certificate() throws Exception {
    
    // Assign one KeyInfo with brute-force
    MetadataLocation mdl = OpenSAMLTestBase.createSamlObject(MetadataLocation.class, MetadataLocation.DEFAULT_ELEMENT_NAME);
    
    org.opensaml.xmlsec.signature.X509Certificate cert = OpenSAMLTestBase.createSamlObject(
      org.opensaml.xmlsec.signature.X509Certificate.class, org.opensaml.xmlsec.signature.X509Certificate.DEFAULT_ELEMENT_NAME);
    cert.setValue(Base64Support.encode(CERTIFICATE.getEncoded(), true));

    X509Data x509Data = OpenSAMLTestBase.createSamlObject(X509Data.class, X509Data.DEFAULT_ELEMENT_NAME);
    x509Data.getX509Certificates().add(cert);

    KeyInfo keyInfo = OpenSAMLTestBase.createSamlObject(KeyInfo.class, KeyInfo.DEFAULT_ELEMENT_NAME);
    keyInfo.getX509Datas().add(x509Data);

    mdl.setKeyInfo(keyInfo);
    
    // And the other one using setX509Certificate
    MetadataLocation mdl2 = OpenSAMLTestBase.createSamlObject(MetadataLocation.class, MetadataLocation.DEFAULT_ELEMENT_NAME);
    mdl2.setX509Certificate(CERTIFICATE);
    
    // Assert that the KeyInfo elements are the same ...
    //
    Assert.assertEquals(mdl.getKeyInfo().getX509Datas().get(0).getX509Certificates().get(0).getValue(), 
      mdl2.getKeyInfo().getX509Datas().get(0).getX509Certificates().get(0).getValue());    
  }

}
