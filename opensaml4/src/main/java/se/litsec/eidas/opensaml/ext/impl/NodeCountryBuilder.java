/*
 * Copyright 2016-2021 Litsec AB
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

import org.opensaml.saml.common.AbstractSAMLObjectBuilder;

import se.litsec.eidas.opensaml.common.EidasConstants;
import se.litsec.eidas.opensaml.ext.NodeCountry;

/**
 * Builder for {@link NodeCountry} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class NodeCountryBuilder extends AbstractSAMLObjectBuilder<NodeCountry> {

  /** {@inheritDoc} */
  @Override
  public NodeCountry buildObject() {
    return buildObject(EidasConstants.EIDAS_NS, NodeCountry.DEFAULT_ELEMENT_LOCAL_NAME, EidasConstants.EIDAS_PREFIX);
  }

  /** {@inheritDoc} */
  @Override
  public NodeCountry buildObject(String namespaceURI, String localName, String namespacePrefix) {
    return new NodeCountryImpl(namespaceURI, localName, namespacePrefix);
  }

}
