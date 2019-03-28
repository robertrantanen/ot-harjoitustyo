package calculator.domain;

public class Calculus {

    public String calculate(String s) {
        String parts[] = s.split(" ");
        if (parts.length != 3) {
            return "error";
        }
        if (parts[1].equals("+")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            return String.valueOf(first + second);
        }

        if (parts[1].equals("-")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            return String.valueOf(first - second);
        }

        if (parts[1].equals("*")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            return String.valueOf(first * second);
        }

        if (parts[1].equals("/")) {
            int first = Integer.valueOf(parts[0]);
            int second = Integer.valueOf(parts[2]);

            if (second == 0) {
                return "error";
            } else {
                double result = 1.0 * first / second;
                return String.valueOf(result);
            }

        }

        return "error";
    }

}
