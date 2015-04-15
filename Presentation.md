# Maven Workshop

## Vad är Maven?

* Ett "byggverktyg" ----> "a project management tool".
* En standardiserad modell för att hantera ett projekts livscykel, etc.
* Det överlägset vanligaste verktyget. Andra alternativ som erbjuder delvis samma modell:
    - Gradle (Groovy)
    - Simple Build Tool (Scala)
    - Leiningen (Clojure)
    - Ant (XML)
* Deklarativ modell - beskriv 'vad', inte 'hur' (känns det igen?)
    * POM (Project Object Model)
    - Convention over Configuration

* Maven in the bigger picture ..

    - Java Toolset (compiler / runtime)
    - Compile .java -> .class -> .jar
    - Other features: unit-testing, javadoc, code analyzis, etc.
    - Distribute -> Upload, Deploy
    - IDE
    - etc.

## Hur kör man Maven

* Java-versionen i `$JAVA_HOME` används - eller den i "pathen".

    `mvn clean`
    `mvn clean install`
    `mvn install -Dmaven.test.skip=true`
    `mvn install -Pfoo`

## Convention over Configuration

Ett fördefinierat sätt .. källkod, tester, etc.

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


CoC - består i Mavens fall av en deklarativ projektmodell (POM), en väldefinierad uppsättning 'faser', samt en standardiserad konfigurationsuppsättning av en antal standard-plugins. That's it.

* Compiler-pluginets default-konfiguration letar efter `src/main/java` och skriver klasser till `target/classes`.
* Resource-pluginet letar efter resurser i `src/main/resources` etc.

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

## Plugins

Vad är de, och - på hög nivå - hur interagerar de med livscykelns olika faser och POM.

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


## Repositories

* install vs. deploy

* Local repos
* Remote repos
    - remote repo defined in POM.
    - mirrors
* Global repos

## Profiles

* Ett sätt att villkorligt definiera utökningar till en POM. T.ex. `-P`, men även genom andra sätt (env-parametrar etc.).

## Länkar

* [Hemsidan](http://maven.apache.org)
* [Boken](http://books.sonatype.com/mvnref-book/reference/)
* [Artifakter](http://search.maven.org)

