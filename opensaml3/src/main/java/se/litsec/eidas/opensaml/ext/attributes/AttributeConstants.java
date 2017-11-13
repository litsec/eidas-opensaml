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
package se.litsec.eidas.opensaml.ext.attributes;

/**
 * Constant values for attribute names defined in
 * <a href="https://joinup.ec.europa.eu/sites/default/files/eidas_saml_attribute_profile_v1.0_2.pdf">eIDAS SAML
 * Attribute Profile</a>.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class AttributeConstants {

  /** Attribute name for the LoA attribute used in metadata (as an EntityAttribute). */
  public static final String EIDAS_LOA_ATTRIBUTE_NAME = "http://eidas.europa.eu/LoA";

  /** Attribute name for PersonIdentifier. */
  public static final String EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier";

  /** PersonIdentifier friendly name. */
  public static final String EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_FRIENDLY_NAME = "PersonIdentifier";

  /** Attribute name for CurrentFamilyName. */
  public static final String EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/CurrentFamilyName";

  /** CurrentFamilyName friendly name. */
  public static final String EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME = "FamilyName";

  /** Attribute name for CurrentGivenName. */
  public static final String EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/CurrentGivenName";

  /** CurrentGivenName friendly name. */
  public static final String EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_FRIENDLY_NAME = "FirstName";

  /** Attribute name for DateOfBirth. */
  public static final String EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/DateOfBirth";

  /** DateOfBirth friendly name. */
  public static final String EIDAS_DATE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "DateOfBirth";

  /** Attribute name for Gender. */
  public static final String EIDAS_GENDER_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/Gender";

  /** Gender friendly name. */
  public static final String EIDAS_GENDER_ATTRIBUTE_FRIENDLY_NAME = "Gender";

  /** Attribute name for CurrentAddress. */
  public static final String EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/CurrentAddress";

  /** CurrentGivenName friendly name. */
  public static final String EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME = "CurrentAddress";
  
  /** Attribute name for BirthName. */
  public static final String EIDAS_BIRTH_NAME_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/BirthName";
  
  /** BirthName friendly name. */
  public static final String EIDAS_BIRTH_NAME_ATTRIBUTE_FRIENDLY_NAME = "BirthName";

  /** Attribute name for PlaceOfBirth. */
  public static final String EIDAS_PLACE_OF_BIRTH_ATTRIBUTE_NAME = "http://eidas.europa.eu/attributes/naturalperson/PlaceOfBirth";
  
  /** PlaceOfBirth friendly name. */
  public static final String EIDAS_PLACE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "PlaceOfBirth";
  
}
