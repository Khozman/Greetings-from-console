package net.greet;

public class Command {
    public void string(String[] command){

        Greeter greeter = new Greeter();
        Help help = new Help();
        Clear clear = new Clear();
        Greeted greeted = new Greeted();

        String cmd = command[0];
        String name = command.length > 1 ? command[1] : "";
        String language = command.length > 2 ? command[2] : "English";

        if(("greet").equalsIgnoreCase(cmd)){
            if(command.length > 0) {
                greeter.greetPerson(name, language);
            } else {
                System.out.println("ERROR!!!!!!!!\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n");
            }
        } else if (("help").equalsIgnoreCase(cmd)) {
            help.helpMenu();
        } else if (("clear").equalsIgnoreCase(cmd)) {
            clear.clearCount(name);
        } else if (("greeted").equalsIgnoreCase(cmd)) {
            greeted.counter(name);
        } else {
            System.out.println("Error!!!!!!!!\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\n");
        }

    }
}



