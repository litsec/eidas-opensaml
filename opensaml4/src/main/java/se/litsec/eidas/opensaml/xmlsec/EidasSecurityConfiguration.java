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
package se.litsec.eidas.opensaml.xmlsec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.utils.Constants;
import org.opensaml.xmlsec.DecryptionConfiguration;
import org.opensaml.xmlsec.EncryptionConfiguration;
import org.opensaml.xmlsec.SignatureSigningConfiguration;
import org.opensaml.xmlsec.SignatureValidationConfiguration;
import org.opensaml.xmlsec.WhitelistBlacklistConfiguration.Precedence;
import org.opensaml.xmlsec.config.impl.DefaultSecurityConfigurationBootstrap;
import org.opensaml.xmlsec.encryption.support.EncryptionConstants;
import org.opensaml.xmlsec.encryption.support.RSAOAEPParameters;
import org.opensaml.xmlsec.impl.BasicDecryptionConfiguration;
import org.opensaml.xmlsec.impl.BasicSignatureSigningConfiguration;
import org.opensaml.xmlsec.impl.BasicSignatureValidationConfiguration;
import org.opensaml.xmlsec.signature.support.SignatureConstants;

import se.swedenconnect.opensaml.xmlsec.BasicExtendedEncryptionConfiguration;
import se.swedenconnect.opensaml.xmlsec.config.AbstractSecurityConfiguration;
import se.swedenconnect.opensaml.xmlsec.config.ExtendedDefaultSecurityConfigurationBootstrap;
import se.swedenconnect.opensaml.xmlsec.encryption.support.EcEncryptionConstants;

/**
 * A security configuration for OpenSAML according to version 1.2 of "eIDAS - Cryptographic requirements for the
 * Interoperability Framework".
 * 
 * <p>
 * Note: The people behind the eIDAS crypto requirements SHOULD have looked at what is available in major code
 * frameworks before setting up rigid requirements about bleeding edge cryptos. For example, RSA-PSS on a HSM in a Java
 * environment doesn't work and ECDH key-agreement isn't supported out of the box from OpenSAML (but by
 * https://github.com/swedenconnect/opensaml-security-ext). Security AND interoperability can exist, but IMHO they
 * forgot the latter.
 * </p>
 * <p>
 * Anyway. If you configure your OpenSAML application using the algorithms of {@code EidasSecurityConfiguration} you may
 * run into interop issues. Consider using the more relaxed version {@link RelaxedEidasSecurityConfiguration}.
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class EidasSecurityConfiguration extends AbstractSecurityConfiguration {

  /** {@inheritDoc} */
  @Override
  public String getProfileName() {
    return "eidas";
  }

  /**
   * Creates an encryption configuration for eIDAS according to section 3.2.1 and 3.2.2 of "eIDAS - Cryptographic
   * requirements for the Interoperability Framework".
   */
  @Override
  protected EncryptionConfiguration createDefaultEncryptionConfiguration() {

    BasicExtendedEncryptionConfiguration config = ExtendedDefaultSecurityConfigurationBootstrap.buildDefaultEncryptionConfiguration();

    // The extended encryption configuration that we get from ExtendedDefaultSecurityConfigurationBootstrap
    // sets the http://www.w3.org/2009/xmlenc11#ECDH-ES key agreement method.

    config.setDataEncryptionAlgorithms(Arrays.asList(
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES256_GCM,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES192_GCM,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES128_GCM));

    config.setKeyTransportEncryptionAlgorithms(Arrays.asList(
      EncryptionConstants.ALGO_ID_KEYTRANSPORT_RSAOAEP,
      EncryptionConstants.ALGO_ID_KEYTRANSPORT_RSAOAEP11,

      EncryptionConstants.ALGO_ID_KEYWRAP_AES256,
      EncryptionConstants.ALGO_ID_KEYWRAP_AES128));

    config.setRSAOAEPParameters(new RSAOAEPParameters(
      SignatureConstants.ALGO_ID_DIGEST_SHA256,
      EncryptionConstants.ALGO_ID_MGF1_SHA1,
      null));

    return config;
  }

  /**
   * Creates a decryption configuration for eIDAS according to section 3.2.1 and 3.2.2 of "eIDAS - Cryptographic
   * requirements for the Interoperability Framework".
   */
  @Override
  protected DecryptionConfiguration createDefaultDecryptionConfiguration() {

    BasicDecryptionConfiguration config = DefaultSecurityConfigurationBootstrap.buildDefaultDecryptionConfiguration();

    // Whitelist has precedence over blacklist, so we simply add the algorithms listed in
    // "eIDAS - Cryptographic requirements for the Interoperability Framework".
    //
    config.setWhitelistBlacklistPrecedence(Precedence.WHITELIST);
    config.setWhitelistedAlgorithms(Arrays.asList(
      // Content encryption
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES256_GCM,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES192_GCM,
      EncryptionConstants.ALGO_ID_BLOCKCIPHER_AES128_GCM,
      // Key transport
      EncryptionConstants.ALGO_ID_KEYTRANSPORT_RSAOAEP,
      EncryptionConstants.ALGO_ID_KEYTRANSPORT_RSAOAEP11,
      // Key wrapping
      EncryptionConstants.ALGO_ID_KEYWRAP_AES256,
      EncryptionConstants.ALGO_ID_KEYWRAP_AES128,
      // Key agreement
      EcEncryptionConstants.ALGO_ID_KEYAGREEMENT_ECDH_ES));

    return config;
  }

  /**
   * Creates a signature configuration for eIDAS according to section 3.3 of "eIDAS - Cryptographic requirements for the
   * Interoperability Framework".
   */
  @Override
  protected SignatureSigningConfiguration createDefaultSignatureSigningConfiguration() {

    BasicSignatureSigningConfiguration config = DefaultSecurityConfigurationBootstrap.buildDefaultSignatureSigningConfiguration();

    List<String> blacklistedAlgorithms = new ArrayList<>(config.getBlacklistedAlgorithms());
    blacklistedAlgorithms.addAll(Arrays.asList(
      SignatureConstants.ALGO_ID_DIGEST_SHA1,
      SignatureConstants.ALGO_ID_DIGEST_SHA224,
      SignatureConstants.ALGO_ID_DIGEST_RIPEMD160));
    config.setBlacklistedAlgorithms(blacklistedAlgorithms);

    // Yup. RSA-SHAxxx is not there!
    config.setSignatureAlgorithms(Arrays.asList(
      // ECDSA
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA256,
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA384,
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA512,

      // RSA-PSS
      XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256_MGF1,
      XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA384_MGF1,
      XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA512_MGF1));

    config.setSignatureReferenceDigestMethods(Arrays.asList(
      SignatureConstants.ALGO_ID_DIGEST_SHA256,
      SignatureConstants.ALGO_ID_DIGEST_SHA384,
      SignatureConstants.ALGO_ID_DIGEST_SHA512));

    return config;
  }

  /**
   * Creates a signature validation configuration for eIDAS according to section 3.3 of "eIDAS - Cryptographic
   * requirements for the Interoperability Framework".
   */
  @Override
  protected SignatureValidationConfiguration createDefaultSignatureValidationConfiguration() {

    BasicSignatureValidationConfiguration config = DefaultSecurityConfigurationBootstrap.buildDefaultSignatureValidationConfiguration();

    // Whitelist has precedence over blacklist, so we simply add the algorithms listed in
    // "eIDAS - Cryptographic requirements for the Interoperability Framework".
    //
    config.setWhitelistBlacklistPrecedence(Precedence.WHITELIST);
    config.setWhitelistedAlgorithms(Arrays.asList(
      // Digests
      SignatureConstants.ALGO_ID_DIGEST_SHA256,
      SignatureConstants.ALGO_ID_DIGEST_SHA384,
      SignatureConstants.ALGO_ID_DIGEST_SHA512,

      // Signature algorithms (EC-DSA and RSA-PSS)
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA256,
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA384,
      SignatureConstants.ALGO_ID_SIGNATURE_ECDSA_SHA512,
      Constants.XML_DSIG_NS_MORE_07_05 + "sha256-rsa-MGF1",
      Constants.XML_DSIG_NS_MORE_07_05 + "sha384-rsa-MGF1",
      Constants.XML_DSIG_NS_MORE_07_05 + "sha512-rsa-MGF1"));

    return config;
  }

}
