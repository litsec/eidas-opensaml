/*
 * Copyright 2016-2021 Litsec AB
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
package se.litsec.eidas.opensaml.metadata;

/**
 * A type safe SAML MetadataServiceList enumeration.
 */
public final class MetadataServiceListVersion {

  /** SAML version 1.0. */
  public static final MetadataServiceListVersion VERSION_10 = new MetadataServiceListVersion(1, 0);

  /** Major version number. */
  private final int majorVersion;

  /** Minor version number. */
  private final int minorVersion;

  /** String representation of the version. */
  private final String versionString;

  /**
   * Constructor.
   * 
   * @param major
   *          major version number
   * @param minor
   *          minor version number
   */
  private MetadataServiceListVersion(final int major, final int minor) {
    this.majorVersion = major;
    this.minorVersion = minor;
    this.versionString = this.majorVersion + "." + this.minorVersion;
  }

  /**
   * Gets the version given the major and minor version number.
   * 
   * @param majorVersion
   *          major version number
   * @param minorVersion
   *          minor version number
   * 
   * @return the version
   */
  public static final MetadataServiceListVersion valueOf(final int majorVersion, final int minorVersion) {
    if (majorVersion == 1 && minorVersion == 0) {
      return MetadataServiceListVersion.VERSION_10;
    }

    return new MetadataServiceListVersion(majorVersion, minorVersion);
  }

  /**
   * Gets the version for a given version string, such as "1.0".
   * 
   * @param version
   *          version string
   * 
   * @return version for the given string
   */
  public static final MetadataServiceListVersion valueOf(String version) {
    String[] components = version.split("\\.");
    return valueOf(Integer.valueOf(components[0]), Integer.valueOf(components[1]));
  }

  /**
   * Gets the major version of the version.
   * 
   * @return the major version of the version
   */
  public int getMajorVersion() {
    return this.majorVersion;
  }

  /**
   * Gets the minor version of the version.
   * 
   * @return the minor version of the version
   */
  public int getMinorVersion() {
    return this.minorVersion;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.versionString;
  }

}
