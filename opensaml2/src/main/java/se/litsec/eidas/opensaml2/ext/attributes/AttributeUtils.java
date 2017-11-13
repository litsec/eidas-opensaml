/*
 * Copyright 2016-2017 Litsec AB
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
package se.litsec.eidas.opensaml2.ext.attributes;

import javax.xml.namespace.QName;

import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeValue;
import org.opensaml.saml2.core.impl.AttributeBuilder;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.XMLObjectBuilder;

/**
 * Utility methods for handling attributes and attribute values.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class AttributeUtils {

  /** Builder for Attribute types. */
  private static final AttributeBuilder attributeBuilder = new AttributeBuilder();

  // Hidden constructor
  private AttributeUtils() {
  }

  /**
   * Utility method that creates an {@code Attribute} given its name, friendly name and name format.
   * 
   * @param name
   *          the attribute name
   * @param friendlyName
   *          the attribute friendly name (may be {@code null})
   * @param nameFormat
   *          the name format
   * @return an {@code Attribute} object
   */
  public static Attribute createAttribute(String name, String friendlyName, String nameFormat) {
    Attribute attribute = attributeBuilder.buildObject();
    attribute.setName(name);
    attribute.setFriendlyName(friendlyName);
    attribute.setNameFormat(nameFormat);
    return attribute;
  }

  /**
   * Creates an {@code Attribute} with the given name (and friendly name) and with a name format of
   * {@value Attribute#URI_REFERENCE}.
   * 
   * @param name
   *          the attribute name
   * @param friendlyName
   *          the attribute friendly name (may be {@code null})
   * @return an {@code Attribute} object
   * @see #createAttribute(String, String, String)
   */
  public static Attribute createAttribute(String name, String friendlyName) {
    return createAttribute(name, friendlyName, Attribute.URI_REFERENCE);
  }

  /**
   * Creates an {@code AttributeValue} object of the given class. The type of the attribute value will be the field that
   * is declared as {@code TYPE_NAME} of the given class.
   * <p>
   * After the object has been constructed, its setter methods should be called to setup the value object before adding
   * it to the attribute itself.
   * </p>
   *
   * @param <T>
   *          the type
   * @param clazz
   *          the type of attribute value
   * @return the attribute value
   * @see #createAttributeValueObject(QName, Class)
   */
  public static <T extends XMLObject> T createAttributeValueObject(Class<T> clazz) {
    try {
      QName schemaType = (QName) clazz.getDeclaredField("TYPE_NAME").get(null);
      return createAttributeValueObject(schemaType, clazz);
    }
    catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Creates an {@code AttributeValue} object of the given class and schema type.
   * <p>
   * After the object has been constructed, its setter methods should be called to setup the value object before adding
   * it to the attribute itself.
   * </p>
   * 
   * @param <T>
   *          the type
   * @param schemaType
   *          the schema type that should be assigned to the attribute value, i.e.,
   *          {@code xsi:type="eidas:CurrentFamilyNameType"}
   * @param clazz
   *          the type of the attribute value
   * @return the attribute value
   * @see #createAttributeValueObject(Class)
   */
  public static <T extends XMLObject> T createAttributeValueObject(QName schemaType, Class<T> clazz) {
    XMLObjectBuilder<?> builder = Configuration.getBuilderFactory().getBuilder(schemaType);
    XMLObject object = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, schemaType);
    return clazz.cast(object);
  }

  /**
   * Utility method that adds an XML object as a value to an {@code Attribute}.
   * <p>
   * Example:
   * </p>
   * <pre>{@code
   * Attribute attr = 
   *   AttributeUtils.createAttribute("http://eidas.europa.eu/attributes/naturalperson/CurrentFamilyName", "FamilyName");
   * CurrentFamilyNameType value = AttributeUtils.createAttributeValueObject(CurrentFamilyNameType.class);
   * value.setValue("Lindström");
   * AttributeUtils.addAttributeValue(attr, value);}
   * </pre>
   * 
   * @param <T>
   *          the type
   * @param attribute
   *          the attribute to update
   * @param value
   *          the value to add
   */
  public static <T extends XMLObject> void addAttributeValue(Attribute attribute, T value) {
    attribute.getAttributeValues().add(value);
  }

  // TODO: Utility method to add LoA attribute to EntityAttributes.
  // TODO: Utility method to get LoA attribute from EntityAttributes

}
