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
package se.litsec.eidas.opensaml.ext.attributes;

import org.opensaml.core.xml.schema.XSBooleanValue;
import org.opensaml.core.xml.schema.XSString;

/**
 * Interface for eIDAS attribute values that may be represented as non-Latin scripts.
 * 
 * <p>
 * Section 2.4 of the
 * <a href="https://joinup.ec.europa.eu/sites/default/files/eidas_saml_attribute_profile_v1.0_2.pdf">eIDAS SAML
 * Attribute Profile</a> states the following: 
 * </p>
 * <p>
 * Transliteration allows the consumer of identity assertions to determine which attribute values are recorded in Latin
 * and non-Latin script. 
 * </p>
 * <p>
 * For attribute values where transliteration is applicable (as defined by the profile) a modifying attribute
 * {@code LatinScript=”false”} MUST be applied to the {@code <AttributeValue>}. This {@code LatinScript} attribute is
 * optional and set to {@code true} by default. 
 * </p>
 * To facilitate transliteration two {@code <AttributeValue>} statements MUST be included in the {@code <Attribute>}
 * statement;
 * <ol>
 * <li>a Latin script variant of the attribute value</li>
 * <li>a non-Latin script variant which MUST be clearly identified using the {@code LatinScript} attribute set to
 * {@code false}.</li>
 * </ol>
 * <p>
 * If a transliterated attribute value is included the {@code LatinScript} attribute MUST be set to {@code false}
 * indicating a non-latin variant of the attribute value. Nodes MUST take account of the {@code LatinScript} attribute
 * where present and act accordingly.
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface TransliterationStringType extends XSString, EidasAttributeValueType {

  /** "LatinScript" attribute's local name. */
  public static final String LATIN_SCRIPT_ATTRIB_NAME = "LatinScript";

  /**
   * Returns the {@code LatinScript} value. If the attribute is not set {@code Boolean#TRUE} will be returned.
   * 
   * @return the {@code LatinScript} attribute value
   */
  Boolean getLatinScript();

  /**
   * Returns the {@code LatinScript} value. If the attribute is not set {@code null} will be returned.
   * 
   * @return the {@code LatinScript} attribute value
   */
  XSBooleanValue getLatinScriptXSBooleanValue();

  /**
   * Assigns the {@code LatinScript} attribute value.
   * 
   * @param latinScript
   *          the {@code LatinScript} attribute value
   */
  void setLatinScript(Boolean latinScript);

  /**
   * Assigns the {@code LatinScript} attribute value.
   * 
   * @param latinScript
   *          the {@code LatinScript} attribute value
   */
  void setLatinScript(XSBooleanValue latinScript);

}
