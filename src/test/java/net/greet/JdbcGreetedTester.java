package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetedTester {
    @Test
    void getCountForUsers() throws SQLException {
        JdbcGreeted db = new JdbcGreeted();

        assertEquals(1, db.getSize());
    }
}
