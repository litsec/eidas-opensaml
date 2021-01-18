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

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.saml.common.AbstractSAMLObjectMarshaller;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.AttributeSupport;
import se.litsec.eidas.opensaml.metadata.MetadataServiceList;

/**
 * A marshaller for {@link MetadataServiceList}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataServiceListMarshaller extends AbstractSAMLObjectMarshaller {

  /** {@inheritDoc} */
  protected void marshallAttributes(XMLObject samlObject, Element domElement) throws MarshallingException {

    MetadataServiceList mdsl = (MetadataServiceList) samlObject;

    if (mdsl.getID() != null) {
      domElement.setAttributeNS(null, MetadataServiceList.ID_ATTR_NAME, mdsl.getID());
      domElement.setIdAttributeNS(null, MetadataServiceList.ID_ATTR_NAME, true);
    }
    if (mdsl.getVersion() != null) {
      domElement.setAttributeNS(null, MetadataServiceList.VERSION_ATTR_NAME, mdsl.getVersion().toString());
    }
    if (mdsl.getIssueDate() != null) {
      AttributeSupport.appendDateTimeAttribute(domElement, MetadataServiceList.ISSUE_DATE_ATTR_QNAME, mdsl.getIssueDate());
    }
    if (mdsl.getNextUpdate() != null) {
      AttributeSupport.appendDateTimeAttribute(domElement, MetadataServiceList.NEXT_UPDATE_ATTR_QNAME, mdsl.getNextUpdate());
    }
  }

}
