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
 * A type safe enumeration of the {@code <eidas:SPType>} element.
 *
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public final class SPTypeEnumeration {

  /** The "public" SP type. */
  public static final SPTypeEnumeration PUBLIC = new SPTypeEnumeration("public");

  /** The "private" SP type. */
  public static final SPTypeEnumeration PRIVATE = new SPTypeEnumeration("private");

  /** The SP type. */
  private String type;

  /**
   * Constructor.
   *
   * @param type
   *          the SP type
   */
  public SPTypeEnumeration(String type) {
    this.type = type;
  }

  /**
   * Returns the type value.
   *
   * @return the value
   */
  public String getValue() {
    return this.type;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.type;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
    return result;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    SPTypeEnumeration other = (SPTypeEnumeration) obj;
    if (this.type == null) {
      if (other.type != null) {
        return false;
      }
    }
    else if (!this.type.equals(other.type)) {
      return false;
    }
    return true;
  }

}
