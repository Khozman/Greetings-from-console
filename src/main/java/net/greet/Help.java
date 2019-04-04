package net.greet;

public class Help {
    public void helpMenu(){
        System.out.println("Welcome to the Help page:\n\n" +
                "Greet - command: This command greets the user in different languages." +
                "\n             Syntax: Greet <name> <language>, " +
                "\n             Where language = french, chinese or english.\n" +
                "Greeted - command: This command displays a list of all users that has been greeted " +
                "and how many time each user has been greeted.\n" +
                "Clear - command: This command, followed by a username deletes the greet counter for the specified user and" +
                " decrement the greet counter by 1.\n" +
                "Counter - command: This command returns a count of how many unique users has been greeted.\n" +
                "Exit - command: This command  exits the application.\n" +
                "Help - command: This command takes you to this current page.\n");
    }
}
