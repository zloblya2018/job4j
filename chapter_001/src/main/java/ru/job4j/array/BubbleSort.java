package ru.job4j.array;
/**
 * Permutation array sorting.
 * @author Belyakov Maksim (zloblya2018@mail.ru)
 * @version $Id$
 * @since 06.10.2018
 */
public class BubbleSort {
    /**
     * Permutation array sorting.
     * @param array of integers.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int number = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = number;
                }
            }
        }
        return array;
    }
}
