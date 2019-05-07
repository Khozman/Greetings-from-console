package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetedTester {
    @Test
    void shouldClearAllUsersFromMap(){
        Greeted map = new Greeted();

        map.setCounter("Thakzin");
        map.setCounter("Vusi");
        map.setCounter("Thabang");
        map.setCounter("Thembi");
        map.setCounter("Bekz");
        map.clearUsers();

        assertEquals(0, map.totalPeopleGreeted());
    }

    @BeforeEach
    void shouldClearMap(){
        Greeted map = new Greeted();
        map.clearUsers();
    }

    @Test
    void shouldGetCountForUsers(){

        Greeted map = new Greeted();

        map.setCounter("Bheki");
        map.setCounter("Roger");

        assertEquals(2, map.getTotalNumberOfPeople());
    }

    @Test
    void shouldCountTheNumberOfPeople(){
        Greeted map = new Greeted();

        map.setCounter("Thakzin");
        map.setCounter("Vusi");
        map.setCounter("Thabang");
        map.setCounter("Thembi");
        map.setCounter("Bekz");

        assertEquals(5, map.totalPeopleGreeted());
    }

    @Test
    void shouldCheckTheNumberOfTimesAUserIsGreeted(){
        Greeted map = new Greeted();

        map.setCounter("Thabang");
        map.setCounter("Vusi");
        map.setCounter("Vusi");
        map.setCounter("Thabang");
        map.setCounter("Vusi");
        map.setCounter("Vusi");

        assertEquals(2, map.getCounter("Thabang"));
        assertEquals(4, map.getCounter("Vusi"));
    }

    @Test
    void shouldCheckWhetherNameExits(){
        Greeted map = new Greeted();

        map.setCounter("Bheki");
        map.setCounter("Amos");

        assertTrue(map.checkName("Bheki"));
        assertTrue(map.checkName("Amos"));
        assertEquals(false, map.checkName("Vutlhari"));
    }

    @Test
    void shouldClearSpecificUserFromMap(){
        Greeted map = new Greeted();

        map.setCounter("Thakzin");
        map.setCounter("Vusi");
        map.setCounter("Thabang");
        map.setCounter("Thembi");
        map.setCounter("Bekz");
        map.clearCount("Thakzin");
        map.clearCount("Bekz");

        assertEquals(3, map.totalPeopleGreeted());

    }
}
