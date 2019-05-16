package net.greet;

public class Controller {
    private final PersonGreeted greeted;
    private final Greeter greeter;

    public Controller(PersonGreeted greeted, Greeter greeter) {
        this.greeted = greeted;
        this.greeter = greeter;
    }

    public String process(String userInput) {
        CommandExtractor commandExtractor = new CommandExtractor(userInput);

        if (("greet").equalsIgnoreCase(commandExtractor.executeCmd())) {
//            Takes the greet commandExtractor along side the name and language in order to pass it in to the greeter class..
            if (commandExtractor.getName() == null) {
                return "\033[31mERROR:\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n\033[0m" +
                        "\n====================================================================================";
            } else {
                greeter.greetPerson(commandExtractor.getName(), commandExtractor.getLanguage());
                greeted.setCounter(commandExtractor.getName());
            }
        } else if (("help").equalsIgnoreCase(commandExtractor.executeCmd())) {
//            Takes the help commandExtractor and switches the user in the App to the help menu..
            if (commandExtractor.getName() != null){
                return "\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help commandExtractor for Assistance.\033[0m" +
                        "\n====================================================================================";
            } else {
                return Help.helpMenu();
            }
        } else if (("counter").equalsIgnoreCase(commandExtractor.executeCmd())){
//            It's function goes to the map or the DB, to check on how many people have been greeted in total..
            if (commandExtractor.getName() != null) {
                return "\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help commandExtractor for Assistance.\033[0m" +
                        "\n====================================================================================";
            } else {
                return (greeted.getTotalNumberOfPeople() + " User's have been greeted." +
                        "\n====================================================================================");
            }
        } else if (("clear").equalsIgnoreCase(commandExtractor.executeCmd())) {
//            It's function goes to the map or the DB too erase all the users who have been greeted..
            if (greeted.totalPeopleGreeted() >= 1) {
                try {
                    if (!commandExtractor.getName().equals(null)) {
                        if (greeted.checkName(commandExtractor.getName())) {
                            greeted.clearCount(commandExtractor.getName());
//                            System.out.println(greeted.clearCount(commandExtractor.getName()));
                            return (commandExtractor.getName() + " has been cleared!" +
                                    "\n====================================================================================");
                        } else {
                            return ("Username " + commandExtractor.getName() + " doesn't exist." +
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

        } else if (("greeted").equalsIgnoreCase(commandExtractor.executeCmd())) {
//            It's function goes to the DB or the map to check how many time was each user greeted..
            if (commandExtractor.getName() != null) {
                if (greeted.checkName(commandExtractor.getName())) {
                    if(greeted.getCounter(commandExtractor.getName()) != 0) {
                        return (commandExtractor.getName() + " has been greeted " + greeted.getCounter(commandExtractor.getName()) + " time(s).");
                    } else{
                        return ("\033[31mUsername " + commandExtractor.getName() + " hasn't been greeted.\033[0m" +
                                "\n====================================================================================");
                    }
                } else {
                    return ("\033[31mUsername " + commandExtractor.getName() + " hasn't been greeted.\033[0m" +
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
        } else if (("exit").equalsIgnoreCase(commandExtractor.executeCmd())) {
            if (commandExtractor.getName() != null){
                return "\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help commandExtractor for Assistance.\033[0m" +
                        "\n====================================================================================";
            } else {
                return commandExtractor.executeCmd();
            }
        } else {
//            This is the default message that one gets when they enter an invalid commandExtractor..
            return ("\033[31mError:\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\033[0m" +
                    "\n====================================================================================");
        }
        return "====================================================================================";
    }
}