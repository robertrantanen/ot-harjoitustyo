
package calculator.domain;


public class Calculus {    
    
    public String calculate(String s) {
        String parts[] = s.split(" ");
        int first = Integer.valueOf(parts[0]);
        int second = Integer.valueOf(parts[2]);
        
        return String.valueOf(first + second);                
    }
    
    
}
