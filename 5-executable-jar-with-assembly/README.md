Ett projekt för att kunna skapa en distribution med en exekverbar jar-fil med medföljande lib. 

Din uppgift

+ Gör så att jar-filen som produceras är exekverbar, hint undersök vad som behövs för att göra en jar fil exekverbar
samt vad det finns för konfigurationsmöjligheter på jar-pluginet.

+ Skapa en assembly som paketerar projektet så att projekt-jaren finns i rooten på zipfilen och att beroenden paketeras
med, förslagsvis i en egen katalog. 

Detta innebär att när man paketerar upp zipfilen skall kunna köra 

    java hellow-1.0-SNAPSHOT.jar 
   
...och att det då händer någon form av Doh!. 