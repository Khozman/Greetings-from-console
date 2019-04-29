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

        PersonGreeted greeted = new JdbcGreeted();
        Greeter greeter = new Greeter();

        Controller controller = new Controller(greeted, greeter);

        while (running) {
            System.out.println("\n____________________________Please Enter a command._________________________________\n");

            String result = controller.process(sc.nextLine().trim());

            if (("exit").equalsIgnoreCase(result)) {
                running = false;
                System.out.println("____________________________Successfully logged out.________________________________");
                System.out.println("====================================================================================");
            } else {
                System.out.println(result);
            }
        }
    }
}