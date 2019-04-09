package net.greet;

public class Controller {
    Greeter greeter = new Greeter();
    Help help = new Help();
    Greeted greeted = new Greeted();
    Command command;

    public void process(String userInput) {
        this.command = new Command(userInput);


        if (("greet").equalsIgnoreCase(command.getCmd())) {
            if (!command.getName().equalsIgnoreCase("No name")){
                greeter.greetPerson(command.getName(), command.getLanguage());
                greeted.setCounter(command.getName());
            } else {
                System.out.println("ERROR!!!!!!!!\nYou've entered an INVALID command. " +
                    "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n");
            }
        } else if (("help").equalsIgnoreCase(command.getCmd())) {
            help.helpMenu();
        } else if (("clear").equalsIgnoreCase(command.getCmd())) {
                greeted.clearCount(command.getName());
                System.out.println(command.getName() + " cleared!!!");
                System.out.println("====================================================================================");

        } else if (("greeted").equalsIgnoreCase(command.getCmd())) {

            System.out.println( command.getName() + " has been greeted " + greeted.getCounter(command.getName()) + " times.");
            System.out.println("====================================================================================");

        } else if (("exit").equalsIgnoreCase(command.getCmd())) {
            return;
        } else {
            System.out.println("Error!!!!!!!!\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.");
            System.out.println("====================================================================================");

        }
    }
}
