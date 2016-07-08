package se.litsec.eidas.opensaml;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.junit.BeforeClass;
import org.opensaml.core.config.ConfigurationService;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.XMLObjectBuilderFactory;
import org.opensaml.core.xml.config.XMLObjectProviderRegistry;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.shibboleth.utilities.java.support.xml.BasicParserPool;

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
    
    logger.debug("Initializing OpenSAML 3.X library ...");
    
    InitializationService.initialize();
    
    XMLObjectProviderRegistry registry = null;
    synchronized (ConfigurationService.class) {
      registry = ConfigurationService.get(XMLObjectProviderRegistry.class);
      if (registry == null) {
        logger.debug("XMLObjectProviderRegistry did not exist in ConfigurationService, will be created");
        registry = new XMLObjectProviderRegistry();
        ConfigurationService.register(XMLObjectProviderRegistry.class, registry);
      }
    }
    
    BasicParserPool basicParserPool = new BasicParserPool();
    basicParserPool.setMaxPoolSize(100);
    basicParserPool.setCoalescing(true);
    basicParserPool.setIgnoreComments(true);
    basicParserPool.setIgnoreElementContentWhitespace(true);
    basicParserPool.setNamespaceAware(true);
    basicParserPool.setBuilderFeatures(builderFeatures);
    basicParserPool.initialize();
    registry.setParserPool(basicParserPool);
  }
  
  /**
   * Utility method for creating an OpenSAML object using the default element name of the class.
   * <p>
   * Note: The field DEFAULT_ELEMENT_NAME of the given class will be used as the object's element name.
   * </p>
   * 
   * @param clazz
   *          the class to create
   * @return the XML object
   * @see #createSamlObject(Class, QName)
   */
  public static <T extends XMLObject> T createSamlObject(Class<T> clazz) {
    return createSamlObject(clazz, getDefaultElementName(clazz));
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
  
}
