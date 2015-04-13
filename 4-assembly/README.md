Givet nästan vilket projekt som helst så hamnar man ofta snabbt i läget att man vill kunna distribuera sina alster på 
ett smidigt sätt. Det räcker oftast inte att man får en jar-fil eller en war-fil utan man behöver skapa en distributionsfil
som innehåller mer saker än bara den kompilerade koden, exempelvis bilder eller andra saker. 

Till hjälp kommer då [maven-assembly-plugin](http://maven.apache.org/plugins/maven-assembly-plugin/). 
En assembly definieras i en egen fil, en så kallad assembly fil. 



Övning:

+ Skapa en zip fil innehållande jar filen som produceras av projektet och filen som finns i *etc* mappen.


För att validera ett lyckat resultat skall du kunna packa upp filen på någon favorituppackningsplats och sen köra

    java -cp assembly-project-1.0-SNAPSHOT.jar se.hrm.Doh
    
i denna katalog. Körningen skall inte resultera i några skrik på System.out. 