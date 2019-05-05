### Testausdokumentti
Kaikki testaus tapahtuu luokassa CalculusTest. Luokka tekee yksikkötestejä Calculus-luokalle sekä testaa epäsuorasti HistoryDao-luokkaa integraatiotesteillä. Testiluokka käyttää eri tietokantaa kuin sovellus.

### Testauskattavuus
Käyttöliittymää lukuunottamatta testauksen rivikattavuus on 100% ja haarautumakattavuus on 87%. Monet puuttuvista haarautumista ovat sellaisia, mitä sovelluksessa ei ikinä pääse tapahtumaan. Esimerkiksi kahden numeron välissä oleva funktiomerkki ei voi olla mitään muuta kuin mitä sovelluksessa voi syöttää.

![testikattavuus](https://raw.githubusercontent.com/robertrantanen/ot-harjoitustyo/master/Documentation/kuvat/testikattavuus.png)

### Järjestelmäteustaus
JUnit-testien lisäksi olen testannut sovelluksen toimintaa manuaalisesti. Varmistin, että kaikki määrittelydokumentin toiminnallisuudet toimivat ja lisäksi yritin kaataa sovelluksen typerillä syötteillä.
