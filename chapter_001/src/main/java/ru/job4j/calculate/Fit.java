package ru.job4j.calculate;

/**
*The program for calculating the ideal weight.
*
*
*/
public class Fit {
    /**
    * Ideal weight for man.
    * @param height Man's height.
    * @return ideal weight.
    */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }
    /**
    * Ideal weight for woman.
    * @param height Man's height.
    * @return ideal weight.
    */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }  
}