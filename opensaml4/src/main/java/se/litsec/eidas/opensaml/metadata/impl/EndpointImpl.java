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
package se.litsec.eidas.opensaml.metadata.impl;

import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSBooleanValue;
import org.opensaml.core.xml.util.AttributeMap;

import se.litsec.eidas.opensaml.metadata.Endpoint;

/**
 * Implementation class for {@link Endpoint}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class EndpointImpl extends AbstractXMLObject implements Endpoint {
  
  /** "anyAttribute" attributes */
  private final AttributeMap unknownAttributes;
  
  /** The endpoint type. */
  private String endpointType;
  
  /** The entityID. */
  private String entityID;
  
  /** The name for the Suspend attribute. */
  private static final QName suspendQname = new QName("Suspend");
  
  /** The name for the HideFromDiscovery attribute. */
  private static final QName hideFromDiscoveryQname = new QName("HideFromDiscovery");

  /**
   * Constructor.
   * 
   * @param namespaceURI
   *          the namespace the element is in
   * @param elementLocalName
   *          the local name of the XML element this Object represents
   * @param namespacePrefix
   *          the prefix for the given namespace
   */  
  protected EndpointImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.unknownAttributes = new AttributeMap(this);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public String getEndpointType() {
    return this.endpointType;
  }

  /** {@inheritDoc} */
  @Override
  public void setEndpointType(String endpointType) {
    this.endpointType = this.prepareForAssignment(this.endpointType, endpointType);
  }

  /** {@inheritDoc} */
  @Override
  public String getEntityID() {
    return this.entityID;
  }

  /** {@inheritDoc} */
  @Override
  public void setEntityID(String entityID) {
    this.entityID = this.prepareForAssignment(this.entityID, entityID);
  }

  /** {@inheritDoc} */
  @Override
  public boolean getSuspend() {
    String v = this.unknownAttributes.getOrDefault(suspendQname, XSBooleanValue.toString(false, false));
    return XSBooleanValue.valueOf(v).getValue();
  }

  /** {@inheritDoc} */
  @Override
  public void setSuspend(boolean suspendFlag) {
    this.unknownAttributes.put(suspendQname, XSBooleanValue.toString(suspendFlag, false));
  }
  
  /** {@inheritDoc} */
  @Override
  public boolean getHideFromDiscovery() {
    String v = this.unknownAttributes.getOrDefault(hideFromDiscoveryQname, XSBooleanValue.toString(false, false));
    return XSBooleanValue.valueOf(v).getValue();
  }

  /** {@inheritDoc} */
  @Override
  public void setHideFromDiscovery(boolean hideFlag) {
    this.unknownAttributes.put(hideFromDiscoveryQname, XSBooleanValue.toString(hideFlag, false));
  }

  @Override
  public AttributeMap getUnknownAttributes() {
    return this.unknownAttributes;
  }

}
