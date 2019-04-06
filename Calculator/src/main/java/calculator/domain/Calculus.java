package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculus {

    ArrayList<String> historyList;

    public Calculus() {
        historyList = new ArrayList<>();
    }

    public String calculate(String s) {

        String parts[] = s.split(" ");
        if (parts.length < 3) {
            return s;
        }
        if (parts[1].equals("+")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            int answer = first + second;
            historyList.add(s + " = " + answer);
            return String.valueOf(answer);

        }

        if (parts[1].equals("-")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            int answer = first - second;
            historyList.add(s + " = " + answer);
            return String.valueOf(answer);
        }

        if (parts[1].equals("*")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            int answer = first * second;
            historyList.add(s + " = " + answer);
            return String.valueOf(answer);
        }

        if (parts[1].equals("/")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            if (second == 0) {
                return "error";
            } else {
                double answer = 1.0 * first / second;
                historyList.add(s + " = " + answer);
                return String.valueOf(answer);
            }

        }

        return "error";
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

}
