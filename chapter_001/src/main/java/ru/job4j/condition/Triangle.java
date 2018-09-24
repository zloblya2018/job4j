package ru.job4j.condition;

/**
* Area of a Triangle.
* @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
* @version $Id$
* @since 20.09.2018
*/

public class Triangle {
	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
     * Method calculates a semiperimeter.
     * @param ab distance between points a and b.
	 * @param ac distance between points a and c.
	 * @param bc distance between points b and c.
     * @return semiperimeter.
     */
	 
	public double period(double ab, double ac, double bc) {
		return (ab + ac + bc) / 2;
	}
	
	/**
     * Method calculates the area of the triangle.
     * @return rsl area of the triangle.
     */
	
	public double area() {
		double rsl = -1;
		double ab = this.a.distanceTo(this.b);
		double ac = this.a.distanceTo(this.c);
		double bc = this.b.distanceTo(this.c);
		double p = this.period(ab, ac, bc);
		if (this.exist(ab, ac, bc)) {
			rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
		}
		return rsl;
	}
	
	/**
     * Method of existence of a triangle.
     * @param ab distance between points a and b.
	 * @param ac distance between points a and c.
	 * @param bc distance between points b and c.
     * @return false and true.
     */
	 
	private boolean exist(double ab, double ac, double bc) {
	    return (ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab;
	}
}