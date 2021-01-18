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
package se.litsec.eidas.opensaml;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.junit.BeforeClass;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.XMLObjectBuilderFactory;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.security.x509.X509Credential;
import org.opensaml.security.x509.impl.KeyStoreX509CredentialAdapter;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.XMLParserException;
import se.swedenconnect.opensaml.OpenSAMLInitializer;
import se.swedenconnect.opensaml.OpenSAMLSecurityExtensionConfig;

/**
 * Abstract base class that initializes OpenSAML for test classes.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public abstract class OpenSAMLTestBase {

  /** Builder features for the default parser pool. */
  private static final Map<String, Boolean> builderFeatures;

  /** Factory for creating certificates. */
  private static CertificateFactory factory = null;

  static {
    builderFeatures = new HashMap<String, Boolean>();
    builderFeatures.put("http://apache.org/xml/features/disallow-doctype-decl", Boolean.TRUE);
    builderFeatures.put("http://apache.org/xml/features/validation/schema/normalized-value", Boolean.FALSE);
    builderFeatures.put("http://javax.xml.XMLConstants/feature/secure-processing", Boolean.TRUE);

    try {
      factory = CertificateFactory.getInstance("X.509");
    }
    catch (CertificateException e) {
      throw new SecurityException(e);
    }
  }

  /**
   * Initializes the OpenSAML library.
   * 
   * @throws Exception
   *           for init errors
   */
  @BeforeClass
  public static void initializeOpenSAML() throws Exception {

    OpenSAMLInitializer.getInstance()
      .initialize(
        new OpenSAMLSecurityExtensionConfig());
  }

  /**
   * Utility method for creating an OpenSAML object given its element name.
   * 
   * @param clazz
   *          the class to create
   * @param elementName
   *          the element name for the XML object to create
   * @return the XML object
   */
  public static <T extends XMLObject> T createSamlObject(Class<T> clazz, QName elementName) {
    if (!XMLObject.class.isAssignableFrom(clazz)) {
      throw new RuntimeException(String.format("%s is not a XMLObject class", clazz.getName()));
    }
    XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport.getBuilderFactory();
    XMLObjectBuilder<? extends XMLObject> builder = builderFactory.getBuilder(elementName);
    if (builder == null) {
      // No builder registered for the given element name. Try creating a builder for the default element name.
      builder = builderFactory.getBuilder(getDefaultElementName(clazz));
    }
    Object object = builder.buildObject(elementName);
    return clazz.cast(object);
  }

  /**
   * Returns the default element name for the supplied class
   * 
   * @param clazz
   *          class to check
   * @return the default QName
   */
  public static <T extends XMLObject> QName getDefaultElementName(Class<T> clazz) {
    try {
      return (QName) clazz.getDeclaredField("DEFAULT_ELEMENT_NAME").get(null);
    }
    catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns the builder object that can be used to build object for the given element name.
   * 
   * @param elementName
   *          the element name for the XML object that the builder should return
   * @return a builder object
   */
  @SuppressWarnings("unchecked")
  public static <T extends XMLObject> XMLObjectBuilder<T> getBuilder(QName elementName) {
    return (XMLObjectBuilder<T>) XMLObjectProviderRegistrySupport.getBuilderFactory().getBuilder(elementName);
  }

  /**
   * Marshalls the supplied {@code XMLObject} into an {@code Element}.
   * 
   * @param object
   *          the object to marshall
   * @return an XML element
   * @throws MarshallingException
   *           for marshalling errors
   */
  public static <T extends XMLObject> Element marshall(T object) throws MarshallingException {
    return XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(object).marshall(object);
  }

  /**
   * Unmarshalls the supplied element into the given type.
   * 
   * @param xml
   *          the DOM (XML) to unmarshall
   * @param targetClass
   *          the required class
   * @return an {@code XMLObject} of the given type
   * @throws UnmarshallingException
   *           for unmarshalling errors
   */
  public static <T extends XMLObject> T unmarshall(Element xml, Class<T> targetClass) throws UnmarshallingException {
    XMLObject xmlObject = XMLObjectProviderRegistrySupport.getUnmarshallerFactory().getUnmarshaller(xml).unmarshall(xml);
    return targetClass.cast(xmlObject);
  }

  /**
   * Loads an XML element from file.
   * 
   * @param systemResource
   *          the file
   * @return the element
   * @throws XMLParserException
   *           for parsing errors
   */
  public static Element loadElement(String systemResource) throws XMLParserException {
    InputStream serviceListStream = ClassLoader.getSystemResourceAsStream(systemResource);
    return XMLObjectProviderRegistrySupport.getParserPool().parse(serviceListStream).getDocumentElement();
  }

  /**
   * Loads a certificate from file (system resource).
   * 
   * @param systemResource
   *          the certificate file
   * @return a certificate
   * @throws CertificateException
   *           for decoding errors
   */
  public static X509Certificate loadCertificate(String systemResource) throws CertificateException {
    InputStream certStream = ClassLoader.getSystemResourceAsStream(systemResource);
    return (X509Certificate) factory.generateCertificate(certStream);
  }

  /**
   * Loads a key store.
   * 
   * @param keyStoreStream
   *          the stream for the keystore
   * @param keyStorePassword
   *          the password
   * @param keyStoreType
   *          the type
   * @return a {@code KeyStore} object
   * @throws KeyStoreException
   *           for key store errors
   * @throws IOException
   *           if the key store cannot be found
   */
  public static KeyStore loadKeyStore(InputStream keyStoreStream, String keyStorePassword, String keyStoreType) throws KeyStoreException,
      IOException {
    try {
      KeyStore keyStore = keyStoreType != null ? KeyStore.getInstance(keyStoreType) : KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(keyStoreStream, keyStorePassword.toCharArray());
      return keyStore;
    }
    catch (NoSuchAlgorithmException | CertificateException e) {
      throw new KeyStoreException(e);
    }
  }

  /**
   * Loads a key store and creates a credential.
   * 
   * @param keyStoreStream
   *          the stream for the keystore
   * @param keyStorePassword
   *          the key store password
   * @param alias
   *          the alias
   * @param keyPassword
   *          the key password
   * @return a credential
   * @throws KeyStoreException
   *           for key store errors
   * @throws IOException
   *           if the key store cannot be found
   */
  public static X509Credential loadKeyStoreCredential(InputStream keyStoreStream, String keyStorePassword, String alias, String keyPassword)
      throws KeyStoreException, IOException {
    KeyStore keyStore = loadKeyStore(keyStoreStream, keyStorePassword, "jks");
    return new KeyStoreX509CredentialAdapter(keyStore, alias, keyPassword.toCharArray());
  }

}
