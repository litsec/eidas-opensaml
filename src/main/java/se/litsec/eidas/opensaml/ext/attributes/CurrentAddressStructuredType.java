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
package se.litsec.eidas.opensaml.ext.attributes;

import org.opensaml.core.xml.XMLObject;

/**
 * The eIDAS type {@code CurrentAddressStructuredType}.
 * 
 * <pre>
 * <xsd:complexType name="CurrentAddressStructuredType">
 *   <xsd:annotation>
 *     <xsd:documentation>
 *       Current address of the natural person.
 *     </xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:sequence>
 *     <xsd:element name="PoBox" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="LocatorDesignator" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="LocatorName" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="CvaddressArea" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="Thoroughfare" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="PostName" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="AdminunitFirstline" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="AdminunitSecondline" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *     <xsd:element name="PostCode" type="xsd:string" minOccurs="0" maxOccurs="1"/>
 *   </xsd:sequence>
 * </xsd:complexType>
 * </pre>
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public interface CurrentAddressStructuredType extends XMLObject {
  
  void setPoBox(String poBox);
  
  String getPoBox();
  
  void setLocatorDesignator(String locatorDesignator);
  
  String getLocatorDesignator();
  
  // TODO

}
