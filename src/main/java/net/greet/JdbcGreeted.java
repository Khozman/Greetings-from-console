package net.greet;

import java.sql.*;
import java.util.HashMap;

public class JdbcGreeted implements PersonGreeter {

    final String INSERT_PERSON_SQL = "insert into PERSON_COUNT (USERNAME, GREET_COUNT) values(?, ?)";
    final String FIND_PERSON_SQL = "select GREET_COUNT from PERSON_COUNT where USERNAME = ?";
    final String UPDATE_PERSON_SQL = "update PERSON_COUNT set GREET_COUNT = ? where USERNAME = ?";

    Connection conn;
    PreparedStatement psCreateNewPersonGreeted;
    PreparedStatement psFindPersonCount;
    PreparedStatement psUpdatePersonCount;

    public JdbcGreeted() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/greetings", "bekz", "");
            psCreateNewPersonGreeted = conn.prepareStatement(INSERT_PERSON_SQL);
            psFindPersonCount = conn.prepareStatement(FIND_PERSON_SQL);
            psUpdatePersonCount = conn.prepareStatement(UPDATE_PERSON_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setCounter(String name) {
        // insert / update the pet count for the given pet in the database...

        try {
            // find the counter for the current petType;
            psFindPersonCount.setString(1, name);
            ResultSet rsPersonGreeted = psFindPersonCount.executeQuery();

            if (!rsPersonGreeted.next()) {
                // insert
                psCreateNewPersonGreeted.setString(1, name);
                psCreateNewPersonGreeted.setInt(2, 1);
                System.out.println(psCreateNewPersonGreeted.execute());

            } else {
                int greetCounter = rsPersonGreeted.getInt("GREET_COUNT") + 1;
                psUpdatePersonCount.setInt(1, greetCounter);
                psUpdatePersonCount.setString(2, name);
                psUpdatePersonCount.execute();
            }

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int totalPeopleGreeted(String name) {
        // get the pet type count from the database - using a sql query...
        try {
            psFindPersonCount.setString(1, name);
            ResultSet rs = psFindPersonCount.executeQuery();
            if (rs.next()) {
                return rs.getInt("GREET_COUNT");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // if this person wasn't greeted yet
        return 0;
    }

    public int getSize(){
        ////
        return 56;
    }

    public boolean checkName(String name){

        return false;
    }

    public String clearUsers(){

        return null;
    }

    public int getCounter(String name){

        return 0;
    }

    public int clearCount(String name){

        return 0;
    }

    public int totalPeopleGreeted(){

        return 0;
    }

    public HashMap viewData(){
//        Take all the information on the DB and insert it to a HashMap and then return it in this section.
        return null;
    }
}
