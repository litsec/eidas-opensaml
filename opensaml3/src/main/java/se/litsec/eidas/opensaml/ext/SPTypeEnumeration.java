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
package se.litsec.eidas.opensaml.ext;

/**
 * An enumeration of the {@code <eidas:SPType>} element.
 *
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public enum SPTypeEnumeration {

  /** The "public" SP type. */
  PUBLIC("public"),

  /** The "private" SP type. */
  PRIVATE("private");

  /** The SP type. */
  private String type;

  /**
   * Returns the type value.
   *
   * @return the value
   */
  public String getValue() {
    return this.type;
  }

  /**
   * Given the string representation of a SPType, the method returns its {@code SPTypeEnumeration} representation.
   * 
   * @param value
   *          the value to parse
   * @return the corresponding SPTypeEnumeration
   * @throws IllegalArgumentException
   *           if the supplied value is not a valid SPType
   */
  public static SPTypeEnumeration parseValue(final String value) {
    for (SPTypeEnumeration e : SPTypeEnumeration.values()) {
      if (e.getValue().equalsIgnoreCase(value)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Not a valid SPType - " + value);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.type;
  }

  /**
   * Constructor.
   *
   * @param type
   *          the SP type
   */
  private SPTypeEnumeration(final String type) {
    this.type = type;
  }

}
