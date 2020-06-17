/*
 * Copyright 2016-2020 Litsec AB
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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import java.util.List;

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;

import se.litsec.eidas.opensaml.ext.attributes.GenderType;
import se.litsec.eidas.opensaml.ext.attributes.GenderTypeEnumeration;

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

  /** {@inheritDoc} */
  @Override
  public String toStringValue() {
    GenderTypeEnumeration g = this.getGender();
    return g != null ? g.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void parseStringValue(String value) {
    GenderTypeEnumeration g = GenderTypeEnumeration.fromValue(value);
    if (g != null) {
      this.setGender(g);
    }
  }

}
