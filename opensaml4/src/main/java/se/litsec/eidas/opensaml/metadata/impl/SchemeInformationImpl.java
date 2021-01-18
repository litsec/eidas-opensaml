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
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.XSURI;
import org.opensaml.core.xml.schema.impl.XSStringBuilder;
import org.opensaml.core.xml.schema.impl.XSURIBuilder;

import se.litsec.eidas.opensaml.metadata.SchemeInformation;

/**
 * Implementation class for {@link SchemeInformation}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SchemeInformationImpl extends AbstractXMLObject implements SchemeInformation {

  /** Issuer name. */
  private XSString issuerName;

  /** Scheme identifier. */
  private XSURI schemeIdentifier;

  /** Scheme territory. */
  private XSString schemeTerritory;

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
  public String getIssuerName() {
    return this.issuerName != null ? this.issuerName.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setIssuerName(String issuerName) {
    XSString name = null;
    if (issuerName != null) {
      name = (new XSStringBuilder()).buildObject(this.getElementQName().getNamespaceURI(), ISSUER_NAME_LOCAL_NAME,
        this.getElementQName().getPrefix());
      name.setValue(issuerName);
    }
    this.setIssuerName(name);
  }

  /**
   * Assigns the issuer name as a {@code XSString}.
   * 
   * @param issuerName
   *          the issuer name
   */
  public void setIssuerName(XSString issuerName) {
    this.issuerName = this.prepareForAssignment(this.issuerName, issuerName);
  }

  /** {@inheritDoc} */
  @Override
  public String getSchemeIdentifier() {
    return this.schemeIdentifier != null ? this.schemeIdentifier.getURI() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeIdentifier(String schemeIdentifier) {
    XSURI uri = null;
    if (schemeIdentifier != null) {
      uri = (new XSURIBuilder()).buildObject(this.getElementQName().getNamespaceURI(), SCHEME_IDENTIFIER_LOCAL_NAME,
        this.getElementQName().getPrefix());
      uri.setURI(schemeIdentifier);
    }
    this.setSchemeIdentifier(uri);
  }

  /**
   * Assigns the scheme identifier as a {@code XSURI} type.
   * 
   * @param schemeIdentifier
   *          the scheme identifier
   */
  public void setSchemeIdentifier(XSURI schemeIdentifier) {
    this.schemeIdentifier = this.prepareForAssignment(this.schemeIdentifier, schemeIdentifier);
  }

  /** {@inheritDoc} */
  @Override
  public String getSchemeTerritory() {
    return this.schemeTerritory != null ? this.schemeTerritory.getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public void setSchemeTerritory(String schemeTerritory) {
    XSString st = null;
    if (schemeTerritory != null) {
      st = (new XSStringBuilder()).buildObject(this.getElementQName().getNamespaceURI(), SCHEME_TERRITORY_LOCAL_NAME,
        this.getElementQName().getPrefix());
      st.setValue(schemeTerritory);
    }
    this.setSchemeTerritory(st);
  }

  /**
   * Assigns the scheme territory as a {@code XSString} type.
   * 
   * @param schemeTerritory
   *          the scheme territory
   */
  public void setSchemeTerritory(XSString schemeTerritory) {
    this.schemeTerritory = this.prepareForAssignment(this.schemeTerritory, schemeTerritory);
  }

}
