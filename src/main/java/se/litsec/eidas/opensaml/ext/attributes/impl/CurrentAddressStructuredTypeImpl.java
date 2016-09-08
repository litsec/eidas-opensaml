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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.XMLObjectBuilder;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.schema.XSString;

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
 * Implementation of {@code CurrentAddressStructuredType}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class CurrentAddressStructuredTypeImpl extends AbstractXMLObject implements CurrentAddressStructuredType {

  /** PoBox */
  private PoBox poBox;

  /** LocatorDesignator */
  private LocatorDesignator locatorDesignator;

  /** LocatorName */
  private LocatorName locatorName;

  /** CvaddressArea */
  private CvaddressArea cvaddressArea;

  /** Thoroughfare */
  private Thoroughfare thoroughfare;

  /** PostName */
  private PostName postName;

  /** AdminunitFirstline */
  private AdminunitFirstline adminunitFirstline;

  /** AdminunitSecondline */
  private AdminunitSecondline adminunitSecondline;

  /** PostCode */
  private PostCode postCode;

  /**
   * @see AbstractXMLObject
   */
  public CurrentAddressStructuredTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<XMLObject>();

    if (this.poBox != null) {
      children.add(this.poBox);
    }
    if (this.locatorDesignator != null) {
      children.add(this.locatorDesignator);
    }
    if (this.locatorName != null) {
      children.add(this.locatorName);
    }
    if (this.cvaddressArea != null) {
      children.add(this.cvaddressArea);
    }
    if (this.thoroughfare != null) {
      children.add(this.thoroughfare);
    }
    if (this.postName != null) {
      children.add(this.postName);
    }
    if (this.adminunitFirstline != null) {
      children.add(this.adminunitFirstline);
    }
    if (this.adminunitSecondline != null) {
      children.add(this.adminunitFirstline);
    }
    if (this.adminunitSecondline != null) {
      children.add(this.adminunitSecondline);
    }
    if (this.postCode != null) {
      children.add(this.postCode);
    }

    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public void setPoBox(String poBox) {
    this.poBox = this.prepareForAssignment(this.poBox, this.createXSString(PoBox.class, poBox)); 
  }

  /** {@inheritDoc} */
  @Override
  public String getPoBox() {
    return this.poBox != null ? this.poBox.getValue() : null;
  }

  /** {@inheritDoc} */  
  @Override
  public void setLocatorDesignator(String locatorDesignator) {
    this.locatorDesignator = this.prepareForAssignment(this.locatorDesignator, this.createXSString(LocatorDesignator.class, locatorDesignator));
  }

  /** {@inheritDoc} */
  @Override
  public String getLocatorDesignator() {
    return this.locatorDesignator != null ? this.locatorDesignator.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setLocatorName(String locatorName) {
    this.locatorName = this.prepareForAssignment(this.locatorName, this.createXSString(LocatorName.class, locatorName));
  }

  /** {@inheritDoc} */
  @Override
  public String getLocatorName() {
    return this.locatorName != null ? this.locatorName.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setCvaddressArea(String cvaddressArea) {
    this.cvaddressArea = this.prepareForAssignment(this.cvaddressArea, this.createXSString(CvaddressArea.class, cvaddressArea));
  }

  /** {@inheritDoc} */
  @Override
  public String getCvaddressArea() {
    return this.cvaddressArea != null ? this.cvaddressArea.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setThoroughfare(String thoroughfare) {
    this.thoroughfare = this.prepareForAssignment(this.thoroughfare, this.createXSString(Thoroughfare.class, thoroughfare));
  }

  /** {@inheritDoc} */
  @Override
  public String getThoroughfare() {
    return this.thoroughfare != null ? this.thoroughfare.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setPostName(String postName) {
    this.postName = this.prepareForAssignment(this.postName, this.createXSString(PostName.class, postName));
  }

  /** {@inheritDoc} */
  @Override
  public String getPostName() {
    return this.postName != null ? this.postName.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setAdminunitFirstline(String adminunitFirstline) {
    this.adminunitFirstline = this.prepareForAssignment(this.adminunitFirstline, this.createXSString(AdminunitFirstline.class, adminunitFirstline));
  }

  /** {@inheritDoc} */
  @Override
  public String getAdminunitFirstline() {
    return this.adminunitFirstline != null ? this.adminunitFirstline.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setAdminunitSecondline(String adminunitSecondline) {
    this.adminunitSecondline = this.prepareForAssignment(this.adminunitSecondline, this.createXSString(AdminunitSecondline.class, adminunitSecondline));
  }

  /** {@inheritDoc} */
  @Override
  public String getAdminunitSecondline() {
    return this.adminunitSecondline != null ? this.adminunitSecondline.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setPostCode(String postCode) {
    this.postCode = this.prepareForAssignment(this.postCode, this.createXSString(PostCode.class, postCode));
  }

  /** {@inheritDoc} */
  @Override
  public String getPostCode() {
    return this.postCode != null ? this.postCode.getValue() : null;
  }

  /**
   * Utility method for creating an OpenSAML object given its type and assigns the value.
   * 
   * @param clazz
   *          the class to create
   * @param value
   *          the string value to assign
   * @return the XML object or {@code null} if value is {@code null}
   */
  private <T extends XSString> T createXSString(Class<T> clazz, String value) {
    if (value == null) {
      return null;
    }
    QName elementName = null;
    String localName = null;
    try {
      elementName = (QName) clazz.getDeclaredField("DEFAULT_ELEMENT_NAME").get(null);
      localName = (String) clazz.getDeclaredField("DEFAULT_ELEMENT_LOCAL_NAME").get(null);
    }
    catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
      throw new RuntimeException(e);
    }
    XMLObjectBuilder<? extends XMLObject> builder = XMLObjectProviderRegistrySupport.getBuilderFactory().getBuilder(elementName);
    Object object = builder.buildObject(new QName(this.getElementQName().getNamespaceURI(), localName, this.getElementQName().getPrefix()));
    T xsstring = clazz.cast(object);
    xsstring.setValue(value);
    return xsstring;
  }

}
