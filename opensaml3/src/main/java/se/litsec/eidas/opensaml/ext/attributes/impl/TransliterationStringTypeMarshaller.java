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