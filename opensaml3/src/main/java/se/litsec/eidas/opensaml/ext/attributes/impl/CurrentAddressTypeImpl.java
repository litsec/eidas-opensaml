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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSString;

import se.litsec.eidas.opensaml.ext.attributes.CurrentAddressType;

/**
 * Implementation of {@code CurrentAddressType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressTypeImpl extends CurrentAddressStructuredTypeImpl implements CurrentAddressType {

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
  public CurrentAddressTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public String toSwedishEidString() {
    StringBuilder sb = new StringBuilder();

    List<XMLObject> children = this.getOrderedChildren();
    for (XMLObject child : children) {
      if (child instanceof XSString) {
        final String value = ((XSString) child).getValue();
        if (value.trim().isEmpty()) {
          continue;
        }
        if (sb.length() > 0) {
          sb.append(';');
        }
        try {
          sb.append(child.getElementQName().getLocalPart())
            .append('=')
            .append(URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20"));
        }
        catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
        }
      }
    }

    return sb.toString();
  }

  /** {@inheritDoc} */
  @Override
  public String toStringValue() {
    return this.toSwedishEidString();
  }

  @Override
  public void parseStringValue(String value) throws IllegalArgumentException, NullPointerException {
    // Not supported
  }

}
