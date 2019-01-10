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
package se.litsec.eidas.opensaml.common;

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
  
  /** The eIDAS metadata service list XML namespace. */
  public static final String EIDAS_SERVICELIST_NS = "http://eidas.europa.eu/metadata/servicelist";
  
  /** The eIDAS metadata service list namespace prefix. */
  public static final String EIDAS_SERVICELIST_PREFIX = "ser";

  /** The Authentication Context URI for the "Low" Level of Assurance. */
  public static final String EIDAS_LOA_LOW = "http://eidas.europa.eu/LoA/low";

  /**
   * The Authentication Context URI for the "Low" Level of Assurance where the eID scheme is not notified by the
   * eIDAS country. <b>Note</b>: URI is not yet determined.
   */
  public static final String EIDAS_LOA_LOW_NON_NOTIFIED = "http://eidas.europa.eu/LoA/NotNotified/low";

  /** The Authentication Context URI for the "Substantial" Level of Assurance. */
  public static final String EIDAS_LOA_SUBSTANTIAL = "http://eidas.europa.eu/LoA/substantial";

  /**
   * The Authentication Context URI for the "Substantial" Level of Assurance where the eID scheme is not notified by the
   * eIDAS country. <b>Note</b>: URI is not yet determined.
   */
  public static final String EIDAS_LOA_SUBSTANTIAL_NON_NOTIFIED = "http://eidas.europa.eu/LoA/NotNotified/substantial";

  /** The Authentication Context URI for the "High" Level of Assurance. */
  public static final String EIDAS_LOA_HIGH = "http://eidas.europa.eu/LoA/high";

  /**
   * The Authentication Context URI for the "High" Level of Assurance where the eID scheme is not notified by the eIDAS
   * country. <b>Note</b>: URI is not yet determined.
   */
  public static final String EIDAS_LOA_HIGH_NON_NOTIFIED = "http://eidas.europa.eu/LoA/NotNotified/high";
  
  /**
   * Attribute name for the entity attribute representing an eIDAS protocol version, as described in section 3.4
   * of the "eIDAS Message Format" specification.
   */
  public static final String EIDAS_PROTOCOL_VERSION_ATTRIBUTE_NAME = "http://eidas.europa.eu/entity-attributes/protocol-version";
  
  /**
   * Attribute name for the entity attribute representing an eIDAS application identifier, as described in section 3.4
   * of the "eIDAS Message Format" specification.
   */
  public static final String EIDAS_APPLICATION_IDENTIFIER_ATTRIBUTE_NAME = "http://eidas.europa.eu/entity-attributes/application-identifier";

  private EidasConstants() {
  }

}
