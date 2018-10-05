package ru.job4j.array;
/**
 * Array of numbers squared.
 * @author Belyakov Maksim (zloblya2018@mail.ru)
 * @version $Id$
 * @since 05.10.2018
 */
public class Square {
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i < result.length + 1; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}
