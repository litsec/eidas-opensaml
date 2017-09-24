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

import org.opensaml.core.xml.AbstractXMLObjectBuilder;

import se.litsec.eidas.opensaml.ext.attributes.BirthNameType;

/**
 * Builder for {@link BirthNameType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class BirthNameTypeBuilder extends AbstractXMLObjectBuilder<BirthNameType> {

  /** {@inheritDoc} */
  @Override
  public BirthNameType buildObject(String namespaceURI, String localName, String namespacePrefix) {
    return new BirthNameTypeImpl(namespaceURI, localName, namespacePrefix);
  }

}
