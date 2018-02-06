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

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.saml.common.AbstractSAMLObjectUnmarshaller;
import org.w3c.dom.Attr;

import se.litsec.eidas.opensaml.metadata.MetadataList;
import se.litsec.eidas.opensaml.metadata.MetadataLocation;

/**
 * A thread safe unmarshaller for {@link MetadataList}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class MetadataListUnmarshaller extends AbstractSAMLObjectUnmarshaller {

  /** {@inheritDoc} */
  protected void processChildElement(XMLObject parentSAMLObject, XMLObject childSAMLObject) throws UnmarshallingException {
    MetadataList mdl = (MetadataList) parentSAMLObject;

    if (childSAMLObject instanceof MetadataLocation) {
      mdl.getMetadataLocations().add((MetadataLocation) childSAMLObject);
    }
    else {
      super.processChildElement(parentSAMLObject, childSAMLObject);
    }
  }
  
  /** {@inheritDoc} */
  @Override
  protected void processAttribute(XMLObject samlObject, Attr attribute) throws UnmarshallingException {

    MetadataList mdl = (MetadataList) samlObject;

    if (attribute.getLocalName().equals(MetadataList.TERRITORY_TYPE_ATTR_NAME)) {
      mdl.setTerritory(attribute.getValue());
    }
    else {
      this.processUnknownAttribute(mdl, attribute);
    }
  }  
  
}
