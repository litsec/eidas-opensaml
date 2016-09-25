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
package se.litsec.eidas.opensaml.common;

/**
 * Enumeration representing an eIDAS Level of Assurance.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public enum EidasLoaEnum {
  
  /** eIDAS "low" Level of assurance. */
  LOA_LOW(EidasConstants.EIDAS_LOA_HIGH),
  
  /** eIDAS "substantial" Level of assurance. */
  LOA_SUBSTANTIAL(EidasConstants.EIDAS_LOA_SUBSTANTIAL),
  
  /** eIDAS "high" Level of assurance. */
  LOA_HIGH(EidasConstants.EIDAS_LOA_HIGH);
  
  /**
   * Returns the URI for this LoA.
   * 
   * @return an URI
   */
  public String getUri() {
    return this.loaUri;
  }
  
  /**
   * Given a URI the method returns the enum value matching.
   * 
   * @param uri
   *          URI
   * @return the matching enum value or {@code null} is no match is found
   */
  public static EidasLoaEnum parse(String uri) {
    for (EidasLoaEnum loa : EidasLoaEnum.values()) {
      if (loa.getUri().equals(uri)) {
        return loa;
      }
    }
    return null;
  }

  
  /**
   * Constructor setting the LoA URI.
   * @param uri the LoA URI
   */
  private EidasLoaEnum(String uri) {
    this.loaUri = uri;
  }
  
  /** The LoA URI. */
  private String loaUri;

}
