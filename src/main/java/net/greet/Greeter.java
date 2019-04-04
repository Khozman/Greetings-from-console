package net.greet;

public class Greeter {
    public void greetPerson(String name, String language) {
            if (("english").equalsIgnoreCase(language)) {
                System.out.println("Hello " + name + "!\n");
            } else if (("french").equalsIgnoreCase(language)) {
                System.out.println("Bonjour " + name + "!\n");
            } else if (("chinese").equalsIgnoreCase(language)) {
                System.out.println("你好 " + name + "!\n");
            }
    }
}
