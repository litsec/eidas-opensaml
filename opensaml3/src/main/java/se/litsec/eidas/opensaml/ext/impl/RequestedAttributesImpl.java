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
package se.litsec.eidas.opensaml.ext.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.util.XMLObjectChildrenList;
import org.opensaml.saml.common.AbstractSAMLObject;

import se.litsec.eidas.opensaml.ext.RequestedAttribute;
import se.litsec.eidas.opensaml.ext.RequestedAttributes;

/**
 * Implementation of {@link RequestedAttributes}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class RequestedAttributesImpl extends AbstractSAMLObject implements RequestedAttributes {

  /** RequestedAttribute children. */
  private final XMLObjectChildrenList<RequestedAttribute> requestedAttributes;

  /**
   * Constructor.
   * 
   * @param namespaceURI
   *          name space
   * @param elementLocalName
   *          local name
   * @param namespacePrefix
   *          prefix
   */
  protected RequestedAttributesImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.requestedAttributes = new XMLObjectChildrenList<RequestedAttribute>(this);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<XMLObject>();
    children.addAll(this.requestedAttributes);
    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public List<RequestedAttribute> getRequestedAttributes() {
    return this.requestedAttributes;
  }

}
