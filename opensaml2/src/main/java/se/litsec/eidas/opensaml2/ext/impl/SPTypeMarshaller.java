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
package se.litsec.eidas.opensaml2.ext.impl;

import org.opensaml.common.impl.AbstractSAMLObjectMarshaller;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml2.ext.SPType;

/**
 * A thread safe Marshaller for {@link SPType} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SPTypeMarshaller extends AbstractSAMLObjectMarshaller {

  /** {@inheritDoc} */
  protected void marshallElementContent(XMLObject samlObject, Element domElement) throws MarshallingException {
    SPType spType = (SPType) samlObject;

    if (spType.getType() != null && spType.getType().getValue() != null) {
      XMLHelper.appendTextContent(domElement, spType.getType().getValue());
    }
  }

}
