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

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSBooleanValue;
import org.opensaml.core.xml.util.AttributeMap;
import org.opensaml.core.xml.util.XMLObjectChildrenList;
import org.opensaml.xmlsec.signature.KeyInfo;
import org.opensaml.xmlsec.signature.X509Data;
import org.opensaml.xmlsec.signature.impl.KeyInfoBuilder;
import org.opensaml.xmlsec.signature.impl.X509CertificateBuilder;
import org.opensaml.xmlsec.signature.impl.X509DataBuilder;

import net.shibboleth.utilities.java.support.codec.Base64Support;
import net.shibboleth.utilities.java.support.codec.EncodingException;
import se.litsec.eidas.opensaml.metadata.Endpoint;
import se.litsec.eidas.opensaml.metadata.MetadataLocation;

/**
 * Implementation class for {@link MetadataLocation}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataLocationImpl extends AbstractXMLObject implements MetadataLocation {

  /** Endpoint children. */
  private final XMLObjectChildrenList<Endpoint> endpoints;

  /** Key info (certificate). */
  private KeyInfo keyInfo;

  /** The location attribute. */
  private String location;
  
  /** "anyAttribute" attributes */
  private final AttributeMap unknownAttributes;
  
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
  public MetadataLocationImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
    super(namespaceURI, elementLocalName, namespacePrefix);
    this.endpoints = new XMLObjectChildrenList<Endpoint>(this);
    this.unknownAttributes = new AttributeMap(this);
  }

  /** {@inheritDoc} */
  @Override
  public List<XMLObject> getOrderedChildren() {
    ArrayList<XMLObject> children = new ArrayList<XMLObject>();
    children.addAll(this.endpoints);
    if (this.keyInfo != null) {
      children.add(this.keyInfo);
    }
    return Collections.unmodifiableList(children);
  }

  /** {@inheritDoc} */
  @Override
  public List<Endpoint> getEndpoints() {
    return this.endpoints;
  }

  /** {@inheritDoc} */
  @Override
  public KeyInfo getKeyInfo() {
    return this.keyInfo;
  }

  /** {@inheritDoc} */
  @Override
  public void setKeyInfo(KeyInfo keyInfo) {
    this.keyInfo = this.prepareForAssignment(this.keyInfo, keyInfo);
  }

  /** {@inheritDoc} */
  @Override
  public void setX509Certificate(X509Certificate certificate) {

    String encoding;
    try {
      encoding = Base64Support.encode(certificate.getEncoded(), true);
    }
    catch (CertificateEncodingException | EncodingException e) {
      throw new SecurityException("Failed to get certificate encoding", e);
    }
    org.opensaml.xmlsec.signature.X509Certificate cert = (new X509CertificateBuilder()).buildObject();
    cert.setValue(encoding);

    X509Data x509data = (new X509DataBuilder()).buildObject();
    x509data.getX509Certificates().add(cert);

    KeyInfo keyInfo = (new KeyInfoBuilder()).buildObject();
    keyInfo.getX509Datas().add(x509data);

    this.setKeyInfo(keyInfo);
  }

  /** {@inheritDoc} */
  @Override
  public String getLocation() {
    return this.location;
  }

  /** {@inheritDoc} */
  @Override
  public void setLocation(String location) {
    this.location = this.prepareForAssignment(this.location, location);
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
  
  @Override
  public AttributeMap getUnknownAttributes() {
    return this.unknownAttributes;
  }  
  
}
