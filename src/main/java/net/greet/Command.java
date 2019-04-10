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
        return array.length > 1 ? array[1].substring(0, 1).toUpperCase() + array[1].substring(1).toLowerCase() : null;
    }

    public String getLanguage(){
        return array.length > 2 ? array[2] : "English";
    }

}



