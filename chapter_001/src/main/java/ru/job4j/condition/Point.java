package ru.job4j.condition;

/**
* Calculate.
*
* @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
* @version $Id$
* @since 18.09.2018
*/

public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public double distanceTo(Point that) {
        return Math.sqrt(
                    Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}