package net.greet;

public class Greeter {

    public String greetPerson(String name, String language) {
//        This method takes in a name and a language and then chooses the language to greet the user...
            if (("english").equalsIgnoreCase(language)) {
                System.out.println ("Hello " + name + "!");
                return ("Hello " + name + "!");
            } else if (("french").equalsIgnoreCase(language)) {
                System.out.println ("Bonjour " + name + "!");
                return ("Bonjour " + name + "!");
            } else if (("chinese").equalsIgnoreCase(language)) {
                System.out.println ("你好 " + name + "!");
                return ("你好 " + name + "!");
            }
            return null;
    }
}
