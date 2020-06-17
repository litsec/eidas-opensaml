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
package se.litsec.eidas.opensaml.ext.impl;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.saml.common.AbstractSAMLObjectUnmarshaller;

import se.litsec.eidas.opensaml.ext.RequestedAttribute;
import se.litsec.eidas.opensaml.ext.RequestedAttributes;

/**
 * A thread safe unmarshaller for {@link RequestedAttributes}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class RequestedAttributesUnmarshaller extends AbstractSAMLObjectUnmarshaller {

  /** {@inheritDoc} */
  protected void processChildElement(XMLObject parentSAMLObject, XMLObject childSAMLObject) throws UnmarshallingException {
    RequestedAttributes attributes = (RequestedAttributes) parentSAMLObject;

    if (childSAMLObject instanceof RequestedAttribute) {
      attributes.getRequestedAttributes().add((RequestedAttribute) childSAMLObject);
    }
    else {
      super.processChildElement(parentSAMLObject, childSAMLObject);
    }
  }

}
