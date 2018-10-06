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
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int number = array[j];
                    array[j] = array[i];
                    array[i] = number;
                }
            }
        }
        return array;
    }
}
