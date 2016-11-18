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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.schema.XSString;

import se.litsec.eidas.opensaml2.ext.attributes.CurrentAddressType;

/**
 * Implementation of {@code CurrentAddressType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressTypeImpl extends CurrentAddressStructuredTypeImpl implements CurrentAddressType {

  /**
   * Constructor.
   * 
   * @param namespaceURI the namespace the element is in
   * @param elementLocalName the local name of the XML element this Object represents
   * @param namespacePrefix the prefix for the given namespace
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
  
}
