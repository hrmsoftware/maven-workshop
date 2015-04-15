Titta på POM-filen en katalog upp.

Den innehåller en `modules`-sektion som pekar ut underprojekten och gör det möjligt att göra en sk. "Reactor Build".

+ Ställ dig en katalog upp (maven-workshop) och kör `mvn clean install`. Notera att Reaktor-ordningen skrivs ut och att alla (?) sub-moduler ingår.
    - Bygger går inte riktigt bra :p Varför då?
    - Fixa felet.
+ Test nu att köra `mvn clean compile` från samma plats.
    - Det funkar inte heller... Varför då?
