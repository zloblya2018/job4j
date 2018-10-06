package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        int[] bound = new int[] {3, 1, 0, 4, 2};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(bound);
        int[] exeption = new int[] {0, 1, 2, 3, 4};
        assertThat(result, is(exeption));
    }
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] bound = new int[] {3, 1, 0, 4, 2, 6, 9, 8, 5, 7};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(bound);
        int[] exeption = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(exeption));
    }
}