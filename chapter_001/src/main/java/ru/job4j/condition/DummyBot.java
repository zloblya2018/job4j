package ru.job4j.condition;

/**
* Dummy Bot.
*
* @author Belyakov Maksim (mailto: zloblya2018@mail.ru)
* @version $Id$
* @since 19.09.2018
*/

public class DummyBot {
    /**
     * Method answers the questions.
     * @return answers.
     */
     
     public String answer(String question) {
        String string = "Это ставит меня в тупик. Спросите другой вопрос.";
        if (question.equals("Привет, Бот.")) {
            string = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            string = "До скорой встречи.";
        }
        return string;
     }
}