package ru.job4j.loop;
/**
 * Pyramid.
 * @author Belyakov Maksim (zloblya2018@mail.ru)
 * @version $Id$
 * @since 02.10.2018
 */
public class Paint {
    /**
     * two sides of the pyramid.
     * @param height pyramid.
     * @return two side of the pyramid.
     */
    public String twoSideOfThePyramid(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        int weight = 2 * height - 1;
        for (int i = 0; i != height; i++) {
            for (int j = 0; j != weight; j++) {
                if (i >= height - j - 1 && i + height - 1 >= j) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
