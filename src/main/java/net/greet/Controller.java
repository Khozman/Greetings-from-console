package net.greet;

public class Controller {
    Greeter greeter = new Greeter();
    Help help = new Help();
    Greeted greeted = new Greeted();
    Command command;

    public void process(String userInput) {
        this.command = new Command(userInput);


        if (("greet").equalsIgnoreCase(command.getCmd())) {
            if (command.getName() == null) {
                System.out.println("\033[31mERROR:\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n\033[0m");
            } else {
                greeter.greetPerson(command.getName(), command.getLanguage());
                greeted.setCounter(command.getName());
            }
        } else if (("help").equalsIgnoreCase(command.getCmd())) {
            help.helpMenu();
        } else if (("counter").equalsIgnoreCase(command.getCmd())){
            System.out.println(greeted.personGreetedMap.size() + " User's have been greeted.");
        } else if (("clear").equalsIgnoreCase(command.getCmd())) {
            if (greeted.totalPeopleGreeted() >= 1) {
                try {
                    if (!command.getName().equals(null)) {
                        if (greeted.personGreetedMap.containsKey(command.getName())) {
                            greeted.clearCount(command.getName());
                            System.out.println(command.getName() + " cleared!");
                        } else {
                            System.out.println("Username " + command.getName() + " doesn't exist.");
                        }
                    }
                } catch (NullPointerException e) {
                    greeted.personGreetedMap.clear();
                    System.out.println("All User's have been cleared!");
                }
            } else {
                System.out.println("Already empty.");
            }
            System.out.println("====================================================================================");

        } else if (("greeted").equalsIgnoreCase(command.getCmd())) {
            if (command.getName() != null) {
                if (greeted.personGreetedMap.containsKey(command.getName())) {
                    System.out.println(command.getName() + " has been greeted " + greeted.getCounter(command.getName()) + " times.");
                } else {
                    System.out.println("Username " + command.getName() + " hasn't been greeted.");
                }
            } else {
                if (greeted.totalPeopleGreeted() == 1){
                    System.out.println(greeted.personGreetedMap);
                } else if (greeted.totalPeopleGreeted() == 0){
                    System.out.println("No one has been greeted.");
                } else {
                    System.out.println(greeted.personGreetedMap);
                }
            }
            System.out.println("====================================================================================");

        } else if (("exit").equalsIgnoreCase(command.getCmd())) {
            return;
        } else {
            System.out.println("\033[31mError:\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\033[0m");
            System.out.println("====================================================================================");

        }
    }
}
//Red