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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.schema.XSString;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.codec.Base64Support;
import net.shibboleth.utilities.java.support.xml.ElementSupport;
import se.litsec.eidas.opensaml.ext.attributes.CurrentAddressType;

/**
 * The marshaller for {@code CurrentAddressType}.
 * <p>
 * Since the eIDAS {@code CurrentAddressType} is defined to contain a string value that is in fact the Base64-encoding
 * of an XML-snippet of {@code CurrentAddressStructuredType} we have to fool around a bit here.
 * </p>
 * <p>
 * <i>Personal note: I really can't understand how anyone thinks they made things easier for implemetors when they
 * figured that out</i>.
 * </p>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressTypeMarshaller extends AbstractXMLObjectMarshaller {

  /**
   * Even though we do have child elements, we need to serialize those, Base64-encode them and add them as a
   * Base64-encoded string value. Therefore, we pretend that there are no child elements, and let
   * {@link #marshallElementContent(XMLObject, Element)} do the work.
   */
  @Override
  protected void marshallChildElements(XMLObject xmlObject, Element domElement) throws MarshallingException {
  }

  /**
   * The element content of a {@code CurrentAddressType} is the Base64-encoding of the serialized value of the
   * {@code CurrentAddressStructuredType}. So ... we have to get there by iterating over our child elements.
   */
  @Override
  protected void marshallElementContent(XMLObject xmlObject, Element domElement) throws MarshallingException {

    // Find out if the our namespace already has been defined, and if so, get the prefix.
    //
    final String namespace = CurrentAddressType.TYPE_NAME.getNamespaceURI();
    Optional<String> _prefix = xmlObject.getNamespaceManager()
      .getNamespaces()
      .stream()
      .filter(n -> namespace.equals(n.getNamespaceURI()))
      .map(n -> n.getNamespacePrefix())
      .findFirst();
    String prefix = _prefix.isPresent() ? _prefix.get() : CurrentAddressType.TYPE_NAME.getPrefix();
    
    StringBuilder sb = new StringBuilder();

    final List<XMLObject> childXMLObjects = xmlObject.getOrderedChildren();
    if (childXMLObjects != null && childXMLObjects.size() > 0) {
      for (final XMLObject childXMLObject : childXMLObjects) {
        if (childXMLObject == null) {
          continue;
        }
        if (!(childXMLObject instanceof XSString)) {
          throw new MarshallingException("Unexpected type of child element - " + childXMLObject.getClass().getName());
        }
        XSString childString = (XSString) childXMLObject;
        if (childString.getValue() == null) {
          continue;
        }
        String localPart = childString.getElementQName().getLocalPart();
        sb.append(String.format("<%s:%s>%s</%s:%s>", prefix, localPart, childString.getValue(), prefix, localPart));
      }
    }
    if (sb.length() > 0) {
      byte[] bytes;
      try {
        bytes = sb.toString().getBytes("UTF-8");
      }
      catch (UnsupportedEncodingException e) {
        throw new MarshallingException(e);
      }
      String base64String = Base64Support.encode(bytes, true);
      ElementSupport.appendTextContent(domElement, base64String);
    }
  }

}
