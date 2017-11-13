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
package se.litsec.eidas.opensaml2.config;

import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.XMLConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bootstrapper class for the eIDAS library. 
 * <p>
 * Note that OpenSAML needs to be initialized before invoking the {@code EidasBootstrap}.
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 * @see DefaultBootstrap
 */
public class EidasBootstrap {
  
  /** Class logger. */
  private final Logger log = LoggerFactory.getLogger(EidasBootstrap.class);
  
  /** Config resources. */
  private static String[] configs = {
      "/saml2-eidas-config.xml"
  };
  
  /** The instance. */
  private static final EidasBootstrap INSTANCE = new EidasBootstrap();
  
  /**
   * Returns the bootstrapper instance.
   * 
   * @return the bootstrapper instance
   */
  public static EidasBootstrap getInstance() {
    return INSTANCE;
  }
  
  /**
   * Bootstrap method for this library.
   * 
   * @throws ConfigurationException
   *           for config errors
   */
  public void bootstrap() throws ConfigurationException {

    XMLConfigurator configurator = new XMLConfigurator();

    for (String config : configs) {
      log.debug("Loading XMLTooling configuration " + config);
      configurator.load(Configuration.class.getResourceAsStream(config));
    }
  }

  // Hidden
  private EidasBootstrap() {
  }

}
