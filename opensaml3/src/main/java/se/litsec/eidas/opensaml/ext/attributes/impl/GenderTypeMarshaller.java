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
import org.opensaml.core.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.ElementSupport;
import se.litsec.eidas.opensaml.ext.attributes.GenderType;

/**
 * A thread safe Marshaller for {@link GenderType} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class GenderTypeMarshaller extends AbstractXMLObjectMarshaller {
  
  /** {@inheritDoc} */
  protected void marshallElementContent(XMLObject xmlObject, Element domElement) throws MarshallingException {
    GenderType gender = (GenderType) xmlObject;
    if (gender.getGender() != null && gender.getGender().getValue() != null) {
      ElementSupport.appendTextContent(domElement, gender.getGender().getValue());
    }
  }
  
}