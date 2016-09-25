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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import org.opensaml.core.xml.schema.impl.XSStringImpl;

import se.litsec.eidas.opensaml.ext.attributes.PersonIdentifierType;

/**
 * Implementation of the {@link PersonIdentifierType} interface.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class PersonIdentifierTypeImpl extends XSStringImpl implements PersonIdentifierType {

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
  protected PersonIdentifierTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public String getNationalityCode() {
    return this.getPart(0);
  }

  /** {@inheritDoc} */
  @Override
  public String getDestinationNationalityCode() {
    return this.getPart(1);
  }

  /** {@inheritDoc} */
  @Override
  public String getIdentifierString() {
    return this.getPart(2);
  }

  /**
   * Extracts the given part from the unique identifier.
   * 
   * @param pos
   *          position
   * @return the part or {@code null}
   */
  private String getPart(int pos) {
    String value = this.getValue();
    if (value == null) {
      return null;
    }
    String[] parts = value.split("/");
    return parts.length >= pos + 1 ? parts[pos] : null;
  }

}
