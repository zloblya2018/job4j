package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int number = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = number;
        }
        return array;
    }
}
