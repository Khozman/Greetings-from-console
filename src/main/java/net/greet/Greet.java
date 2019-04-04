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

            String x = ary[0];
            String y = ary[2]

            if (("greet").equalsIgnoreCase(x)) {
                if (ary[2].equals("english")) {
                    System.out.println("Hello " + ary[1] + "!\n");
                } else if (ary[2].equals("french")) {
                    System.out.println("Bonjour " + ary[1] + "!\n");
                } else if (ary[2].equals("chinese")) {
                    System.out.println("你好 " + ary[1] + "!\n");
                }
            } else if (ary[0].equals("help")) {
                System.out.println("Welcome to the Help page");
            } else if (ary[0].equals("clear")) {
                System.out.println("cleared!!!!!");
            } else if (ary[0].equals("exit")) {
                running = false;
                System.out.println("Successfully logged out!!!!");
            } else if (ary[0].equals("greeted")) {
                System.out.println("__ People greeted");
            } else {
                System.out.println("Error 404\n");
            }
        }

    }
}
