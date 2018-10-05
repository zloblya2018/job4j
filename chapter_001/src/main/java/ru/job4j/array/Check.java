package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] date) {
        boolean result = true;
        for (int i = 1; i < date.length; i++) {
           if (date[0] != date[i]) {
               result = false;
           }
        }
        return result;
    }
}
