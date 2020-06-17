/*
 * Copyright 2016-2020 Litsec AB
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
package se.litsec.eidas.opensaml.ext;

import javax.xml.namespace.QName;

import se.litsec.eidas.opensaml.common.EidasConstants;

/**
 * The eIDAS {@code <eidas:RequestedAttribute>} element.
 * 
 * <pre>{@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <xsd:schema
 *     xmlns="http://eidas.europa.eu/saml-extensions"
 *     xmlns:xsd="http://www.w3.org/2001/XMLSchema"
 *     targetNamespace="http://eidas.europa.eu/saml-extensions"
 *     elementFormDefault="qualified"
 *     attributeFormDefault="unqualified"
 *     version="1">
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
 * </xsd:schema>} 
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
