# Maven Workshop Notes

* Vad?
    - Byggverktyg -- Projekt Management Tool
    - Överlägset vanligaste verktyget för Java-baserade projekt.
    - En del i en kedja
        - Kapslar in de vanligaste behoven vid mjukvaruutveckling.
    - En standardiserad modell (convention over configuration) baserad på en väldefinierad livscykel.

* Varför?
    - Deklarativ - stabilare över tid
        - separera projektbeskrivning från 'implementation'.
        - uppgradera Maven, behåll samma projektbeskrivning
    - Bättre support för modulbaserad utveckling
    - Få styr på dependencies (fler utvecklare)
    - "Works on my computer" isn't good enough
    - Repeatable builds

* POM - Project Object Model
    - Deklarativ modell
        - vs. Ant: Imperativ modell
    - "Vad, inte Hur".
        - Beskriv vad projektet/modulen består av, låt "Convention over Configuration" göra jobbet.
    - **Minimal POM**
        - GroupID: a set of related artifacts
        - ArtifactID: main identifier
        - Version: version (ner senare)
        - Implicit
            - Packaging: JAR
            - Classifier: `<none>`
        - Definierar **Koordinaten** för projektet.
    - POM kan *ärva* från andra projekt.

* Convention over Configuration
    - Ett approach för att bara behöva specificera det absolut nödvändigaste.
    - **Maven directory layout**
    - Vår enkla POM ärver från en "Super-POM"
        - Definierar CoC genom förkonfigurerade _Plugins_.
        - Visa med `mvn help:effective-pom`
        - CoC - består i Mavens fall av en deklarativ projektmodell (POM), en väldefinierad uppsättning 'faser', samt en standardiserad konfigurationsuppsättning av en antal standard-plugins. That's it.
    - Följer man standard-layouten så räcker det med en enkel POM för att kunna:
        - kompilera
        - köra enhetstester
        - generera Javadoc
        - pakterera JAR-fil
        - köra kod-analys (code-coverage)
        - bygga enkel projektdokumentation
        - ...

* Build Lifecycles
    - En annan förutsättning för Convention over Configuration
    - Alla Maven-projekt hanterar en "default-lifecycle" med väl definierade "faser":
        - validate -> compile -> test-compile -> test -> package -> install -> deploy
    - Det enda *Maven* egentligen gör är att driva den livscykeln.
        - Plugins registrerar callbacks vid olika faser och implementerar därmed alla features.
        - *Visa super-POM:en igen*!
    - DOCK: INGET MAN NORMALT SETT BEHÖVER FUNDERA ÖVER.
    - Så - vad händer under normalt sett under varje fas i "Standard Maven"?
        - validate: Validera projektet och dess dependencies
        - compile - kompilera källkod
        - test - well..
        - package - paketera kompilerad kod till en distribuerbar artifakt
        - install - installera paket till `local repository`. Gör det möjligt att referera jar-filen från andra lokala projekt.
        - deploy - distribuera paketet `globalt` (till ett centralt repository).

* Plugins
    - Maven är i sin kärna implementerat av 'plugins'. Det finns t.ex. 
        - compiler-plugin
        - jar-plugin
        - clean-plugin
        - resources-plugin
        - etc. etc.
    - Det *enda* sättet att omsätta den deklarativa modellen till faktiskt *exekvering* av nånting.
    - Ett sätt att registrera callbacks till JAVA_KOD vid vissa *faser* i livscykeln.
    - Vanliga plugins
        - release-plugin
            - Subversion/Git, Branching/Tagging, Verification, Distribution
        - code-coverage
        - WAR-plugin
        - etc.
    - Skriva egna plugins? <https://maven.apache.org/plugin-developers/index.html>

* Repositories
    - Local Repository (`$HOME/.m2/repository`)
        - Här hamnar alla artifakter för lokalt _installerade_ projekt, samt dependencies som Maven laddar ner.
    - Remote Repository
        - Plats varifrån ej lokalt kända artifakter laddas.
        - Normalt: Maven Central <http://search.maven.org>.
        - I HRM - Använder vi NEXUS.
            - Definierad i `repositories-taggen` i vår parent-POM.
            - Här landar artifakter vi kör `deploy` på.

* Dependencies
    - Ett projekt 'deklarerar' att det finns en dependency till andra moduler/projekt:
    - Koordinaten
    - Scope:
        - compile: I classpathen
        - provided: I classpathen, men tar ej med sig transienta deps. Används för att deklarera beroende på en "managerad" dependency (OSGi, Servlets etc.).
        - runtime: Behövs i runtime, men ej vid kompilering
        - test: i classpathen vid test
        - system: undantag - används för att peka ut lokala dependencies.
    - Versioner
        - Kan anges som en 'range'
        - SNAPSHOT versions?
            - Undvik SNAPSHOT-dependencies!
    - Vad är transienta dependencies?!
        - **Rita på tavlan**

* Profiles
    - Varför?
    - Vissa aktiviteter vill man inte alltid köra. T.ex. vissa tester.
    - Windows vs. -Riktiga-Andra OS.

* Frågor

* Introduktion till Övningar



