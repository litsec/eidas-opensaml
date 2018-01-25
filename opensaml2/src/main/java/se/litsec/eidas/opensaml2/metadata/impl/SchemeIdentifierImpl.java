/*
 * Copyright 2016-2018 Litsec AB
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
package se.litsec.eidas.opensaml2.metadata.impl;

import java.util.List;

import org.opensaml.common.impl.AbstractSAMLObject;
import org.opensaml.xml.XMLObject;

import se.litsec.eidas.opensaml2.metadata.SchemeIdentifier;

/**
 * Implementation class for {@link SchemeIdentifier}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SchemeIdentifierImpl extends AbstractSAMLObject implements SchemeIdentifier {
  
  /** The ID. */
  private String value;

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
  protected SchemeIdentifierImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public String getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(String value) {
    this.value = this.prepareForAssignment(this.value, value);
  }
  
  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    return null;
  }

}
