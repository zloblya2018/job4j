package ru.job4j.loop;
/**
 * Sum of even numbers.
 * @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
 * @version $Id$
 * @since 26.09.2018
 */
public class Counter {
    /**
     * Sum of even numbers.
     * @param start number, finish number.
     * @return Sum of even numbers.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result = result + i;
            }
        }
        return result;
    }
}
