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
package se.litsec.eidas.opensaml.ext.attributes;

/**
 * Constant values for attribute names defined in
 * <a href="https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20SAML%20Attribute%20Profile%20v1.1_2.pdf">eIDAS SAML
 * Attribute Profile</a>.
 * 
 * @author Martin Lindström (martin.lindstrom@litsec.se)
 */
public class AttributeConstants {

  /** Attribute name for the LoA attribute used in metadata (as an EntityAttribute). */
  public static final String EIDAS_LOA_ATTRIBUTE_NAME = "http://eidas.europa.eu/LoA";
  
  /** Attribute name prefix for eIDAS natural person. */
  public static final String NATURAL_PERSON_PREFIX = "http://eidas.europa.eu/attributes/naturalperson/";
  
  /** Attribute name prefix for eIDAS representative natural person. */
  public static final String REPRESENTATIVE_NATURAL_PERSON_PREFIX = "http://eidas.europa.eu/attributes/naturalperson/representative/";
  
  /** Attribute name prefix for eIDAS legal person. */
  public static final String LEGAL_PERSON_PREFIX = "http://eidas.europa.eu/attributes/legalperson/";
  
  /** Attribute name prefix for eIDAS representative legal person. */
  public static final String REPRESENTATIVE_LEGAL_PERSON_PREFIX = "http://eidas.europa.eu/attributes/legalperson/representative/";

  /** Attribute name for PersonIdentifier. */
  public static final String EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "PersonIdentifier";

  /** PersonIdentifier friendly name. */
  public static final String EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_FRIENDLY_NAME = "PersonIdentifier";

  /** Attribute name for CurrentFamilyName. */
  public static final String EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "CurrentFamilyName";

  /** CurrentFamilyName friendly name. */
  public static final String EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME = "FamilyName";

  /** Attribute name for CurrentGivenName. */
  public static final String EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "CurrentGivenName";

  /** CurrentGivenName friendly name. */
  public static final String EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_FRIENDLY_NAME = "FirstName";

  /** Attribute name for DateOfBirth. */
  public static final String EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "DateOfBirth";

  /** DateOfBirth friendly name. */
  public static final String EIDAS_DATE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "DateOfBirth";

  /** Attribute name for Gender. */
  public static final String EIDAS_GENDER_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "Gender";

  /** Gender friendly name. */
  public static final String EIDAS_GENDER_ATTRIBUTE_FRIENDLY_NAME = "Gender";

  /** Attribute name for CurrentAddress. */
  public static final String EIDAS_CURRENT_ADDRESS_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "CurrentAddress";

  /** CurrentGivenName friendly name. */
  public static final String EIDAS_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME = "CurrentAddress";
  
  /** Attribute name for BirthName. */
  public static final String EIDAS_BIRTH_NAME_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "BirthName";
  
  /** BirthName friendly name. */
  public static final String EIDAS_BIRTH_NAME_ATTRIBUTE_FRIENDLY_NAME = "BirthName";

  /** Attribute name for PlaceOfBirth. */
  public static final String EIDAS_PLACE_OF_BIRTH_ATTRIBUTE_NAME = NATURAL_PERSON_PREFIX + "PlaceOfBirth";
  
  /** PlaceOfBirth friendly name. */
  public static final String EIDAS_PLACE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "PlaceOfBirth";
  
  /** Attribute name for representative PersonIdentifier. */
  public static final String EIDAS_REPRESENTATIVE_PERSON_IDENTIFIER_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "PersonIdentifier";

  /** Representative PersonIdentifier friendly name. */
  public static final String EIDAS_REPRESENTATIVE_PERSON_IDENTIFIER_ATTRIBUTE_FRIENDLY_NAME = "RepresentativePersonIdentifier";

  /** Attribute name for representative CurrentFamilyName. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "CurrentFamilyName";

  /** Representative CurrentFamilyName friendly name. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_FAMILY_NAME_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeFamilyName";

  /** Attribute name for representative CurrentGivenName. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "CurrentGivenName";

  /** Representative CurrentGivenName friendly name. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_GIVEN_NAME_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeFirstName";

  /** Attribute name for representative DateOfBirth. */
  public static final String EIDAS_REPRESENTATIVE_DATE_OF_BIRTH_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "DateOfBirth";

  /** Representative DateOfBirth friendly name. */
  public static final String EIDAS_REPRESENTATIVE_DATE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeDateOfBirth";

  /** Attribute name for representative Gender. */
  public static final String EIDAS_REPRESENTATIVE_GENDER_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "Gender";

  /** Representative Gender friendly name. */
  public static final String EIDAS_REPRESENTATIVE_GENDER_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeGender";

  /** Attribute name for representative CurrentAddress. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_ADDRESS_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "CurrentAddress";

  /** Representative CurrentGivenName friendly name. */
  public static final String EIDAS_REPRESENTATIVE_CURRENT_ADDRESS_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeCurrentAddress";
  
  /** Attribute name for representative BirthName. */
  public static final String EIDAS_REPRESENTATIVE_BIRTH_NAME_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "BirthName";
  
  /** Representative BirthName friendly name. */
  public static final String EIDAS_REPRESENTATIVE_BIRTH_NAME_ATTRIBUTE_FRIENDLY_NAME = "RepresentativeBirthName";

  /** Attribute name for representative PlaceOfBirth. */
  public static final String EIDAS_REPRESENTATIVE_PLACE_OF_BIRTH_ATTRIBUTE_NAME = REPRESENTATIVE_NATURAL_PERSON_PREFIX + "PlaceOfBirth";
  
  /** Representative PlaceOfBirth friendly name. */
  public static final String EIDAS_REPRESENTATIVE_PLACE_OF_BIRTH_ATTRIBUTE_FRIENDLY_NAME = "RepresentativePlaceOfBirth";
  
}
