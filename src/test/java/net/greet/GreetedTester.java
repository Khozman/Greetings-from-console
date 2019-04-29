package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetedTester {
    @Test
    void shouldClearAllUsersFromMap(){
        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Thakzin");
        db.setCounter("Vusi");
        db.setCounter("Thabang");
        db.setCounter("Thembi");
        db.setCounter("Bekz");
        db.clearUsers();

        assertEquals(0, db.totalPeopleGreeted());
    }

    @BeforeEach
    void shouldClearMap(){
        JdbcGreeted db = new JdbcGreeted();
        db.clearUsers();
    }

    @Test
    void shouldGetCountForUsers(){

        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Bheki");
        db.setCounter("Roger");

        assertEquals(2, db.getSize());
    }

    @Test
    void shouldCountTheNumberOfPeople(){
        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Thakzin");
        db.setCounter("Vusi");
        db.setCounter("Thabang");
        db.setCounter("Thembi");
        db.setCounter("Bekz");

        assertEquals(5, db.totalPeopleGreeted());
    }

    @Test
    void shouldCheckTheNumberOfTimesAUserIsGreeted(){
        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Thabang");
        db.setCounter("Vusi");
        db.setCounter("Vusi");
        db.setCounter("Thabang");
        db.setCounter("Vusi");
        db.setCounter("Vusi");

        assertEquals(2, db.getCounter("Thabang"));
        assertEquals(4, db.getCounter("Vusi"));
    }

    @Test
    void shouldCheckWhetherNameExits(){
        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Bheki");
        db.setCounter("Amos");

        assertEquals(true,db.checkName("Bheki"));
        assertEquals(true,db.checkName("Amos"));
        assertEquals(false,db.checkName("Vutlhari"));
    }

    @Test
    void shouldClearSpecificUserFromMap(){
        JdbcGreeted db = new JdbcGreeted();

        db.setCounter("Thakzin");
        db.setCounter("Vusi");
        db.setCounter("Thabang");
        db.setCounter("Thembi");
        db.setCounter("Bekz");
        db.clearCount("Thakzin");
        db.clearCount("Bekz");

        assertEquals(3, db.totalPeopleGreeted());

    }
}
