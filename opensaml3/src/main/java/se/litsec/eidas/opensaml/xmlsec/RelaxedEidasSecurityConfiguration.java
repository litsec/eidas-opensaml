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
package se.litsec.eidas.opensaml.xmlsec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opensaml.xmlsec.DecryptionConfiguration;
import org.opensaml.xmlsec.EncryptionConfiguration;
import org.opensaml.xmlsec.SignatureSigningConfiguration;
import org.opensaml.xmlsec.SignatureValidationConfiguration;
import org.opensaml.xmlsec.encryption.support.EncryptionConstants;
import org.opensaml.xmlsec.encryption.support.RSAOAEPParameters;
import org.opensaml.xmlsec.impl.BasicDecryptionConfiguration;
import org.opensaml.xmlsec.impl.BasicSignatureSigningConfiguration;
import org.opensaml.xmlsec.impl.BasicSignatureValidationConfiguration;
import org.opensaml.xmlsec.signature.support.SignatureConstants;

import se.swedenconnect.opensaml.xmlsec.BasicExtendedEncryptionConfiguration;

/**
 * The algorithm requirements from version 1.2 of "eIDAS - Cryptographic requirements for the Interoperability
 * Framework" leaves out some of the commonly used algorithms which most likely will lead to interoperability issues if
 * we implement them strictly. The {@code RelaxedEidasSecurityConfiguration} class is a bit more forgiving, especially
 * when it comes to RSA-SHAxxx signature algorithms.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class RelaxedEidasSecurityConfiguration extends EidasSecurityConfiguration {

  /** {@inheritDoc} */
  @Override
  public String getProfileName() {
    return "eidas-relaxed";
  }

  /**
   * Will also allow the widespread AES-CBC block encryption algorithms.
   */
  @Override
  protected EncryptionConfiguration createDefaultEncryptionConfiguration() {
    BasicExtendedEncryptionConfiguration config = (BasicExtendedEncryptionConfiguration) super.createDefaultEncryptionConfiguration();

    List<String> dataEncryptionAlgorithms = new ArrayList<>(config.getDataEncryptionAlgorithms());
    dataEncryptionAlgorithms.addAll(Arrays.asList(
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES256,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES192,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES128));
    config.setDataEncryptionAlgorithms(dataEncryptionAlgorithms);
    
    // Currently, CEF software version 1.X does not decrypt if we use SHA-256 for RSA-OAEP ...
    //
    config.setRSAOAEPParameters(new RSAOAEPParameters(
      SignatureConstants.ALGO_ID_DIGEST_SHA1,
      EncryptionConstants.ALGO_ID_MGF1_SHA1,
      null));    

    return config;
  }

  /**
   * The {@link EidasSecurityConfiguration} implementation whitelists only the algorithms given in sections 3.2.1 and
   * 3.2.2 of "eIDAS - Cryptographic requirements for the Interoperability Framework". This implementation removes the
   * whitelisting and instead blacklists some of the algorithms that we really can't accept.
   */
  @Override
  protected DecryptionConfiguration createDefaultDecryptionConfiguration() {
    BasicDecryptionConfiguration config = (BasicDecryptionConfiguration) super.createDefaultDecryptionConfiguration();
    config.setWhitelistedAlgorithms(null);

    List<String> blacklistedAlgorithms = new ArrayList<>(config.getBlacklistedAlgorithms());
    blacklistedAlgorithms.addAll(Arrays.asList(
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_TRIPLEDES,
      EncryptionConstants.ALGO_ID_KEYWRAP_TRIPLEDES));
    config.setBlacklistedAlgorithms(blacklistedAlgorithms);

    return config;
  }

  /**
   * Will allow using RSA-SHAxxx signature algorithms.
   */
  @Override
  protected SignatureSigningConfiguration createDefaultSignatureSigningConfiguration() {
    BasicSignatureSigningConfiguration config = (BasicSignatureSigningConfiguration) super.createDefaultSignatureSigningConfiguration();

    List<String> signatureAlgorithms = new ArrayList<>(config.getSignatureAlgorithms());
    signatureAlgorithms.addAll(Arrays.asList(
      SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA256,
      SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA384,
      SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA512));
    config.setSignatureAlgorithms(signatureAlgorithms);

    return config;
  }

  /**
   * The {@link EidasSecurityConfiguration} implementation whitelists only the algorithms given in section 3.3 of "eIDAS
   * - Cryptographic requirements for the Interoperability Framework". This implementation removes the whitelisting and
   * instead blacklists some of the algorithms that we really can't accept.
   */
  @Override
  protected SignatureValidationConfiguration createDefaultSignatureValidationConfiguration() {
    BasicSignatureValidationConfiguration config = (BasicSignatureValidationConfiguration) super.getDefaultSignatureValidationConfiguration(); 
    
    config.setWhitelistedAlgorithms(null);
    
    List<String> blackListedAlgorithms = new ArrayList<>(config.getBlacklistedAlgorithms());
    blackListedAlgorithms.addAll(Arrays.asList(
      SignatureConstants.ALGO_ID_DIGEST_SHA1,
      SignatureConstants.ALGO_ID_DIGEST_SHA224,
      SignatureConstants.ALGO_ID_DIGEST_RIPEMD160,
      SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA1,
      SignatureConstants.ALGO_ID_SIGNATURE_DSA_SHA1,
      SignatureConstants.ALGO_ID_MAC_HMAC_SHA256,
      SignatureConstants.ALGO_ID_MAC_HMAC_SHA384,
      SignatureConstants.ALGO_ID_MAC_HMAC_SHA512,
      SignatureConstants.ALGO_ID_MAC_HMAC_SHA1));
    config.setBlacklistedAlgorithms(blackListedAlgorithms);
    
    return config;
  }

}
