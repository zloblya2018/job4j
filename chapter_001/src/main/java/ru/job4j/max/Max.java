package ru.job4j.max;

/**
* Maximum of two number and three.
*/

public class Max {
     /**
    * Maximum of two number.
    * @param first number, second number.
    * @return maximum number.
    */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Maximum of three number.
     * @param first number, second number, third number.
     * @return maximum number.
     */
    public int max(int first, int second, int third) {
        return this.max(first, second) > third ? this.max(first, second) : third;
    }
}