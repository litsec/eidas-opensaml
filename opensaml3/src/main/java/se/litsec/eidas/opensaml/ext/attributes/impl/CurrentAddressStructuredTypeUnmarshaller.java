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
import org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;

import se.litsec.eidas.opensaml.ext.attributes.CurrentAddressStructuredType;
import se.litsec.eidas.opensaml.ext.attributes.address.AdminunitFirstline;
import se.litsec.eidas.opensaml.ext.attributes.address.AdminunitSecondline;
import se.litsec.eidas.opensaml.ext.attributes.address.CvaddressArea;
import se.litsec.eidas.opensaml.ext.attributes.address.LocatorDesignator;
import se.litsec.eidas.opensaml.ext.attributes.address.LocatorName;
import se.litsec.eidas.opensaml.ext.attributes.address.PoBox;
import se.litsec.eidas.opensaml.ext.attributes.address.PostCode;
import se.litsec.eidas.opensaml.ext.attributes.address.PostName;
import se.litsec.eidas.opensaml.ext.attributes.address.Thoroughfare;

/**
 * Thread safe unmarshaller for {@code CurrentAddressStructuredType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressStructuredTypeUnmarshaller extends AbstractXMLObjectUnmarshaller {

  /** {@inheritDoc} */
  @Override
  protected void processChildElement(XMLObject parentObject, XMLObject childObject) throws UnmarshallingException {
    CurrentAddressStructuredType address = (CurrentAddressStructuredType) parentObject;

    if (childObject instanceof PoBox) {
      address.setPoBox(((PoBox) childObject).getValue());
    }
    else if (childObject instanceof LocatorDesignator) {
      address.setLocatorDesignator(((LocatorDesignator) childObject).getValue());
    }
    else if (childObject instanceof LocatorName) {
      address.setLocatorName(((LocatorName) childObject).getValue());
    }
    else if (childObject instanceof CvaddressArea) {
      address.setCvaddressArea(((CvaddressArea) childObject).getValue());
    }
    else if (childObject instanceof Thoroughfare) {
      address.setThoroughfare(((Thoroughfare)childObject).getValue());
    }
    else if (childObject instanceof PostName) {
      address.setPostName(((PostName)childObject).getValue());
    }
    else if (childObject instanceof AdminunitFirstline) {
      address.setAdminunitFirstline(((AdminunitFirstline)childObject).getValue());
    }
    else if (childObject instanceof AdminunitSecondline) {
      address.setAdminunitSecondline(((AdminunitSecondline)childObject).getValue());
    }
    else if (childObject instanceof PostCode) {
      address.setPostCode(((PostCode)childObject).getValue());
    }
    else {
      super.processChildElement(parentObject, childObject);
    }
  }

}
