package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetedTester {
    @Test
    void getCountForUsers() throws SQLException {
        JdbcGreeted db = new JdbcGreeted();

        assertEquals(2, db.getSize());
    }

    @Test
    void shouldCountTheNumberOfPeople() throws SQLException {
        JdbcGreeted db = new JdbcGreeted();

        assertEquals(2, db.totalPeopleGreeted());
    }
}
