# Apache Maven

## Vad är Maven?

> <http://maven.apache.org>
 

~~~~~~~~~~~~~~~~~
* Platform: JVM / JDK
    * Compile & Package: [.java] -> [.class] -> [.jar]
        * **Build Tool**: (Maven, SBT, Leiningen, Gradle, etc.)
        * Unit Testing, Javadoc, Code Analysis, Distribution etc.
        * IDE (Eclipse, VIM, IntelliJ etc.)
    * Release Management
    * Deploy to Server
~~~~~~~~~~~~~~~~~

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

## The 'POM'

> <https://maven.apache.org/pom.html>

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
* classifier
    - zip, tar.gz etc.
    - java6 vs. java8
* Project inheritance
    - reactor build

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

- `mvn help:effective-pom`

CoC - består i Mavens fall av en deklarativ projektmodell (POM), en väldefinierad uppsättning 'faser', samt en standardiserad konfigurationsuppsättning av en antal standard-plugins. That's it.

* Compiler-pluginets default-konfiguration letar efter `src/main/java` och skriver klasser till `target/classes`.
* Resource-pluginet letar efter resurser i `src/main/resources` etc.

## Build Lifecycles

> <https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html>

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

## Hur kör man Maven

Java-versionen i `$JAVA_HOME` används - eller den i "pathen".

~~~~~~~~~~~~~~~~~~
mvn clean
mvn clean install
mvn install -Dmaven.test.skip=true
mvn install -Pfoo
~~~~~~~~~~~~~~~~~~

## Plugins

Vad är de, och - på hög nivå - hur interagerar de med livscykelns olika faser och POM.

* [Help Plugin](https://maven.apache.org/plugins/maven-help-plugin/plugin-info.html)

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

* Koordinat
* Scopes
    - compile
    - provided
    - runtime 
    - test
    - system 
    - optional dependencies
* Versions
    - version ranges `[inkl, excl)`
    - Snapshot version

* Transient dependencies?


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

## Övningar

* <https://github.com/hrmsoftware/maven-workshop>
* `svn checkout https://github.com/hrmsoftware/maven-workshop`
* `git clone https://github.com/hrmsoftware/maven-workshop.git`
* [Tanka ZIP](https://github.com/hrmsoftware/maven-workshop/archive/master.zip)

