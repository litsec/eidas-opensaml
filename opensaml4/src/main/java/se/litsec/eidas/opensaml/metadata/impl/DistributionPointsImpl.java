/*
 * Copyright 2016-2021 Litsec AB
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

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.util.XMLObjectChildrenList;
import org.opensaml.saml.saml2.core.impl.AuthnRequestImpl;

import se.litsec.eidas.opensaml.metadata.DistributionPoint;
import se.litsec.eidas.opensaml.metadata.DistributionPoints;

/**
 * Implementation of {@link DistributionPoints}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DistributionPointsImpl extends AbstractXMLObject implements DistributionPoints {

  /** DistributionPoint children. */
  private final XMLObjectChildrenList<DistributionPoint> distributionPoints;
  
  AuthnRequestImpl j;

  /**
   * Constructor.
   * 
   * @param namespaceURI
   *          name space
   * @param elementLocalName
   *          local name
   * @param namespacePrefix
   *          prefix
   */
  protected DistributionPointsImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.distributionPoints = new XMLObjectChildrenList<DistributionPoint>(this);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<XMLObject>();
    children.addAll(this.distributionPoints);
    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public List<DistributionPoint> getDistributionPoints() {
    return this.distributionPoints;
  }

}
