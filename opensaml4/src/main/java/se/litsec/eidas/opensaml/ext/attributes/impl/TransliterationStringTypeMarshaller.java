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
package se.litsec.eidas.opensaml.ext.attributes.impl;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.schema.impl.XSStringMarshaller;
import org.w3c.dom.Element;

import se.litsec.eidas.opensaml.ext.attributes.TransliterationStringType;

/**
 * Marshaller for {@link TransliterationStringType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class TransliterationStringTypeMarshaller extends XSStringMarshaller {

  /** {@inheritDoc} */
  protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
    TransliterationStringType tstring = (TransliterationStringType) xmlObject;

    if (tstring.getLatinScriptXSBooleanValue() != null) {
      domElement.setAttributeNS(null, TransliterationStringType.LATIN_SCRIPT_ATTRIB_NAME,
        tstring.getLatinScriptXSBooleanValue().getValue().toString());
    }
  }

}
