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
