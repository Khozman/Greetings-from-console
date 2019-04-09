package net.greet;

public class Greeter {
    public void greetPerson(String name, String language) {
            if (("english").equalsIgnoreCase(language)) {
                System.out.println("Hello " + name + "!");
            } else if (("french").equalsIgnoreCase(language)) {
                System.out.println("Bonjour " + name + "!");
            } else if (("chinese").equalsIgnoreCase(language)) {
                System.out.println("你好 " + name + "!");
            }
        System.out.println("====================================================================================");
    }
}
