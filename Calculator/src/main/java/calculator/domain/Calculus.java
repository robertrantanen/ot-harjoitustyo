package calculator.domain;

import calculator.dao.HistoryDao;
import java.util.Collections;
import java.util.List;

/**
 * Luokka vastaa laskutoimitusten laskemisesta ja historianäkymästä.
 */
public class Calculus {

    String last;
    HistoryDao historydao;

    /**
     * Konstruktori luo "last"-oliomuuttujan tyhjällä merkkijonolla sekä
     * HistoryDao-olion.
     */
    public Calculus() throws Exception {
        last = "";
        historydao = new HistoryDao();
    }

    /**
     * Metodi muuttaa merkkijonomuotoisen laskutoimituksen laskettavaan muotoon,
     * laskee sen ja palauttaa vastauksen sekä tallentaa sen
     * "last"-oliomuuttujaan. Vastaus pyöristetään viiden desimaalin tarkkuuteen
     * ja kokonaisluvuista karsitaan desimaalipiste pois. Metodi vastaa myös
     * laskutoimituksen lisäämisestä historiaan kutsumalla HistoryDao-luokan
     * add-metodia.
     *
     * @param s laskimen näytössä oleva merkkijono
     *
     * @see calculator.dao.HistoryDao#addItem(java.lang.String)
     *
     * @return laskun vastaus merkkijonona, tai merkkijono "error" jos lasku ei
     * ollut validi
     */
    public String calculate(String s) throws Exception {

        String parts[] = s.split(" ");
        if (parts.length < 3) {
            return s;
        }
        if (parts[0].equals(".") || parts[2].equals(".") || parts[0].equals("-") || parts[2].equals("-")) {
            return "error";
        }
        double first = Double.valueOf(parts[0]);
        double second = Double.valueOf(parts[2]);
        double answer = 0;
        if (parts[1].equals("+")) {
            answer = first + second;
        } else if (parts[1].equals("-")) {
            answer = first - second;
        } else if (parts[1].equals("*")) {
            answer = first * second;
        } else if (parts[1].equals("/")) {
            if (second == 0) {
                return "error";
            }
            answer = first / second;
        } else if (parts[1].equals("^")) {
            answer = Math.pow(first, second);
        } else if (parts[1].equals("root")) {
            if (second == 0) {
                return "error";
            }
            second = 1 / second;
            answer = Math.pow(first, second);
        }
        answer = (double) Math.round(answer * 100000d) / 100000d;
        String answerString = String.valueOf(answer);
        String lastChar = String.valueOf(answerString.charAt(answerString.length() - 1));
        String secondLastChar = String.valueOf(answerString.charAt(answerString.length() - 2));

        if (lastChar.equals("0") && secondLastChar.equals(".")) {
            answerString = answerString.substring(0, answerString.length() - 2);
        }

        historydao.addItem(s + " = " + answerString);
        last = answerString;
        return answerString;

    }

    public String calculateTrigonometric(String s) throws Exception {
        if (s.length() == 5) {
            return s;
        }
        String firstChar = String.valueOf(s.charAt(0));
        String number = s.substring(4, s.length() - 1);
        double answer = Double.valueOf(number);
        if (firstChar.equals("s")) {
            answer = Math.sin(answer);
        }
        if (firstChar.equals("c")) {
            answer = Math.cos(answer);
        }
        if (firstChar.equals("t")) {
            answer = Math.tan(answer);
        }

        answer = (double) Math.round(answer * 100000d) / 100000d;
        String answerString = String.valueOf(answer);
        String lastChar = String.valueOf(answerString.charAt(answerString.length() - 1));
        String secondLastChar = String.valueOf(answerString.charAt(answerString.length() - 2));

        if (lastChar.equals("0") && secondLastChar.equals(".")) {
            answerString = answerString.substring(0, answerString.length() - 2);
        }

        historydao.addItem(s + " = " + answerString);
        last = answerString;
        return answerString;

    }

    /**
     * Metodi luo listan HistodyDao:n listAll-metodilla ja muuttaa sen
     * merkkijonomuotoon. Lista laitetaan myös käänteiseen järjestykseen, jotta
     * uusin laskutoimitus on ruudun alareunassa.
     *
     * @see calculator.dao.HistoryDao#listAll()
     *
     * @return historialista merkkijonomuodossa, jokainen laskutoimitus omalla
     * rivillään
     */
    public String getLastItemsFromHistory() throws Exception {
        List<String> list = historydao.listAll();
        Collections.reverse(list);

        String s = "";

        for (String string : list) {
            s += string + "\n";
        }

        return s;
    }

    /**
     * Metodi kutsuu HistoryDao:n metodia deleteAll.
     *
     * @see calculator.dao.HistoryDao#deleteAll()
     *
     */
    public void deleteHistory() throws Exception {
        historydao.deleteAll();
    }

    /**
     * Metodi palauttaa "last"-oliomuuttujan
     *
     * @return viimeisimmän laskutoimituksen vastaus merkkijonomuodossa
     */
    public String getLast() {
        return last;
    }

}
