package net.greet;

public class Controller {
    private final PersonGreeted greeted;
    private final Greeter greeter;
    Help help = new Help();

    Controller(PersonGreeted greeted, Greeter greeter) {
        this.greeted = greeted;
        this.greeter = greeter;
    }

    public String process(String userInput) {
        Command command = new Command(userInput);

        if (("greet").equalsIgnoreCase(command.executeCmd())) {
//            Takes the greet command along side the name and language in order to pass it in to the greeter class..
            if (command.getName() == null) {
                return "\033[31mERROR:\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n\033[0m" +
                        "\n====================================================================================";
            } else {
                greeter.greetPerson(command.getName(), command.getLanguage());
                greeted.setCounter(command.getName());
            }
        } else if (("help").equalsIgnoreCase(command.executeCmd())) {
//            Takes the help command and switches the user in the App to the help menu..
            if (command.getName() != null){
                return "\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help command for Assistance.\033[0m" +
                        "\n====================================================================================";
            } else {
                help.helpMenu();
            }
        } else if (("counter").equalsIgnoreCase(command.executeCmd())){
//            It's function goes to the map or the DB, to check on how many people have been greeted in total..
            if (command.getName() != null) {
                return "\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help command for Assistance.\033[0m" +
                        "\n====================================================================================";
            } else {
                return (greeted.getSize() + " User's have been greeted." +
                        "\n====================================================================================");
            }
        } else if (("clear").equalsIgnoreCase(command.executeCmd())) {
//            It's function goes to the map or the DB too erase all the users who have been greeted..
            if (greeted.totalPeopleGreeted() >= 1) {
                try {
                    if (!command.getName().equals(null)) {
                        if (greeted.checkName(command.getName())) {
                            greeted.clearCount(command.getName());
//                            System.out.println(greeted.clearCount(command.getName()));
                            return (command.getName() + " has been cleared!" +
                                    "\n====================================================================================");
                        } else {
                            return ("Username " + command.getName() + " doesn't exist." +
                                    "\n====================================================================================");
                        }
                    }
                } catch (NullPointerException e) {
                    greeted.clearUsers();
                    return ("All User's have been cleared!" +
                            "\n====================================================================================");
                }
            } else {
                return ("\033[31mAlready empty.\033[0m" +
                        "\n====================================================================================");
            }

        } else if (("greeted").equalsIgnoreCase(command.executeCmd())) {
//            It's function goes to the DB or the map to check how many time was each user greeted..
            if (command.getName() != null) {
                if (greeted.checkName(command.getName())) {
                    if(greeted.getCounter(command.getName()) != 0) {
                        return (command.getName() + " has been greeted " + greeted.getCounter(command.getName()) + " time(s).");
                    } else{
                        return ("\033[31mUsername " + command.getName() + " hasn't been greeted.\033[0m" +
                                "\n====================================================================================");
                    }
                } else {
                    return ("\033[31mUsername " + command.getName() + " hasn't been greeted.\033[0m" +
                            "\n====================================================================================");
                }
            } else {
                if (greeted.totalPeopleGreeted() == 1){
                    greeted.viewData();
                } else if (greeted.totalPeopleGreeted() == 0){
                    System.out.println("\033[31mNo one has been greeted.\033[0m");
                } else {
                    greeted.viewData();
                }
            }
        } else if (("exit").equalsIgnoreCase(command.executeCmd())) {
          return command.executeCmd();
        } else {
//            This is the default message that one gets when they enter an invalid command..
            return ("\033[31mError:\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\033[0m" +
                    "\n====================================================================================");
        }
        return "====================================================================================";
    }
}