/*
 * The eidas-opensaml project is an open-source package that extends OpenSAML
 * with definitions for the eIDAS Framework.
 *
 * More details on <https://github.com/litsec/eidas-opensaml>
 * Copyright (C) 2016-2017 Litsec AB
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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import org.opensaml.core.xml.schema.XSBooleanValue;
import org.opensaml.core.xml.schema.impl.XSStringImpl;

import se.litsec.eidas.opensaml.ext.attributes.TransliterationStringType;

/**
 * Abstract implementation class of {@link TransliterationStringType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public abstract class TransliterationStringTypeImpl extends XSStringImpl implements TransliterationStringType {

  /** The {@code LatinScript} attribute. */
  private XSBooleanValue latinScript;

  /**
   * Constructor.
   * 
   * @param namespaceURI
   *          the namespace the element is in
   * @param elementLocalName
   *          the local name of the XML element this Object represents
   * @param namespacePrefix
   *          the prefix for the given namespace
   */
  protected TransliterationStringTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean getLatinScript() {
    if (this.latinScript != null) {
      return this.latinScript.getValue();
    }
    return Boolean.TRUE;
  }

  /** {@inheritDoc} */
  @Override
  public XSBooleanValue getLatinScriptXSBooleanValue() {
    return this.latinScript;
  }

  /** {@inheritDoc} */
  @Override
  public void setLatinScript(Boolean latinScript) {
    if (latinScript != null) {
      this.latinScript = prepareForAssignment(this.latinScript, new XSBooleanValue(latinScript, false));
    }
    else {
      this.latinScript = prepareForAssignment(this.latinScript, null);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void setLatinScript(XSBooleanValue latinScript) {
    this.latinScript = prepareForAssignment(this.latinScript, latinScript);
  }

  /** {@inheritDoc} */
  @Override
  public String toStringValue() {
    return this.getValue();
  }

  /** {@inheritDoc} */
  @Override
  public void parseStringValue(String value) {
    this.setValue(value);
  }

}
