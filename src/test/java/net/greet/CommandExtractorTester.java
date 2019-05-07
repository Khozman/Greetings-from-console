package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExtractorTester {
    @Test
    public void shouldReturnCommand(){
        CommandExtractor array = new CommandExtractor("greet bheki chinese");

        assertEquals(array.executeCmd(), "greet");
    }

    @Test
    public void shouldReturnName(){
        CommandExtractor array = new CommandExtractor("greet bheki chinese");

        assertEquals(array.getName(), "Bheki");
    }

    @Test
    public void shouldReturnLanguage(){
        CommandExtractor array = new CommandExtractor("greet bheki chinese");

        assertEquals(array.getLanguage(), "chinese");
    }

}
