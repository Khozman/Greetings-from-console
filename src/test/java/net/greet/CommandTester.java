package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTester {
    @Test
    public void shouldReturnCommand(){
        Command array = new Command("greet bheki chinese");

        assertEquals(array.getCmd(), "greet");
    }

    @Test
    public void shouldReturnName(){
        Command array = new Command("greet bheki chinese");

        assertEquals(array.getName(), "Bheki");
    }

    @Test
    public void shouldReturnLanguage(){
        Command array = new Command("greet bheki chinese");

        assertEquals(array.getLanguage(), "chinese");
    }

}
