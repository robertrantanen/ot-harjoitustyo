### Sovelluksen rakenne
Pakkauskaavio linkkinä, sillä upotettu kuva kääntyi aina sivuttain. Lisään mahdollisesti vielä kirjautumistoiminnon, mutta sitä ei olla merkitty kaavioon.

[pakkauskaavio](https://raw.githubusercontent.com/robertrantanen/ot-harjoitustyo/master/Documentation/kuvat/pakkauskaavio.jpg)

### Laskutoimituksen tekeminen
Seuraava sekvenssikaavio kuvaa tapahtumaa, kun sovellus käynnistetään ja käyttäjä tekee laskutoimituksen "1 + 1" syöttämällä laskutoimituksen näyttöön ja painamalla yhtäsuuruuspainiketta.

![laskutoimitus](https://raw.githubusercontent.com/robertrantanen/ot-harjoitustyo/master/Documentation/kuvat/sekvenssikaavio%201.jpg)

Kun sovellus käynnistetään, käyttöliittymä luo uuden Calculus-olion, joka taas luo uuden HistoryDao-olion. Kun käyttäjä painaa yhtäsuuruuspainiketta, Käyttöliittymä lähettää näytön sisällön merkkijonona Calculus-luokan calculate-metodille. Jos laskutoimitus on validi, metodi laskee sen ja kutsuu HistoryDao-luokan metodia AddItem merkkijonomuotoisella parametrilla ("laskutoimitus" + " = " + "vastaus"). Metodi lisää kyseisen merkkijonon tietokantaan. Tämän jälkeen calculate-metodi lähettää laskun vastauksen merkkijonomuotoisena käyttöliittymälle. Lopuksi käyttöliittymä kutsuu JavaFX:n metodia setText ja asettaa laskun vastauksen näytön tekstiksi.
