package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @BeforeEach
    void shouldClearDb(){
        JdbcGreeted db = new JdbcGreeted();
        db.clearUsers();
    }

    @Test
    void shouldReturnTheNumberOfUsersGreeted() {

        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        assertEquals(controller.process("counter" ), "0 User's have been greeted.\n");
    }

    @Test
    void shouldReturnTheHelpMenu() {

        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        assertEquals(controller.process("help"), ("                          ☶ Welcome to the Help page:\n\n" +
                "☉ Greet    - command: This command greets the user in different languages." +
                "\n             Syntax: Greet <name> <language>, " +
                "\n             Where language = french, chinese or english.\n" +
                "☉ Greeted  - command: This command displays a list of all users that has been\n" +
                "           greeted " +
                "and how many time each user has been greeted.\n" +
                "☉ Clear    - command: This command, followed by a username deletes the greet counter\n " +
                "           for the specified user and" +
                " decrement the greet counter by 1.\n" +
                "☉ Counter  - command: This command returns a count of how many unique users has been\n" +
                "           greeted.\n" +
                "☉ Exit     - command: This command  exits the application.\n" +
                "☉ Help     - command: This command takes you to this current page."));
    }

    @Test
    void shouldReturnNoOneHasBeenGreeted() {

        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        assertEquals(controller.process("greeted"),"\u001B[31mNo one has been greeted.\u001B[0m");
    }

    @Test
    void shouldReturnTheSyntaxErrorInGreet() {

        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        assertEquals(controller.process("greet"), "\u001B[31mERROR:\n" +
                "You've entered an INVALID command. \n" +
                "Please try: Greet <name> <language>, Where language = french, chinese or english.\n" +
                "\u001B[0m");
    }

    @Test
    void shouldReturnGreetCounter(){
        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        controller.process("greet thabang");
        controller.process("greet vusi french");
        controller.process("greet Bheki chinese");

        assertEquals(controller.process("counter"), "3 User's have been greeted.\n");
    }

    @Test
    void  shouldReturnTheNumberOfTimesAUserHasBeenGreeted(){
        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        controller.process("greet bheki");
        controller.process("greet bheki");
        controller.process("greet bheki");
        controller.process("greet bheki");

        assertEquals(controller.process("greeted Bheki"),"Bheki has been greeted 4 time(s).");
    }

    @Test
    void shouldClearUser(){
        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new  Controller(greeted, greeter);

        controller.process("greet bheki");
        controller.process("greet bheki");
        controller.process("greet bheki");
        controller.process("greet bheki");

        assertEquals(controller.process("greeted bheki"), "Bheki has been greeted 4 time(s).");
        assertEquals(controller.process("clear bheki"), "Bheki has been cleared!");
        assertEquals(controller.process("greeted bheki"), "\u001B[31mUsername Bheki hasn't been greeted.\u001B[0m");
    }

    @Test
    void shouldClearAllUsers(){
        PersonGreeted greeted = new Greeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        controller.process("greet thabang");
        controller.process("greet thabang");
        controller.process("greet vusi");
        controller.process("greet vusi");
        controller.process("greet bheki");
        controller.process("greet bheki");

        assertEquals(controller.process("counter"), "3 User's have been greeted.\n");
        assertEquals(controller.process("clear"), "All User's have been cleared!");
        assertEquals(controller.process("greeted"), "\u001B[31mNo one has been greeted.\u001B[0m");
    }
}