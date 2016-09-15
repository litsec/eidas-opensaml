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

import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.saml.common.SAMLObject;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code <eidas:RequestedAttributes>} element.
 * 
 * <pre>{@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <xsd:schema
 *      xmlns="http://eidas.europa.eu/saml-extensions"
 *      xmlns:xsd="http://www.w3.org/2001/XMLSchema"
 *      targetNamespace="http://eidas.europa.eu/saml-extensions"
 *      elementFormDefault="qualified"
 *      attributeFormDefault="unqualified"
 *      version="1">
 *      
 *   <xs:element name="RequestedAttributes" type="eidas:RequestedAttributesType" />
 *   
 *   <xs:complexType name="RequestedAttributesType">
 *     <xs:sequence>
 *       <xs:element minOccurs="0" maxOccurs="unbounded" ref="eidas:RequestedAttribute"/>
 *     </xs:sequence>
 *   </xs:complexType>
 * </xsd:schema>}
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface RequestedAttributes extends SAMLObject {

  /** Element name, no namespace. */
  public static final String DEFAULT_ELEMENT_LOCAL_NAME = "RequestedAttributes";

  /** Default element name. */
  public static final QName DEFAULT_ELEMENT_NAME = new QName(EidasConstants.EIDAS_NS, DEFAULT_ELEMENT_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);

  /** Local name of the XSI type. */
  public static final String TYPE_LOCAL_NAME = "RequestedAttributesType";

  /** QName of the XSI type. */
  public static final QName TYPE_NAME = new QName(EidasConstants.EIDAS_NS, TYPE_LOCAL_NAME,
    EidasConstants.EIDAS_PREFIX);

  /**
   * Returns a reference to the list of the requested attributes.
   * 
   * @return an attribute list
   */
  public List<RequestedAttribute> getRequestedAttributes();

}
