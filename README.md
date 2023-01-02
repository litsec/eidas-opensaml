![Logo](https://litsec.github.io/eidas-opensaml/img/litsec-small.png)

------

# eidas-opensaml

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/se.litsec.eidas/eidas-opensaml4/badge.svg)](https://maven-badges.herokuapp.com/maven-central/se.litsec.eidas/eidas-opensaml4) 

OpenSAML extensions for the eIDAS Framework.

---

**Note**: Support for OpenSAML 2.X and 3.X has been discontinued. The last release of eidas-opensaml supporting OpenSAML 2.X is 1.0.6 and the last release supporting OpenSAML 3.X is 1.4.5.

---

eIDAS (EU REGULATION [910/2014](http://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:32014R0910&from=EN) on electronic identification and trust services for electronic transactions in the European internal market) defines requirements on cross-border recognition of electronic identification means in EU.

The eIDAS technical specifications defines a number of SAML elements and attribute definitions which are normally not supported by standard SAML software. The **eidas-opensaml** Open Source Java library extends the OpenSAML framework with support for the definitions from the eIDAS technical specifications.

The following eIDAS specifications are implemented:
* [eIDAS - Interoperability Architechture v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20Interoperability%20Architecture%20v.1.2%20Final.pdf)

* [ eIDAS - Cryptographic requirements for the Interoperability Framework v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20Cryptographic%20Requirement%20v.1.2%20Final.pdf)

* [eIDAS SAML Message Format v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20SAML%20Message%20Format%20v.1.2%20Final.pdf)

* [eIDAS SAML Attribute Profile v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20SAML%20Attribute%20Profile%20v1.2%20Final.pdf)

> See <https://ec.europa.eu/cefdigital/wiki/display/CEFDIGITAL/eIDAS+eID+Profile> for the eIDAS eID Profile.


### How to use the use the eidas-opensaml library

The eidas-opensaml artifacts are published to Maven central and a dependency to the library should be included as follows in the application POM-file:

```
<dependency>
  <groupId>se.litsec.eidas</groupId>
  <artifactId>eidas-opensaml4</artifactId>
  <version>${eidas-opensaml.version}</version>
</dependency>
```

### Documentation

* API documentation - [https://litsec.github.io/eidas-opensaml/javadoc/opensaml4/2.1.1](https://litsec.github.io/eidas-opensaml/javadoc/opensaml4/).

### Examples

#### Creating an eIDAS AuthnRequest message

The [eIDAS SAML Message Format v1.2](https://github.com/litsec/eidas-opensaml/files/2219283/eIDAS.Message.Format_v1.2_final.docx) specification describes how a SAML `AuthnRequest` message should be put together to comply to the eIDAS specifications. 

[CreateAuthnRequestExample.java](https://github.com/litsec/eidas-opensaml/blob/master/opensaml4/src/test/java/se/litsec/eidas/opensaml/examples/CreateAuthnRequestExample.java) illustrates how you could create an authentication request message using the eidas-opensaml library.

#### Parsing an Assertion

An assertion issued from an eIDAS service will contain the attributes defined in [eIDAS SAML Attribute Profile](https://github.com/litsec/eidas-opensaml/files/3236266/eIDAS.SAML.Attribute.Profile.v1.2-FINAL.pdf).

[ParseAssertionExample.java](https://github.com/litsec/eidas-opensaml/blob/master/opensaml4/src/test/java/se/litsec/eidas/opensaml/examples/ParseAssertionExample.java) shows how to parse an Assertion and get hold of all attribute values.

### Contact and support

![Logo](https://litsec.github.io/eidas-opensaml/img/logo-small.png)

Contact [Litsec Labs](mailto:info@litsec.se) if you have any questions or suggestions ...

### Resources

##### eIDAS Specifications

* [eIDAS - Interoperability Architechture v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20Interoperability%20Architecture%20v.1.2%20Final.pdf)

* [ eIDAS - Cryptographic requirements for the Interoperability Framework v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20Cryptographic%20Requirement%20v.1.2%20Final.pdf)

* [eIDAS SAML Message Format v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20SAML%20Message%20Format%20v.1.2%20Final.pdf)

* [eIDAS SAML Attribute Profile v1.2](https://ec.europa.eu/cefdigital/wiki/download/attachments/82773108/eIDAS%20SAML%20Attribute%20Profile%20v1.2%20Final.pdf)

##### Swedish eID Framework

* [Technical specifications for the Swedish eID Framework](https://github.com/swedenconnect/technical-framework)
* [Sweden Connect](https://swedenconnect.se) - The portal for the Sweden Connect federation.
* [Sweden Connect - Sandbox](https://sandbox.swedenconnect.se/home/) - The portal for the Swedish eID and eIDAS test infrastructure.

##### OpenSAML and Shibboleth

* [Shibboleth Identity Provider v4](https://wiki.shibboleth.net/confluence/display/IDP4/Home) - *built using OpenSAML 4.x*


------

Copyright &copy; 2016-2023, [Litsec AB](http://www.litsec.se). Licensed under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).

