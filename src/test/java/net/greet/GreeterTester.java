package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTester {
    @Test
    void shouldGreetUserInEnglish(){
        Greeter greeter = new Greeter();
        String greet = greeter.greetPerson("Bheki", "English");

        assertEquals("Hello Bheki!", greet);
    }

    @Test
    void shouldGreetUserInFrench(){
        Greeter greeter = new Greeter();
        String greet = greeter.greetPerson("Bheki", "French");

        assertEquals("Bonjour Bheki!", greet);
    }

    @Test
    void shouldGreetUserInChinese(){
        Greeter greeter = new Greeter();
        String greet = greeter.greetPerson("Bheki", "Chinese");

        assertEquals("你好 Bheki!", greet);
    }

    @Test
    void shouldReturnNothing(){
        Greeter greeter = new Greeter();
        String greet = greeter.greetPerson("","");

        assertEquals(null, greet);
    }
}
