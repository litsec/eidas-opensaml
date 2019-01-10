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
package se.litsec.eidas.opensaml.ext.impl;

import java.util.List;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.saml.common.AbstractSAMLObject;

import se.litsec.eidas.opensaml.ext.SPType;
import se.litsec.eidas.opensaml.ext.SPTypeEnumeration;

/**
 * Concrete implementation of {@link SPType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SPTypeImpl extends AbstractSAMLObject implements SPType {
  
  /** The type. */
  private SPTypeEnumeration type;

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
  protected SPTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public SPTypeEnumeration getType() {
    return this.type;
  }

  /** {@inheritDoc} */
  @Override
  public void setType(SPTypeEnumeration type) {
    this.type = prepareForAssignment(this.type, type); 
  }
  
  /** {@inheritDoc} */
  public List<XMLObject> getOrderedChildren() {
      // No children for this element
      return null;
  }

}
