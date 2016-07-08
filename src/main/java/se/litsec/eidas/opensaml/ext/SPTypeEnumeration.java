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

}
