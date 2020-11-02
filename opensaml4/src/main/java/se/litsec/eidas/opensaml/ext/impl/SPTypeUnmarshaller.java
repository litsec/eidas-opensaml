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
package se.litsec.eidas.opensaml.ext.impl;

import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.saml.common.AbstractSAMLObjectUnmarshaller;
import org.w3c.dom.Text;

import net.shibboleth.utilities.java.support.primitive.StringSupport;
import se.litsec.eidas.opensaml.ext.SPType;
import se.litsec.eidas.opensaml.ext.SPTypeEnumeration;

/**
 * A thread-safe Unmarshaller for {@link SPType} objects.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class SPTypeUnmarshaller extends AbstractSAMLObjectUnmarshaller {
  
  /** {@inheritDoc} */
  @Override
  protected void unmarshallTextContent(final XMLObject xmlObject, final Text content) throws UnmarshallingException {
    
    final String textContent = StringSupport.trimOrNull(content.getWholeText());
    if (textContent == null) {
      throw new UnmarshallingException("Invalid SPType - missing content");
    }
    try {
      final SPTypeEnumeration spTypeEnum = SPTypeEnumeration.parseValue(textContent);
      SPType.class.cast(xmlObject).setType(spTypeEnum);
    }
    catch (IllegalArgumentException e) {
      throw new UnmarshallingException(String.format("Invalid SPType - %s is not a valid SPType value", textContent));
    }
  }

}
