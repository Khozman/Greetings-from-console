package net.greet;

public class Command {

    private String[] array;


    public  Command(String arg) {

        this.array = arg.split(" ");

    }

    public String getCmd(){
        if(array.length <= 3) {
            return array[0];
        } else {
            return "Invalid";
        }
    }

    public String getName(){
        if (array.length > 0) {
            return array.length > 1 ? array[1] : "";
        } else {
            return "no name";
        }
    }

    public String getLanguage(){
        return array.length > 2 ? array[2] : "English";
    }

}



