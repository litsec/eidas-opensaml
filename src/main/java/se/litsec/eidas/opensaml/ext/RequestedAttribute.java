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
package se.litsec.eidas.opensaml.ext;

import javax.xml.namespace.QName;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code <eidas:RequestedAttribute>} element.
 * 
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <xsd:schema
 *       xmlns="http://eidas.europa.eu/saml-extensions"
 *       xmlns:xsd="http://www.w3.org/2001/XMLSchema"
 *       targetNamespace="http://eidas.europa.eu/saml-extensions"
 *       elementFormDefault="qualified"
 *       attributeFormDefault="unqualified"
 *       version="1">
 *       
 *   <complexType name="RequestedAttributeType">
 *     <sequence>
 *       <element ref="eidas:AttributeValue" type="anyType" minOccurs="0" maxOccurs="unbounded"/>
 *     </sequence>
 *     <attribute name="Name" type="string" use="required"/>
 *     <attribute name="NameFormat" type="anyURI" use="required"/>
 *     <attribute name="FriendlyName" type="string" use="optional"/>
 *     <anyAttribute namespace="##other" processContents="lax"/>
 *     <attribute name="isRequired" type="boolean" use="optional"/>
 *   </complexType>
 *   
 * </xsd:schema>
 * 
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface RequestedAttribute extends org.opensaml.saml.saml2.metadata.RequestedAttribute {

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_NS,
    org.opensaml.saml.saml2.metadata.RequestedAttribute.DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NS, 
    org.opensaml.saml.saml2.metadata.RequestedAttribute.TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);

}
