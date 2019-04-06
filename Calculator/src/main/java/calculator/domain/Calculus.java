package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculus {

    ArrayList<String> historyList;
    String last;

    public Calculus() {
        historyList = new ArrayList<>();
        last = "";
    }

    public String calculate(String s) {

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
        }
        String answerString = String.valueOf(answer);
        String lastChar = String.valueOf(answerString.charAt(answerString.length() - 1));
        String secondLastChar = String.valueOf(answerString.charAt(answerString.length() - 2));
        
        if (lastChar.equals("0") && secondLastChar.equals(".")) {
            answerString = answerString.substring(0, answerString.length() - 2);
        }
                
        
        historyList.add(s + " = " + answerString);
        last = answerString;
        return answerString;

    }

    public String getLastItemsFromHistoryList() {
        List<String> list;
        if (this.historyList.size() < 10) {
            list = this.historyList;
        } else {
            list = this.historyList.subList(this.historyList.size() - 10, this.historyList.size());
        }

        String s = "";

        for (String string : list) {
            s += string + "\n";
        }

        return s;
    }

    public String getLast() {
        return last;
    }

}
