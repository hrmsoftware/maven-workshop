# Maven Workshop

* [Hemsidan](http://maven.apache.org)
* [Boken](http://books.sonatype.com/mvnref-book/reference/)
* [Artifakter](http://search.maven.org)

## Vad är Maven?

* Ett "byggverktyg" ----> "a project management tool".
* En standardiserad modell för att hantera ett projekts livscykel, etc.
* Deklarativ modell - beskriv 'vad', inte 'hur' (känns det igen?)
    - Convention over Configuration
* POM (Project Object Model)

## Convention over Configuration

Ett fördefinierat sätt .. källkod, tester, etc.

    [root]
      ├── pom.xml
      └── src
          ├── main
          │   └── java
          │           
          └── test
              └── java

## The 'POM'

* Visa en 'minimal POM'.

    <project>
        <modelVersion>4.0.0</modelVersion>
        <groupId>se.hrmsoftware.labb</groupId>
        <artifactId>hello-world-project</artifactId>
        <version>1</version>
    </project>

* The "Super POM"
    - Defines all "default" plugins and their configuration. This is what establishes the 'convention'.
    - Ergo: everything can be overriden.
* packaging (default: jar).
* groupId - a set of related artifacts.
* artifactId - main identifier
* Version?
    - SNAPSHOT version?
* classifier
    - zip, tar.gz etc.
    - java6 vs. java8
* Project inheritance
    - reactor build

## Build Lifecycles

* A life-cycle consists of a series of phases

- clean
    * pre-clean
    * **clean**
    * post-clean

- default life-cycle
    * **validate** 
    * generate-sources process-sources generate-resources process-resources **compile** process-classes
    * generate-test-sources process-test-sources generate-test-resources process-test-resources **test-compile**
    * **test**
    * prepare-package **package**
    * pre-integration-test integration-test post-integration-test
    * verify
    * **install**
    * **deploy**

* Package-specific plugins use these phases to bind behavior 
    - The JAR plugin binds 'jar:jar' to 'package' (to create a JAR-file).
    - WAR, EJB, EAR etc.

## Repositories

* Local repos
* Remote repos
* Global repos

## Dependencies (Beroenden)

* Koordinat
* Scopes
    - compile
    - provided
    - runtime 
    - test
    - system 
    - optional dependencies
* Versions
    - version ranges.


## Profiles
