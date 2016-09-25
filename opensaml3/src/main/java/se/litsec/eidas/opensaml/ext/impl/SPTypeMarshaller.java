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

    if (spType.getType() != null && spType.getType().getValue() != null) {
      ElementSupport.appendTextContent(domElement, spType.getType().getValue());
    }
  }

}