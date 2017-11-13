/*
 * Copyright 2016-2017 Litsec AB
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
package se.litsec.eidas.opensaml2;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.junit.BeforeClass;
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.XMLObjectBuilder;
import org.opensaml.xml.XMLObjectBuilderFactory;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.parse.ParserPool;
import org.opensaml.xml.parse.XMLParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml2.config.EidasBootstrap;

/**
 * Abstract base class that initializes OpenSAML for test classes.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public abstract class OpenSAMLTestBase {

  /** Logger instance. */
  private static Logger logger = LoggerFactory.getLogger(OpenSAMLTestBase.class);

  /** Builder features for the default parser pool. */
  private static final Map<String, Boolean> builderFeatures;

  static {
    builderFeatures = new HashMap<String, Boolean>();
    builderFeatures.put("http://apache.org/xml/features/disallow-doctype-decl", Boolean.TRUE);
    builderFeatures.put("http://apache.org/xml/features/validation/schema/normalized-value", Boolean.FALSE);
    builderFeatures.put("http://javax.xml.XMLConstants/feature/secure-processing", Boolean.TRUE);
  }

  /**
   * Initializes the OpenSAML library.
   * 
   * @throws Exception
   *           for init errors
   */
  @BeforeClass
  public static void initializeOpenSAML() throws Exception {

    logger.debug("Initializing OpenSAML 2.X library ...");
    DefaultBootstrap.bootstrap();
    EidasBootstrap.getInstance().bootstrap();
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
    XMLObjectBuilderFactory builderFactory = Configuration.getBuilderFactory();
    XMLObjectBuilder<?> builder = builderFactory.getBuilder(elementName);
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
    return (XMLObjectBuilder<T>) Configuration.getBuilderFactory().getBuilder(elementName);
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
    return Configuration.getMarshallerFactory().getMarshaller(object).marshall(object);
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
    XMLObject xmlObject = Configuration.getUnmarshallerFactory().getUnmarshaller(xml).unmarshall(xml);
    return targetClass.cast(xmlObject);
  }

  /**
   * Unmarshall a Document from an InputSteam.
   * 
   * @param parserPool
   *          the ParserPool instance to use
   * @param inputStream
   *          the InputStream to unmarshall
   * @return the unmarshalled XMLObject
   * @throws XMLParserException
   *           if there is a problem parsing the input data
   * @throws UnmarshallingException
   *           if there is a problem unmarshalling the parsed DOM
   */
  public static XMLObject unmarshallFromInputStream(ParserPool parserPool, InputStream inputStream) throws XMLParserException,
      UnmarshallingException {

    Document messageDoc = parserPool.parse(inputStream);
    Element messageElem = messageDoc.getDocumentElement();
    return Configuration.getUnmarshallerFactory().getUnmarshaller(messageElem).unmarshall(messageElem);
  }

}
