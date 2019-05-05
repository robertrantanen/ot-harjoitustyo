package calculator.domain;

import calculator.dao.HistoryDao;
import java.util.Collections;
import java.util.List;

/**
 * Luokka vastaa laskutoimitusten laskemisesta ja historianäkymästä.
 */
public class Calculus {

    private String last;
    private HistoryDao historydao;

    public Calculus(String db) throws Exception {
        last = "";
        historydao = new HistoryDao(db);
        historydao.createTables();
    }

    /**
     * Metodi muuttaa merkkijonomuotoisen laskutoimituksen laskettavaan muotoon,
     * laskee sen ja palauttaa vastauksen. Metodi kutsuu myös kahta apumetodia,
     * calculateHelp ja answerHelp. calculateHelp auttaa lyhentämään koodia, kun
     * taas answerHelp siistii vastausta ja kutsuu HistoryDaon metodia addItem.
     *
     * @param s laskimen näytössä oleva merkkijono
     * @throws java.lang.Exception e
     *
     * @return laskun vastaus merkkijonona, tai merkkijono "error" jos lasku ei
     * ollut validi
     */
    public String calculate(String s) throws Exception {

        String parts[] = s.split(" ");
        if (parts.length < 3) {
            return s;
        }
        if (checkErrors(parts[0]) || checkErrors(parts[2]) || checkIfTooManyDotsOrMinuses(parts[0]) || checkIfTooManyDotsOrMinuses(parts[2])) {
            return "error";
        }
        double first = Double.valueOf(parts[0]);
        double second = Double.valueOf(parts[2]);
        String function = parts[1];

        double answer = calculateHelp(first, second, function);

        if (answer == Double.POSITIVE_INFINITY) {
            return "error";
        }
        return answerHelp(answer, s);
    }

    /**
     * Metodi laskee sini, kosini tai tangenttifunktion.
     *
     * @param s laskimen näytössä oleva merkkijono
     * @return laskun vastaus merkkijonona, tai palauttaa parametrin jos
     * laskussa ei yhtään numeroa, tai "error" jos lasku ei ollut validi.
     * @throws java.lang.Exception e
     */
    public String calculateTrigonometric(String s) throws Exception {
        if (s.length() == 5) {
            return s;
        }
        String firstChar = String.valueOf(s.charAt(0));
        String number = s.substring(4, s.length() - 1);
        if (checkErrors(number) || checkIfTooManyDotsOrMinuses(number)) {
            return "error";
        }
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

        return answerHelp(answer, s);
    }

    /**
     * Metodi luo listan HistodyDao:n listAll-metodilla ja muuttaa sen
     * merkkijonomuotoon. Lista laitetaan myös käänteiseen järjestykseen, jotta
     * uusin laskutoimitus on ruudun alareunassa.
     *
     * @throws java.lang.Exception e
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
     * @throws java.lang.Exception e
     * @see calculator.dao.HistoryDao#deleteAll()
     *
     */
    public void deleteHistory() throws Exception {
        historydao.deleteAll();
    }

    public String getLast() {
        return last;
    }

    private boolean checkIfTooManyDotsOrMinuses(String s) {
        boolean error = false;

        int dots = 0;
        int minuses = 0;
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if (character.equals(".")) {
                dots++;
            }
            if (character.equals("-")) {
                minuses++;
            }
        }
        if (dots > 1 || minuses > 1) {
            error = true;
        }
        return error;
    }

    private boolean checkErrors(String s) {
        boolean error = false;

        if (s.equals(".") || s.equals("-") || s.equals("-.") || s.equals(".-")) {
            error = true;
        }

        return error;
    }

    private double calculateHelp(double first, double second, String function) {
        double answer = 0;
        if (function.equals("+")) {
            answer = first + second;
        } else if (function.equals("-")) {
            answer = first - second;
        } else if (function.equals("*")) {
            answer = first * second;
        } else if (function.equals("/")) {
            if (second == 0) {
                return Double.POSITIVE_INFINITY;
            }
            answer = first / second;
        } else if (function.equals("^")) {
            answer = Math.pow(first, second);
        } else if (function.equals("root")) {
            if (second == 0) {
                return Double.POSITIVE_INFINITY;
            }
            second = 1 / second;
            answer = Math.pow(first, second);
        }
        return answer;
    }

    private String answerHelp(double answer, String s) throws Exception {
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

}
