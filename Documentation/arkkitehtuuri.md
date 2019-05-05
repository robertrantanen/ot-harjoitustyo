### Sovelluksen rakenne
#### Pakkauskaavio
![pakkauskaavio](https://raw.githubusercontent.com/robertrantanen/ot-harjoitustyo/master/Documentation/kuvat/pakkauskaavio.jpg)

Sovelluksen rakenne on aika yksinkertainen. Calculus-luokka vastaa kahdesta toiminnallisuudesta, joten se oltaisiin voitu jakaa kahteen eri luokkaan, mutta historiatoiminnallisuudesta yksinään vastaava luokka olisi ollut hyvin pieni. En jaksanut toteuttaa Dao-rajapintaa, sillä vain yksi luokka olisi perinyt sen. Vale-Dao:ja ei tarvita, sillä testit käyttävät eri tietokantaa kuin sovellus.

###  Käyttöliittymä
Käyttöliittymä on rakennettu luokassa calculator.ui.UserInterface. Käyttöliittymä sisältää kaksi näkymää, laskutoimitusnäkymän ja historianäkymän. Laskutoimitusnäkymässä käyttäjä voi painella nappeja, jotka sitten ilmestyvät laskimen näyttöön. Historianäkymässä käyttäjä näkee 10 viimeistä laskutoimitusta ja voi poistaa historian.

Sovelluslogiikka on pyritty eristämään käyttöliittymästä eli laskutoimitukset tehdään kutsumalla sovelluslogiikka-olion metodeja. Historianäkymään siirryttäessä kutsutaan myös sovelluslogiikka-oliota, joka taas kutsuu tietokannasta vastaavaa oliota. Käyttöliittymäluokassa on kuitenkin omia boolean-muuttujia, jotka estävät käyttäjää painelemesta nappeja typerästi (eli sovellus kaatuisi virheeseen laskutoimituksen yhteydessä). Nähdäkseni tämän voi vielä tulkita käyttöliittymätoimintona.

### Sovelluslogiikka
Sovelluslogiikka tapahtuu luokassa calculator.domain.Calculus. Luokan päätehtävänä on ratkaista laskutoimituksia ja palauttaa niiden vastaukset käyttöliittymälle. Teknisistä syistä laskin pystyy ratkaisemaan vain laskutoimituksia, joissa on kaksi parametria ja välissä yksi funktiomerkki. Luokan metodit ja myös käyttöliittymä pitävät huolen siitä, että metodit eivät kaadu virheisiin. Calculus-luokan tehtävänä on myös kutsua tietokannasta vastaavaa oliota, tärkeimpänä addItem-metodin kutsu parametrilla "laskutoimitus" + "=" + "vastaus".

### Tietojen pysyväistallennus
Luokka calculator.dao.HistoryDao huolehtii tietokantaoperaatioista. Sen nimessä on DAO, mutta se ei kuitenkaan taida noudattaa kyseistä mallia (ei rajapintaa tai olioita). Luokan avulla tietokantaan voi lisätä rivin, noutaa 10 viimeistä riviä tai poistaa kaikki rivit. Luokassa on myös metodi tietokantojen luomiseen. Laskutoimitukset tallennetaan tietokantaan merkkijonomuotoisena. Laskutoimitukset voisivat olla omia olioitakin, mutta en nähnyt mitään hyvää syytä siihen.

### Laskutoimituksen tekeminen
Seuraava sekvenssikaavio kuvaa tapahtumaa, kun sovellus käynnistetään ja käyttäjä tekee laskutoimituksen "1 + 1" syöttämällä laskutoimituksen näyttöön ja painamalla yhtäsuuruuspainiketta.

![laskutoimitus](https://raw.githubusercontent.com/robertrantanen/ot-harjoitustyo/master/Documentation/kuvat/sekvenssikaavio%201.jpg)

Kun sovellus käynnistetään, käyttöliittymä luo uuden Calculus-olion, joka taas luo uuden HistoryDao-olion. Kun käyttäjä painaa yhtäsuuruuspainiketta, Käyttöliittymä lähettää näytön sisällön merkkijonona Calculus-luokan calculate-metodille. Jos laskutoimitus on validi, metodi laskee sen ja kutsuu HistoryDao-luokan metodia AddItem merkkijonomuotoisella parametrilla ("laskutoimitus" + " = " + "vastaus"). Metodi lisää kyseisen merkkijonon tietokantaan. Tämän jälkeen calculate-metodi lähettää laskun vastauksen merkkijonomuotoisena käyttöliittymälle. Lopuksi käyttöliittymä kutsuu JavaFX:n metodia setText ja asettaa laskun vastauksen näytön tekstiksi.
