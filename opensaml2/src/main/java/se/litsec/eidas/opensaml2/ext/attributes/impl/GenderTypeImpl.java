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
package se.litsec.eidas.opensaml2.ext.attributes.impl;

import java.util.List;

import org.opensaml.xml.AbstractXMLObject;
import org.opensaml.xml.XMLObject;

import se.litsec.eidas.opensaml2.ext.attributes.GenderType;
import se.litsec.eidas.opensaml2.ext.attributes.GenderTypeEnumeration;

/**
 * Implementation of {@link GenderType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class GenderTypeImpl extends AbstractXMLObject implements GenderType {

  /** The gender. */
  private GenderTypeEnumeration gender;
  
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
  public GenderTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public void setGender(GenderTypeEnumeration gender) {
    this.gender = this.prepareForAssignment(this.gender, gender);
  }

  /** {@inheritDoc} */
  @Override
  public GenderTypeEnumeration getGender() {
    return this.gender;
  }
    
  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    // No children for this element
    return null;
  }

}
