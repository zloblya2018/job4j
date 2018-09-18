package ru.job4j.calculate;
/**
* Calculate.
*
* @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
* @version $Id$
* @since 17.09.2018
*/
public class Calculator {
    /**
     * Main.
     * @param args - args.
     */
     
    private double result;
    
    public void add(double first, double second) {
        this.result = first + second;
    }
    
    public double getResult() {
        return this.result;
    }
    
    public void subtraction(double first, double second) {
        this.result = second - first;
    }
    
    public void multiplication(double first, double second) {
        this.result = second * first;
    }
    
    public void division(double first, double second) {
        this.result = second / first;
    }
}