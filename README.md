![Logo](https://litsec.github.io/eidas-opensaml/img/litsec-small.png)

------

# eidas-opensaml

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/se.litsec.eidas/eidas-opensaml3/badge.svg)](https://maven-badges.herokuapp.com/maven-central/se.litsec.eidas/eidas-opensaml3)

OpenSAML extensions for the eIDAS Framework.

eIDAS (EU REGULATION [910/2014](http://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:32014R0910&from=EN) on electronic identification and trust services for electronic transactions in the European internal market) defines requirements on cross-border recognition of electronic identification means in EU.

The eIDAS technical specifications defines a number of SAML elements and attribute definitions which are normally not supported by standard SAML software. The **eidas-opensaml** Open Source Java library extends the OpenSAML 3.X framework with support for the definitions from the eIDAS technical specifications.

The following eIDAS specifications are implemented:
* [eIDAS - Interoperability Architechture v1.0](https://joinup.ec.europa.eu/sites/default/files/eidas_interoperability_architecture_v1.00.pdf)
* [eIDAS SAML Message Format v1.1-2](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20Message%20Format_v1.1-2.pdf)
* [eIDAS SAML Attribute Profile v1.1_2](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20SAML%20Attribute%20Profile%20v1.1_2.pdf) 

> **Note**: Support for OpenSAML 2.X has been discontinued. The last release of eidas-opensaml supporting OpenSAML 2.X is 1.0.6.

### How to use the use the eidas-opensaml library

The eidas-opensaml artifacts are published to Maven central and a dependency to the library should be included as follows in the application POM-file:

```
<dependency>
  <groupId>se.litsec.eidas</groupId>
  <artifactId>eidas-opensaml3</artifactId>
  <version>1.1.0</version>
</dependency>
```

### Documentation

* API documentation - [https://litsec.github.io/eidas-opensaml/javadoc/opensaml3/1.1.0](https://litsec.github.io/eidas-opensaml/javadoc/opensaml3/1.1.0/index.html).
* Generated project documentation - [https://litsec.github.io/eidas-opensaml/site/opensaml3](https://litsec.github.io/eidas-opensaml/site/opensaml3/index.html).

### Examples

#### Creating an eIDAS AuthnRequest message

The [eIDAS SAML Message Format](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20Message%20Format_v1.1-2.pdf) specification describes how a SAML `AuthnRequest` message should be put together to comply to the eIDAS specifications. 

[CreateAuthnRequestExample.java](https://github.com/litsec/eidas-opensaml/blob/master/opensaml3/src/test/java/se/litsec/eidas/opensaml/examples/CreateAuthnRequestExample.java) illustrates how you could create an authentication request message using the eidas-opensaml library.

#### Parsing an Assertion

An assertion issued from an eIDAS service will contain the attributes defined in [eIDAS SAML Attribute Profile](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20SAML%20Attribute%20Profile%20v1.1_2.pdf).

[ParseAssertionExample.java](https://github.com/litsec/eidas-opensaml/blob/master/opensaml3/src/test/java/se/litsec/eidas/opensaml/examples/ParseAssertionExample.java) shows how to parse an Assertion and get hold of all attribute values.

### Contact and support

![Logo](https://litsec.github.io/eidas-opensaml/img/logo-small.png)

Contact [Litsec Labs](mailto:info@litsec.se) if you have any questions or suggestions ...

### Resources

##### eIDAS Specifications

* [eIDAS - Interoperability Architechture v1.0](https://joinup.ec.europa.eu/sites/default/files/eidas_interoperability_architecture_v1.00.pdf)
* [eIDAS SAML Message Format v1.1-2](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20Message%20Format_v1.1-2.pdf)
* [eIDAS SAML Attribute Profile v1.1_2](https://ec.europa.eu/cefdigital/wiki/download/attachments/46992719/eIDAS%20SAML%20Attribute%20Profile%20v1.1_2.pdf)

##### Swedish eID Framework

* [Technical specifications for the Swedish eID Framework](https://github.com/elegnamnden/technical-framework)
* [eIDAS web](http://eidasweb.se/home/) - The portal for the Swedish eID and eIDAS test infrastructure.

##### OpenSAML and Shibboleth

* [OpenSAML v3 Confluence](https://wiki.shibboleth.net/confluence/display/OS30/Home)
* [OpenSAML v3 API documentation](https://build.shibboleth.net/nexus/content/sites/site/java-opensaml/3.3.0/apidocs/)
* [Shibboleth Identity Provider v3](https://wiki.shibboleth.net/confluence/display/IDP30) - *built using OpenSAML 3.x*


------

Copyright &copy; 2016-2018, [Litsec AB](http://www.litsec.se). Licensed under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).

