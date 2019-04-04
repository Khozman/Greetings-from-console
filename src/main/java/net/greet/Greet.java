package net.greet;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args){

        boolean running = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Greetings App!\n\n");

        while (running) {
            System.out.println("Please Enter a command!\n\n");

            String arg = sc.nextLine();

            String[] ary = arg.split(" ");

            if (("greet").equalsIgnoreCase(ary[0])) {
                if (ary.length == 2) {
                    System.out.println("Hello " + ary[1] + "!\n");
                } else if (("french").equalsIgnoreCase(ary[2])) {
                    System.out.println("Bonjour " + ary[1] + "!\n");
                } else if (("chinese").equalsIgnoreCase(ary[2])) {
                    System.out.println("你好 " + ary[1] + "!\n");
                } else if (("english").equalsIgnoreCase(ary[2])) {
                    System.out.println("Hello " + ary[1] + "!\n");
                }
            } else if (("help").equalsIgnoreCase(ary[0])) {
                System.out.println("Welcome to the Help page");
            } else if (("clear").equalsIgnoreCase(ary[0])) {
                System.out.println("cleared!!!!!");
            } else if (("exit").equalsIgnoreCase(ary[0])) {
                running = false;
                System.out.println("Successfully logged out!!!!");
            } else if (("greeted").equalsIgnoreCase(ary[0])) {
                System.out.println("__ People greeted");
            } else {
                System.out.println("Error!!!!!!!!\nYou've entered an INVALID command. " +
                        "\nPlease try using the Help command for Assistance.\n");
            }
        }

    }
}
