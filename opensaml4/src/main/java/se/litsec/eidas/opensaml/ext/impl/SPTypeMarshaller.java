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

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.saml.common.AbstractSAMLObjectMarshaller;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.ElementSupport;
import se.litsec.eidas.opensaml.ext.SPType;

/**
 * A thread safe Marshaller for {@link SPType} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SPTypeMarshaller extends AbstractSAMLObjectMarshaller {

  /** {@inheritDoc} */
  protected void marshallElementContent(XMLObject samlObject, Element domElement) throws MarshallingException {
    SPType spType = (SPType) samlObject;

    if (spType.getType() != null) {
      ElementSupport.appendTextContent(domElement, spType.getType().getValue());
    }
  }

}
