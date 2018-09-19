package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Belyakov Maksim (mailto:zloblya2018@mail.ru)
* @version $Id$
* @since 19.09.2018
*/

public class DummyBotTest {

    @Test
    public void greetingIsAnswere() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот."), 
                is("Привет, умник.")
        );
    }
    
    @Test
    public void partingIsAnswere() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока."), 
                is("До скорой встречи.")
        );
    }
    
    @Test
    public void unknownPhraseIsAnswere() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Hello Botyara!"), 
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}

