package net.greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted implements PersonGreeted {

    Map<String, Integer> personGreetedMap = new HashMap<String, Integer>();

    public void setCounter(String name) {
//This function sets the count of an individual to 0..
        if (!personGreetedMap.containsKey(name)) {
            personGreetedMap.put(name, 0);

        }
        int greetCounter = personGreetedMap.get(name);
        greetCounter++;
        personGreetedMap.put(name, greetCounter);
    }

    public int getCounter(String name){
//        This function gets a count on how many time an individual has been greeted..
        try{
            return personGreetedMap.get(name);
        }catch (NullPointerException e){
            return 0;
        }
    }

    public int clearCount(String name){
//        This function simply clears the user from the map..
        personGreetedMap.remove(name);
        try {
            return  personGreetedMap.get(name);
        } catch (NullPointerException e){
            return 0;
        }
    }

    public int totalPeopleGreeted() {

        int totalPeopleGreeted = 0;
        for (Integer greetCount : personGreetedMap.values()) {
            totalPeopleGreeted += greetCount;
        }
        return totalPeopleGreeted;
    }

    public int totalPeopleGreeted(String name){

            if (!personGreetedMap.containsKey(name)) {
                return 0;
            }
            return personGreetedMap.get(name);
    }

    public int getSize(){
//        This function gets the size of the map..
        return personGreetedMap.size();
    }

    public boolean checkName(String name){
//        This function checks for the name if it exists in the map..
        return personGreetedMap.containsKey(name);
    }

    public String clearUsers(){
//        This function deletes all the users in the maps..
        personGreetedMap.clear();
        return "Map cleared";
    }

    public void viewData(){
//        This prints out the map..
        System.out.println(personGreetedMap);

    }
}
