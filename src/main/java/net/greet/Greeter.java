package net.greet;

public class Greeter {

    public String greetPerson(String name, String language) {
//        This method takes in a name and a language and then chooses the language to greet the user...
            if (("english").equalsIgnoreCase(language)) {
                return ("Hello " + name + "!");
            } else if (("french").equalsIgnoreCase(language)) {
                return ("Bonjour " + name + "!");
            } else if (("chinese").equalsIgnoreCase(language)) {
                return ("你好 " + name + "!");
            }
            return null;
    }
}
