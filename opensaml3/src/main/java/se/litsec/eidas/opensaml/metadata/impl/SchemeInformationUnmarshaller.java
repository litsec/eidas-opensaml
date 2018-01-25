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

import se.litsec.eidas.opensaml.metadata.IssuerName;
import se.litsec.eidas.opensaml.metadata.SchemeIdentifier;
import se.litsec.eidas.opensaml.metadata.SchemeInformation;
import se.litsec.eidas.opensaml.metadata.SchemeTerritory;

/**
 * Unmarshaller for {@link SchemeInformation} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SchemeInformationUnmarshaller extends AbstractSAMLObjectUnmarshaller {

  /** {@inheritDoc} */
  @Override
  protected void processChildElement(XMLObject parentSAMLObject, XMLObject childSAMLObject)
      throws UnmarshallingException {
    
    SchemeInformation schemeInformation = (SchemeInformation) parentSAMLObject; 

    if (childSAMLObject instanceof IssuerName) {
      schemeInformation.setIssuerName((IssuerName) childSAMLObject);
    }
    else if (childSAMLObject instanceof SchemeIdentifier) {
      schemeInformation.setSchemeIdentifier((SchemeIdentifier) childSAMLObject);
    }
    else if (childSAMLObject instanceof SchemeTerritory) {
      schemeInformation.setSchemeTerritory((SchemeTerritory) childSAMLObject);
    }
    else {
      super.processChildElement(parentSAMLObject, childSAMLObject);
    }
  }
  
}
