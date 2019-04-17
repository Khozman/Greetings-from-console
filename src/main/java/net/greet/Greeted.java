package net.greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted implements PersonGreeter {

    Map<String, Integer> personGreetedMap = new HashMap<String, Integer>();

    public void setCounter(String name) {

        if (!personGreetedMap.containsKey(name)) {
            personGreetedMap.put(name, 0);

        }
        int greetCounter = personGreetedMap.get(name);
        greetCounter++;
        personGreetedMap.put(name, greetCounter);
    }

    public int getCounter(String name){
        try{
            return personGreetedMap.get(name);
        }catch (NullPointerException e){
            return 0;
        }
    }

    public int clearCount(String name){
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
        return personGreetedMap.size();
    }

    public boolean checkName(String name){
        return personGreetedMap.containsKey(name);
    }

    public String clearUsers(){
        personGreetedMap.clear();
        return "Map cleared";
    }

    public HashMap viewData(){
        return (HashMap) personGreetedMap;
    }
}
