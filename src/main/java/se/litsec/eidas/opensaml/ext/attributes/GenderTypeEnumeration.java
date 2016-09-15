/*
 * The eidas-opensaml project is an open-source package that extends OpenSAML
 * with definitions for the eIDAS Framework.
 *
 * More details on <https://github.com/litsec/eidas-opensaml>
 * Copyright (C) 2016 Litsec AB
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package se.litsec.eidas.opensaml.ext.attributes;

/**
 * Enumeration of the {@code <eidas:GenderType>} type.
 *
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public final class GenderTypeEnumeration {

  /** Male. */
  public static final GenderTypeEnumeration MALE = new GenderTypeEnumeration("Male");

  /** Female. */
  public static final GenderTypeEnumeration FEMALE = new GenderTypeEnumeration("Female");

  /** Unspecified. */
  public static final GenderTypeEnumeration UNSPECIFIED = new GenderTypeEnumeration("Unspecified");

  /** The gender. */
  private String gender;

  /**
   * Constructor.
   *
   * @param gender
   *          the gender
   */
  public GenderTypeEnumeration(String gender) {
    this.gender = gender;
  }

  /**
   * Returns the gender value.
   *
   * @return the value
   */
  public String getValue() {
    return this.gender;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.gender;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
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
    GenderTypeEnumeration other = (GenderTypeEnumeration) obj;
    if (this.gender == null) {
      if (other.gender != null) {
        return false;
      }
    }
    else if (!this.gender.equals(other.gender)) {
      return false;
    }
    return true;
  }

}
