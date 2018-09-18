package ru.job4j.converter;

/**
* Currency converter.
*/

public class Converter {
    /**
    * Convert rubles into euro.
    * @param value rubles.
    * @return euro.
    */
    public int rubleToEuro(int value) {
        return value / 70;
    }
    /**
    * Convert rubles into dollars.
    * @param value rubles.
    * @return dollars.
    */
    public int rubleToDollar(int value) {
        return value / 60;
    }
    /**
    * Convert euro into rubles.
    * @param value euro.
    * @return rubles.
    */
    public int euroToRubles(int value) {
        return value * 70;
    }
    /**
    * Convert dollar into rubles.
    * @param value euro.
    * @return rubles.
    */
    public int dollarToRubles(int value) {
        return value * 60;
    }   
}