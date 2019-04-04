package net.greet;

public class Command {
    public void string(String[] command){
        String cmd = command[0];
        Greeter greeter = new Greeter();
        if(cmd.equals("greet")){
            String name, language;
            if(command.length == 2) {
                name = command[1];
                language = "English";
                greeter.greetPerson(name, language);
            } else if(command.length == 3) {
                name = command[1];
                language = command[2];

                greeter.greetPerson(name, language);
            } else {
                System.out.println("ERROR!!!!!!!!\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n");
            }
        } else if (("help").equalsIgnoreCase(cmd)) {
            System.out.println("Welcome to the Help page");
        } else if (("clear").equalsIgnoreCase(cmd)) {
            System.out.println("cleared!!!!!");
        } else if (("greeted").equalsIgnoreCase(cmd)) {
            System.out.println("__ People greeted");
        } else {
            System.out.println("Error!!!!!!!!\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\n");
        }

    }
}



