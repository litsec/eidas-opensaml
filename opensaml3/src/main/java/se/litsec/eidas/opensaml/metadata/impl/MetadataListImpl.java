/*
 * Copyright 2016-2018 Litsec AB
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSBooleanValue;
import org.opensaml.core.xml.util.AttributeMap;
import org.opensaml.core.xml.util.XMLObjectChildrenList;
import org.opensaml.saml.common.AbstractSAMLObject;

import se.litsec.eidas.opensaml.metadata.MetadataList;
import se.litsec.eidas.opensaml.metadata.MetadataLocation;

/**
 * Implementation class for {@link MetadataList}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataListImpl extends AbstractSAMLObject implements MetadataList {
  
  /** Metadata location children. */
  private final XMLObjectChildrenList<MetadataLocation> metadataLocations;
  
  /** "anyAttribute" attributes */
  private final AttributeMap unknownAttributes;
  
  /** The territory attribute. */
  private String territory;
    
  private static final QName suspendQname = new QName("Suspend");  

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
  protected MetadataListImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.metadataLocations = new XMLObjectChildrenList<MetadataLocation>(this);
    this.unknownAttributes = new AttributeMap(this);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<XMLObject>();
    children.addAll(this.metadataLocations);
    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public AttributeMap getUnknownAttributes() {
    return this.unknownAttributes;
  }

  /** {@inheritDoc} */
  @Override
  public List<MetadataLocation> getMetadataLocations() {
    return this.metadataLocations;
  }

  /** {@inheritDoc} */
  @Override
  public String getTerritory() {
    return this.territory;
  }

  /** {@inheritDoc} */
  @Override
  public void setTerritory(String territory) {
    this.territory = this.prepareForAssignment(this.territory, territory);
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

}
