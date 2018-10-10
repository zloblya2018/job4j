package ru.job4j.array;
/**
 * Removing duplicates in an array.
 * @author Belyakov Maksim (zloblya2018@mail.ru)
 * @version $Id$
 * @since 10.10.2018
 */
import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Removing duplicates in an array.
     * @param array of String.
     * @return trimmed array.
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
