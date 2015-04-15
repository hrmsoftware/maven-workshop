# Apache Maven

## Agenda

* Vad?
* Varför?
* POM - Project Object Model
* Convention over Configuration
* Build lifecycle
* Plugins
* Repositories
* Dependencies
* *Hämta macka*
* Övningar

## Vad är Maven?

> <http://maven.apache.org>

* Byggverktyg
* .. eller Project Management Tool?
* Överlägset vanligaste verktyget för Java-plattformen.
* Deklarativ modell

## Maven in Context

* Platform: JVM / JDK
    * Compile & Package: [.java] -> [.class] -> [.jar]
        * **Build Tool**: (Maven, SBT, Leiningen, Gradle, etc.)
        * Unit Testing, Javadoc, Code Analysis, Distribution etc.
        * IDE (Eclipse, VIM, IntelliJ etc.)
    * Release Management
    * Deploy to Server

## Varför Maven?

- 'Best Practices'
- Deklarativ ('What' - not 'How')
- Modulbaserad utveckling
- Dependencies
- Ett verktyg för build, package, distribute, release
- Upprepningsbara byggen

## The 'POM'

> <https://maven.apache.org/pom.html>

~~~~~~~~~~~~~~~~~
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>se.hrmsoftware.labb</groupId>
    <artifactId>hello-world-project</artifactId>
    <version>1</version>
</project>
~~~~~~~~~~~~~~~~~

## The 'POM' - Goals

~~~~~~~~~~~~~~~~~~
mvn clean
mvn clean install
mvn install -Dmaven.test.skip=true
mvn test
~~~~~~~~~~~~~~~~~~

## Convention over Configuration

> <https://en.wikipedia.org/wiki/Convention_over_configuration>

~~~~~~~~~~~~~~~~~~~~~~
[maven-module]
    ├── pom.xml
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   └── resources
    │   └── test
    │       ├── java
    │       └── resources
    └── target
        └── classes
~~~~~~~~~~~~~~~~~~~~~~

## CoC - "Super POM"

    mvn help:effective-pom

## Build Lifecycles

> <https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html>

### default life-cycle

* **validate** 
* generate-sources process-sources generate-resources process-resources **compile** process-classes
* generate-test-sources process-test-sources generate-test-resources process-test-resources **test-compile**
* **test**
* prepare-package **package**
* pre-integration-test integration-test post-integration-test
* verify
* **install**
* **deploy**

## Plugins

> Ett sätt att associera exekverbar kod till olika faser i ett projekts livscykel.

* [Help Plugin](https://maven.apache.org/plugins/maven-help-plugin/plugin-info.html)
* Compiler Plugin
* JAR Plugin
* WAR, Code Coverage, Release etc.
* Skriv dina egna: <https://maven.apache.org/plugin-developers/index.html>

## Repositories

* Local Repository: 
    * `$HOME/.m2/repository`

* Remote Repository
    - Maven Central
    - HRM Nexus

## Dependencies (Beroenden)

> <https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html>

~~~~~~~~~~~~~~~~~
<dependencies>
    <dependency>
        <groupId>com.foo</groupId>
        <artifactId>bar</artifactId>
        <version>1.0-SNAPSHOT</version>
        <!-- Optional: -->
        <scope>compile</scope>
        <classifier>java5</classifier>
        <type>jar</type>
    </dependency>
</dependencies>
~~~~~~~~~~~~~~~~~

## Dependencies (Scopes)

- compile
- provided
- runtime 
- test
- system 

## Dependencies (Version)

- Ranges
    - `[4, 5)`
- SNAPSHOT
    - Utvecklingsversionen av ett projekt.
    - 15.1-SNAPSHOT - utvecklingsversionen av 15.1-releasen.

## Dependencies

> Vad är *Transitiva Dependencies*?
>
> Dependencies on dependencies of my direct dependencies ...

`mvn dependency:tree`

## Profiles

> Ett sätt att tillfälligt överlagra vissa delar av POM.

    mvn clean install -Pesa

* Kan initieras på vissa miljöparametrar
* Java-properties

## Länkar

* [Hemsidan](http://maven.apache.org)
* [Boken](http://books.sonatype.com/mvnref-book/reference/)
* [Artifakter](http://search.maven.org)

## Frågor?

## Hämta macka!

## Övningar

* <https://github.com/hrmsoftware/maven-workshop>
* `svn checkout https://github.com/hrmsoftware/maven-workshop`
* `git clone https://github.com/hrmsoftware/maven-workshop.git`
* [Tanka ZIP](https://github.com/hrmsoftware/maven-workshop/archive/master.zip)

