# Laskinsovellus
Käyttäjä pystyy tekemään matemaattisia laskutoimituksia sovelluksen avulla.
## Dokumentaatio
[Käyttöohje](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/k%C3%A4ytt%C3%B6ohje.md)

[Vaatimusmäärittely](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/ty%C3%B6aikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/robertrantanen/ot-harjoitustyo/blob/master/Documentation/testaus.md)

## Releaset

[Lopullinen](https://github.com/robertrantanen/ot-harjoitustyo/releases/tag/v1.4)

[Viikko 6](https://github.com/robertrantanen/ot-harjoitustyo/releases/tag/v1.2)

[Viikko 5](https://github.com/robertrantanen/ot-harjoitustyo/releases/tag/v1.1)

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
Huom: jacoco meni minulla rikki yhdessä vaiheessa enkä ole testannut toimiiko se enää laitoksen koneilla.

### Suoritettavan jarin generointi

Komento

```
mvn package
```

luo kansioon _target_ suoritettavan jar-tiedoston _Calculator-1.0-SNAPSHOT.jar_. Jarin voi sitten ajaa komennolla

```
java -jar target/Calculator-1.0-SNAPSHOT.jar
```

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


