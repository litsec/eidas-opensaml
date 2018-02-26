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

import se.litsec.eidas.opensaml.metadata.DistributionPoint;
import se.litsec.eidas.opensaml.metadata.DistributionPoints;

/**
 * A thread safe unmarshaller for {@link DistributionPoints}.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class DistributionPointsUnmarshaller extends AbstractSAMLObjectUnmarshaller {

  /** {@inheritDoc} */
  protected void processChildElement(XMLObject parentSAMLObject, XMLObject childSAMLObject) throws UnmarshallingException {
    DistributionPoints dp = (DistributionPoints) parentSAMLObject;

    if (childSAMLObject instanceof DistributionPoint) {
      dp.getDistributionPoints().add((DistributionPoint) childSAMLObject);
    }
    else {
      super.processChildElement(parentSAMLObject, childSAMLObject);
    }
  }

}
