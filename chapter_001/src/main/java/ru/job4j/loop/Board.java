package ru.job4j.loop;
/**
        * Chess board.
        * @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
        * @version $Id$
        * @since 01.10.2018
        */
public class Board {
    /**
     * Chess board.
     * @param width board, heigth board.
     * @return chessboard line.
     */
    public String paint(int width, int height) {
        StringBuilder stringBuilder = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    stringBuilder.append("X");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(ln);
        }
        return stringBuilder.toString();
    }
}
