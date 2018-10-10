package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {

    @Test
    public void whenArrayHasDuplicatesThenDropIt() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Victor", "Boris", "Victor", "Den", "Jora"};
        String[] excpected = {"Victor", "Boris", "Den", "Jora"};
        String[] result = arrayDuplicate.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(excpected));
    }

    @Test
    public void whenArrayAllDuplicateThenDropIt() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Victor", "Victor", "Victor", "Victor", "Victor"};
        String[] excpected = {"Victor"};
        String[] result = arrayDuplicate.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(excpected));
    }
}