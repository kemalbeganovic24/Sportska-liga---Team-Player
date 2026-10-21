#Sportska liga 

Mini MVC Spring Boot aplikacija za prikaz timova i igrača sportske lige.

##Članovi tima

-Kemal Beganović (Student A-Model Team , rute i view lista timova)
-Ines Murtezanović (Student B-Model Player, rute i view lista igrača)

##Opis modela i relacije

TEAM
-id
-nayivTima
-grad
-godinaOsnivanja

PLAYER
-id
-ime
-prezime
-pozicija
-brojDresa
-nazivTima

Relacija: 1:N - jedan tim ima više igrača , a svaki igrač pripada jednom timu.
Relacija je prikazana u view-u: na stranici liste timova prikazuje se broj igra;a ili njihova lista, a na stranici liste igrača prikazuju se  naziv tima kojem igrač pripada.

##Rute
-'/a' -lista timova
-'/b' - lista igrača
'/a/action/{id}' - stranica akcije (zajednička) za odabrani tim

##Tehnologije
-Java, Spring Boot
-Thymeleaf
-In-memory podaci 

##Screenshot aplikacije
