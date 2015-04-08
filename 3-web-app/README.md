Exempel på en annan packeteringstyp än 'JAR': En webbapplikation.

Mer information: https://maven.apache.org/plugins/maven-war-plugin/index.html

Förutom de vanliga livscykelfaserna: package/install för att bygga WAR-filen finns även:

    `war:exploded` - bygg en "exploderad" version av WAR-filen. Lämplig för att 

Notera hur dependencies automagiskt kopieras till `WEB-INF/lib` i den färdiga war-filen.

Övning: 

* Använd `war:exploded` för att köra WAR-filen i Tomcat.
* Varför är dependencien på 'servlet-api' satt till 'provided'.
* Starta en "embeddad" jetty-server med applikationen (se http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)

