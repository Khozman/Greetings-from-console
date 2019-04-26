package net.greet;

public class Command {

    private String[] array;


    public  Command(String arg) {

        this.array = arg.split(" ");
    }

    public String executeCmd(){
//        This take the first argument in the  array to set it as a command..
        if(array.length <= 3) {
            return array[0];
        } else {
            return "Invalid";
        }
    }

    public String getName(){
//        This takes the second argument, which in this case is position [1] in the array to set it to a name..
        return array.length > 1 ? array[1].substring(0, 1).toUpperCase() + array[1].substring(1).toLowerCase() : null;
    }

    public String getLanguage(){
//        This takes the third argument, which in this case will be position [2] in the array to set it to a language..
        return array.length > 2 ? array[2] : "English";
    }

}



