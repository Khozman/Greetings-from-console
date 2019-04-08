package net.greet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean running = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Greetings App!\n\n");

        Controller controller = new Controller();

        while (running) {
            System.out.println("Please Enter a command!\n\n");

            controller.process(sc.nextLine());


            if (("exit").equalsIgnoreCase(controller.command.getCmd())) {
                running = false;
                System.out.println("Successfully logged out!!!!");
            } else {
                controller.command.getCmd();
            }
        }
    }
}

