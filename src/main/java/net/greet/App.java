package net.greet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean running = true;

        Scanner sc = new Scanner(System.in);
//        Welcome text.
        System.out.println("**************************\uD835\uDD4E\uD835\uDD56\uD835\uDD5D\uD835\uDD54\uD835\uDD60\uD835" +
                "\uDD5E\uD835\uDD56 \uD835\uDD65\uD835\uDD60 \uD835\uDD3E\uD835\uDD63\uD835\uDD56\uD835\uDD56\uD835\uDD65" +
                "\uD835\uDD5A\uD835\uDD5F\uD835\uDD58\uD835\uDD64 \uD835\uDD38\uD835\uDD61\uD835\uDD61.*****************" +
                "************");

        Controller controller = new Controller();

        while (running) {
            System.out.println("\n____________________________Please Enter a command._________________________________\n");


            controller.process(sc.nextLine().trim());


            if (("exit").equalsIgnoreCase(controller.command.getCmd())) {
                running = false;
                System.out.println("____________________________Successfully logged out.________________________________");
                System.out.println("====================================================================================");
            } else {
                controller.command.getCmd();
            }
        }
    }
}