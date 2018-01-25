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

import org.opensaml.core.xml.XMLObject;
import org.opensaml.saml.common.AbstractSAMLObject;

import se.litsec.eidas.opensaml.metadata.IssuerName;
import se.litsec.eidas.opensaml.metadata.SchemeIdentifier;
import se.litsec.eidas.opensaml.metadata.SchemeInformation;
import se.litsec.eidas.opensaml.metadata.SchemeTerritory;

/**
 * Implementation class for {@link SchemeInformation}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SchemeInformationImpl extends AbstractSAMLObject implements SchemeInformation {

  /** Issuer name. */
  private IssuerName issuerName;

  /** Scheme identifier. */
  private SchemeIdentifier schemeIdentifier;

  /** Scheme territory. */
  private SchemeTerritory schemeTerritory;

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
  public SchemeInformationImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<>();

    if (this.issuerName != null) {
      children.add(this.issuerName);
    }
    if (this.schemeIdentifier != null) {
      children.add(this.schemeIdentifier);
    }
    if (this.schemeTerritory != null) {
      children.add(this.schemeTerritory);
    }
    if (children.size() == 0) {
      return null;
    }
    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public IssuerName getIssuerName() {
    return this.issuerName;
  }

  /** {@inheritDoc} */
  @Override
  public String getIssuerNameString() {
    return this.issuerName != null ? this.issuerName.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setIssuerName(IssuerName issuerName) {
    this.issuerName = this.prepareForAssignment(this.issuerName, issuerName);
  }

  /** {@inheritDoc} */
  @Override
  public void setIssuerName(String issuerName) {
    IssuerName name = null;
    if (issuerName != null) {
      name = (new IssuerNameBuilder()).buildObject();
      name.setValue(issuerName);
    }
    this.setIssuerName(name);
  }

  /** {@inheritDoc} */
  @Override
  public SchemeIdentifier getSchemeIdentifier() {
    return this.schemeIdentifier;
  }

  /** {@inheritDoc} */
  @Override
  public String getSchemeIdentifierString() {
    return this.schemeIdentifier != null ? this.schemeIdentifier.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeIdentifier(SchemeIdentifier schemeIdentifier) {
    this.schemeIdentifier = this.prepareForAssignment(this.schemeIdentifier, schemeIdentifier);
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeIdentifier(String schemeIdentifier) {
    SchemeIdentifier si = null;
    if (schemeIdentifier != null) {
      si = (new SchemeIdentifierBuilder()).buildObject();
    }
    this.setSchemeIdentifier(si);
  }

  /** {@inheritDoc} */
  @Override
  public SchemeTerritory getSchemeTerritory() {
    return this.schemeTerritory;
  }

  /** {@inheritDoc} */
  @Override
  public String getSchemeTerritoryString() {
    return this.schemeTerritory != null ? this.schemeTerritory.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeTerritory(SchemeTerritory schemeTerritory) {
    this.schemeTerritory = this.prepareForAssignment(this.schemeTerritory, schemeTerritory);
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeTerritory(String schemeTerritory) {
    SchemeTerritory st = null;
    if (schemeTerritory != null) {
      st = (new SchemeTerritoryBuilder()).buildObject();
    }
    this.setSchemeTerritory(st);
  }

}
