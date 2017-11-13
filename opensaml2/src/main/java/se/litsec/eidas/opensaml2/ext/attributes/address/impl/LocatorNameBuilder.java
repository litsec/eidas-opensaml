/*
 * Copyright 2016-2017 Litsec AB
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
package se.litsec.eidas.opensaml2.ext.attributes.address.impl;

import org.opensaml.xml.AbstractXMLObjectBuilder;

import se.litsec.eidas.opensaml2.common.EidasConstants;
import se.litsec.eidas.opensaml2.ext.attributes.address.LocatorName;

/**
 * Builder for {@code LocatorName}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class LocatorNameBuilder extends AbstractXMLObjectBuilder<LocatorName> {

  /** {@inheritDoc} */
  public LocatorName buildObject() {
    return buildObject(EidasConstants.EIDAS_NP_NS, LocatorName.DEFAULT_ELEMENT_LOCAL_NAME,
      EidasConstants.EIDAS_NP_PREFIX);
  }

  /** {@inheritDoc} */
  @Override
  public LocatorName buildObject(String namespaceURI, String localName, String namespacePrefix) {
    return new LocatorNameImpl(namespaceURI, localName, namespacePrefix);
  }

}
