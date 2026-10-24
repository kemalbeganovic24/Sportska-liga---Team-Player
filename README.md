# Sportska liga

Mini MVC aplikacija izrađena u **Spring Bootu** za prikaz timova i igrača sportske lige.
Aplikacija je urađena u okviru **Lab vježbe 1** iz predmeta *Web programiranje* (Politehnički fakultet, Univerzitet u Zenici).

Podaci su pohranjeni **in-memory** (u običnim Java listama), bez baze podataka, a prikaz se radi pomoću **Thymeleaf** šablona.

---

## Članovi tima

| Student | Zaduženje |
|---------|-----------|
| Kemal Beganović (Student A) | Model **Team**, rute i view liste timova |
| Ines Murtezanović (Student B) | Model **Player**, rute i view liste igrača |

---

## Tehnologije

- Java 25
- Spring Boot 3.5.6 (Spring Web, Thymeleaf, DevTools)
- Maven
- HTML i CSS (stilovi su ugrađeni u svaki šablon)
- IntelliJ IDEA

---

## Opis modela i relacije

### Team (tim)

| Polje | Tip | Opis |
|-------|-----|------|
| `id` | Long | Jedinstveni identifikator tima |
| `nazivTima` | String | Naziv tima |
| `grad` | String | Grad iz kojeg tim dolazi |
| `godinaOsnivanja` | int | Godina osnivanja kluba |
| `players` | List&lt;Player&gt; | Lista igrača koji pripadaju timu |

### Player (igrač)

| Polje | Tip | Opis |
|-------|-----|------|
| `id` | Long | Jedinstveni identifikator igrača |
| `ime` | String | Ime igrača |
| `prezime` | String | Prezime igrača |
| `pozicija` | String | Pozicija na terenu (napadač, vezni, odbrana...) |
| `brojDresa` | int | Broj dresa |
| `team` | Team | Tim kojem igrač pripada |

Dodatno, klasa `Player` ima izvedene metode `getImePrezime()` (spaja ime i prezime) i `getNazivTima()` (vraća naziv tima kojem igrač pripada), koje se koriste u prikazima.

### Relacija

Veza je **1:N (jedan prema više)**: jedan tim ima više igrača, a svaki igrač pripada tačno jednom timu.

- U modelu `Team` relacija je predstavljena listom `players`, a u modelu `Player` poljem `team`.
- U view-u se relacija vidi na tri mjesta:
  - lista timova prikazuje **broj igrača** u svakom timu,
  - lista igrača prikazuje **naziv tima** kojem igrač pripada,
  - stranica akcije prikazuje **sve igrače odabranog tima**.

---

## Rute

| Ruta | Opis |
|------|------|
| `/` | Preusmjerava na listu timova |
| `/a` | Lista svih timova (ID, naziv, grad, godina osnivanja, broj igrača, link na detalje) |
| `/b` | Lista svih igrača (ID, ime, prezime, pozicija, broj dresa, tim) |
| `/a/action/{id}` | Zajednička stranica akcije: detalji odabranog tima i tabela njegovih igrača |

Ako tim s traženim `id` ne postoji, na stranici akcije se prikazuje poruka *"Tim nije pronađen."*.

---

## Struktura projekta

```
Sportska-liga/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/example/Sportska/liga/
    │   │   ├── SportskaLigaApplication.java   # ulazna tačka aplikacije
    │   │   ├── controller/
    │   │   │   └── PlayerController.java      # rute /, /a, /b i /a/action/{id}
    │   │   ├── data/
    │   │   │   └── DemoData.java              # in-memory demo podaci
    │   │   └── model/
    │   │       ├── Team.java
    │   │       └── Player.java
    │   └── resources/
    │       ├── application.properties
    │       └── templates/
    │           ├── listaA.html                # lista timova
    │           ├── listaB.html                # lista igrača
    │           └── action.html                # detalji tima
    └── test/java/com/example/Sportska/liga/
        └── SportskaLigaApplicationTests.java
```

---

## Demo podaci

Podaci se učitavaju pri pokretanju aplikacije u klasi `DemoData`:

| Tim | Grad | Godina osnivanja | Igrači |
|-----|------|------------------|--------|
| NK Čelik | Zenica | 1945 | Edin Džeko, Samir Lemeš |
| FK Sarajevo | Sarajevo | 1946 | Edin Tabak |

Podaci su izmišljeni i služe samo za demonstraciju.

---

## Kako pokrenuti aplikaciju

**Preduslovi:** instaliran JDK 25 i Maven (ili IntelliJ IDEA, koji ih može koristiti ugrađeno).

**IntelliJ IDEA**
1. Otvori folder projekta (onaj u kojem je `pom.xml`) preko *File → Open*.
2. U *File → Project Structure → Project* postavi SDK na 25.
3. Desni klik na `pom.xml` → *Maven → Reload project*.
4. Pokreni klasu `SportskaLigaApplication`.

**Terminal**
```
mvnw spring-boot:run
```
(na Linuxu i Macu `./mvnw spring-boot:run`)

Nakon pokretanja aplikacija je dostupna na adresi `http://localhost:8080`.
Korijenska adresa `/` preusmjerava na listu timova, pa je dovoljno otvoriti `http://localhost:8080/a`.

---

## Šta je urađeno / ispravljeno

Prva verzija projekta nije se mogla pokrenuti, pa je napravljena nova, ispravljena verzija. Ključne izmjene:

**Struktura i konfiguracija**
- Java klase su premještene iz `src/main/resources` u `src/main/java`, jer Maven samo tamo kompajlira izvorni kod.
- Paketi su usklađeni sa strukturom foldera (`com.example.Sportska.liga.model`, `...data`, `...controller`), tako da ih Spring pronalazi.
- Test klasa je premještena u `src/test/java`.
- U `pom.xml` je ispravljen `artifactId` (razmak nije dozvoljen), postavljena je Java 25, a nekorištena Lombok zavisnost je uklonjena.

**Modeli**
- `Team`: metode `getGodinaOsnivanja()` i `getPlayers()` su pozivale same sebe (beskonačna rekurzija); sada vraćaju polja. ID je promijenjen u `Long`, a lista igrača se inicijalizira pri kreiranju objekta.
- `Player`: ispravljen je `setPozicija` (primao je `int`, a ništa nije postavljao), uklonjeno je pogrešno polje `nazivTima` koje se samo dodjeljivalo samom sebi, a naziv tima se sada izvodi iz objekta `Team`. Dodana je metoda `getImePrezime()`.

**Podaci**
- `DemoData`: ispravljena inicijalizacija (`Long` ID-evi), a igrači se dodaju kroz pomoćnu metodu koja ih istovremeno upisuje u listu igrača i u listu svog tima, pa su podaci konzistentni.

**Kontroler**
- Dodan nedostajući import `@Controller` i nedostajući `;`.
- Ruta `/a/action/{id}` sada u model šalje i tim i listu njegovih igrača.
- Dodana je ruta `/` koja preusmjerava na `/a`.

**View-ovi**
- `listaA.html`: popravljen nezatvoren `<tr>`, dodani stupac s brojem igrača i link na stranicu akcije za svaki tim.
- `listaB.html`: ispravljeni nazivi atributa (`ime`, `prezime` umjesto `Ime`, `Prezime`) i prikaz naziva tima.
- `action.html`: ispravljen prikaz igrača, simbol za povratak (`&larr;`), a prikaz se pokazuje samo kad tim postoji.

---

## Screenshot aplikacije

**Lista timova (`/a`)**

<img width="1920" height="1200" alt="Screenshot 2026-10-24 112755" src="https://github.com/user-attachments/assets/337e856e-e138-4994-8954-9c91034e5a27" />


**Lista igrača (`/b`)**

<img width="1920" height="1200" alt="Screenshot 2026-10-24 112807" src="https://github.com/user-attachments/assets/6ecd9e5a-f3ba-4b26-aea4-f7984622f42c" />


**Detalji tima (`/a/action/1`)**

<img width="1920" height="1200" alt="Screenshot 2026-10-24 112826" src="https://github.com/user-attachments/assets/0b807c1a-9c69-4bb2-aa2b-b9b02975324d" />

