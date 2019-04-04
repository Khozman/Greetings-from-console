package net.greet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean running = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Greetings App!\n\n");

        Command command = new Command();
        while (running) {
            System.out.println("Please Enter a command!\n\n");

            String arg = sc.nextLine();
            String[] ary = arg.split(" ");

            if(ary.length <= 3){

                if (("exit").equalsIgnoreCase(ary[0])) {
                    running = false;
                    System.out.println("Successfully logged out!!!!");
                } else {
                    command.string(ary);
                }
            }
        }
    }
}
