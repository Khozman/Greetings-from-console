package net.greet;

public class Controller {
    Greeter greeter = new Greeter();
    Help help = new Help();
//    Greeted greeted = new Greeted();
    PersonGreeter greeted = new JdbcGreeted();
    Command command;

    public void process(String userInput) {
        this.command = new Command(userInput);


        if (("greet").equalsIgnoreCase(command.executeCmd())) {
//            Takes the greet command along side the name and language in order to pass it in to the greeter class..
            if (command.getName() == null) {
                System.out.println("\033[31mERROR:\nYou've entered an INVALID command. " +
                        "\nPlease try: Greet <name> <language>, Where language = french, chinese or english.\n\033[0m");
            } else {
                greeter.greetPerson(command.getName(), command.getLanguage());
                greeted.setCounter(command.getName());
            }
        } else if (("help").equalsIgnoreCase(command.executeCmd())) {
//            Takes the help command and switches the user in the App to the help menu..
            if (command.getName() != null){
                System.out.println("\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help command for Assistance.\033[0m");
            } else {
                help.helpMenu();
            }
        } else if (("counter").equalsIgnoreCase(command.executeCmd())){
//            It's function goes to the map or the DB, to check on how many people have been greeted in total..
            if (command.getName() != null) {
                System.out.println("\033[31mError:\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help command for Assistance.\033[0m");
            } else {
                System.out.println(greeted.getSize() + " User's have been greeted.");
            }
        } else if (("clear").equalsIgnoreCase(command.executeCmd())) {
//            It's function goes to the map or the DB too erase all the users who have been greeted..
            if (greeted.totalPeopleGreeted() >= 1) {
                try {
                    if (!command.getName().equals(null)) {
                        if (greeted.checkName(command.getName())) {
                            greeted.clearCount(command.getName());
//                            System.out.println(greeted.clearCount(command.getName()));
                            System.out.println(command.getName() + " has been cleared!");
                        } else {
                            System.out.println("Username " + command.getName() + " doesn't exist.");
                        }
                    }
                } catch (NullPointerException e) {
                    greeted.clearUsers();
                    System.out.println("All User's have been cleared!");
                }
            } else {
                System.out.println("Already empty.");
            }
            System.out.println("====================================================================================");

        } else if (("greeted").equalsIgnoreCase(command.executeCmd())) {
//            It's function goes to the DB or the map to check how many time was each user greeted..
            if (command.getName() != null) {
                if (greeted.checkName(command.getName())) {
                    if(greeted.getCounter(command.getName()) != 0) {
                        System.out.println(command.getName() + " has been greeted " + greeted.getCounter(command.getName()) + " time(s).");
                    } else{
                        System.out.println("Username " + command.getName() + " hasn't been greeted.");
                    }
                } else {
                    System.out.println("Username " + command.getName() + " hasn't been greeted.");
                }
            } else {
                if (greeted.totalPeopleGreeted() == 1){
                    greeted.viewData();
//                    System.out.println(greeted.viewData());
                } else if (greeted.totalPeopleGreeted() == 0){
                    System.out.println("No one has been greeted.");
                } else {
                    greeted.viewData();
//                    System.out.println(greeted.viewData());
                }
            }
            System.out.println("====================================================================================");

        } else if (("exit").equalsIgnoreCase(command.executeCmd())) {
//            This returns in order to prohibit treating an exit command as an invalid command.. It sends a signal to the Main App...
                return;

        } else {
//            This is the default message that one gets when they enter an invalid command..
            System.out.println("\033[31mError:\nYou've entered an INVALID command. " +
                    "\nPlease try using the Help command for Assistance.\033[0m");
            System.out.println("====================================================================================");

        }
    }
}