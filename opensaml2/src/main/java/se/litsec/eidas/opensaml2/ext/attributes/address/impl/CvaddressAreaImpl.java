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

import org.opensaml.xml.schema.impl.XSStringImpl;

import se.litsec.eidas.opensaml2.ext.attributes.address.CvaddressArea;

/**
 * Implementation of {@code CvaddressArea}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CvaddressAreaImpl extends XSStringImpl implements CvaddressArea {

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
  public CvaddressAreaImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

}
