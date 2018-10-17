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
package se.litsec.eidas.opensaml.ext.impl;

import java.util.List;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.saml.common.AbstractSAMLObject;

import se.litsec.eidas.opensaml.ext.NodeCountry;

/**
 * Concrete implementation of {@link NodeCountry}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class NodeCountryImpl extends AbstractSAMLObject implements NodeCountry {
  
  /** The pattern for matching country codes. */
  private static final String pattern = "^[A-Za-z][A-Za-z]$";
  
  /** The country code for the node country. */
  private String nodeCountry;

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
  public NodeCountryImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public String getNodeCountry() {
    return this.nodeCountry;
  }

  /** {@inheritDoc} */
  @Override
  public void setNodeCountry(String nodeCountry) throws IllegalArgumentException {
    if (nodeCountry == null) {
      throw new IllegalArgumentException("nodeCountry must not be null");
    }
    if (!nodeCountry.trim().matches(pattern)) {
      throw new IllegalArgumentException(nodeCountry + " is not a valid country code");
    }
    this.nodeCountry = prepareForAssignment(this.nodeCountry, nodeCountry.trim().toUpperCase());
  }
  
  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    // No children for this element
    return null;
  }
  
}