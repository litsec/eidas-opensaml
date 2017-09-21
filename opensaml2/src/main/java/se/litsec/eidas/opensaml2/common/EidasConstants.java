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
package se.litsec.eidas.opensaml2.common;

/**
 * Constants for the OpenSAML eIDAS extension library.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class EidasConstants {
  
  /** The eIDAS SAML extension XML Namespace. */
  public static final String EIDAS_NS = "http://eidas.europa.eu/saml-extensions";
  
  /** The eIDAS SAML extension QName prefix. */
  public static final String EIDAS_PREFIX = "eidas";
  
  /** The eIDAS Natural Persons attribute XML Namespace. */
  public static final String EIDAS_NP_NS = "http://eidas.europa.eu/attributes/naturalperson";
  
  /** The eIDAS Natural Persons attribute QName prefix. */
  public static final String EIDAS_NP_PREFIX = "eidasnp";
  
  /** The Authentication Context URI for the "Low" Level of Assurance. */
  public static final String EIDAS_LOA_LOW = "http://eidas.europa.eu/LoA/low";

  /** The Authentication Context URI for the "Substantial" Level of Assurance. */
  public static final String EIDAS_LOA_SUBSTANTIAL = "http://eidas.europa.eu/LoA/substantial";
  
  /**
   * The Authentication Context URI for the "Substantial" Level of Assurance where the eID scheme is not notified by the
   * eIDAS country. <b>Note</b>: URI is not yet determined.
   */
  public static final String EIDAS_LOA_SUBSTANTIAL_NON_NOTIFIED = "http://eidas.europa.eu/LoA/substantial-nn";  

  /** The Authentication Context URI for the "High" Level of Assurance. */
  public static final String EIDAS_LOA_HIGH = "http://eidas.europa.eu/LoA/high";
  
  /**
   * The Authentication Context URI for the "High" Level of Assurance where the eID scheme is not notified by the eIDAS
   * country. <b>Note</b>: URI is not yet determined.
   */
  public static final String EIDAS_LOA_HIGH_NON_NOTIFIED = "http://eidas.europa.eu/LoA/high-nn";  
  
  private EidasConstants() {
  }

}
