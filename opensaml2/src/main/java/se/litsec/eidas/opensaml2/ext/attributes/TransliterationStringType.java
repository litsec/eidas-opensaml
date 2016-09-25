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
package se.litsec.eidas.opensaml2.ext.attributes;

import org.opensaml.xml.schema.XSBooleanValue;
import org.opensaml.xml.schema.XSString;

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
public interface TransliterationStringType extends XSString {

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
