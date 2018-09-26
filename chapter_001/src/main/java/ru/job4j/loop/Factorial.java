package ru.job4j.loop;
/**
 * Sum of even numbers.
 * @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
 * @version $Id$
 * @since 26.09.2018
 */
public class Factorial {
    /**
     * Method of calculating the factorial of a number.
     * @param number-negative integer
     * @return factorial.
     */
    public int factorialOfNumber(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
