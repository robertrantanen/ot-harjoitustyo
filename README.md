# Laskinsovellus
Käyttäjä pystyy tekemään matemaattisia laskutoimituksia sovelluksen avulla.
## Dokumentaatio
[Vaatimusmäärittely](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/ty%C3%B6aikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/arkkitehtuuri.md)

## Releaset

[Viikko6](https://github.com/robertrantanen/ot-harjoitustyo/releases/tag/v1.2)

## Komentorivitoiminnot
Komennot tehdään sovelluksen juurikansiossa, eli siinä missä on tiedosto pom.xml.

### Testaus

Testit suoritetaan kirjoittamalla komento

```
mvn test
```

Testikattavuusraportti tehdään komennolla

```
mvn jacoco:report
```

Raporttia voi tarkastella internetselaimella avaamalla tiedoston _target/site/jacoco/index.html_.

### Suoritettavan jarin generointi

Komento

```
mvn package
```

luo kansioon _target_ suoritettavan jar-tiedoston _Calculator-1.0-SNAPSHOT.jar_. Sovellus ei kuitenkaan toimi target-kansiossa, sillä se ei pääse käyttämään tarvittavia tietokantatauluja. jar-tiedosto pitää siirtää juurikansioon ensin.


### Checkstyle

Checkstylen määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Raporttia voi tarkastella internetselaimella avaamalla tiedoston _target/site/checkstyle.html_.

### JavaDoc

JavaDoc luodaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella internetselaimella avaamalla tiedoston _target/site/apidocs/index.html_


