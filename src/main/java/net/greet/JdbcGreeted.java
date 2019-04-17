package net.greet;

import java.sql.*;
import java.util.HashMap;

public class JdbcGreeted implements PersonGreeter {

    final String INSERT_PERSON_SQL = "insert into PERSON_COUNT (USERNAME, GREET_COUNT) values(?, ?)";
    final String FIND_PERSON_SQL = "select GREET_COUNT from PERSON_COUNT where USERNAME = ?";
    final String UPDATE_PERSON_SQL = "update PERSON_COUNT set GREET_COUNT = ? where USERNAME = ?";
    final String COUNT_PEOPLE_SQL = "select count(*) as count from PERSON_COUNT";
    // Use DELETE
    final String sql = "DELETE FROM my_table";
    Connection conn;
    PreparedStatement CreateNewPersonGreeted;
    PreparedStatement FindPersonCount;
    PreparedStatement UpdatePersonCount;
    PreparedStatement stmt;
    PreparedStatement countPeoplePreparedStatement;

    public JdbcGreeted() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/greetings", "bekz", "");
            CreateNewPersonGreeted = conn.prepareStatement(INSERT_PERSON_SQL);
            FindPersonCount = conn.prepareStatement(FIND_PERSON_SQL);
            UpdatePersonCount = conn.prepareStatement(UPDATE_PERSON_SQL);
            countPeoplePreparedStatement = conn.prepareStatement(COUNT_PEOPLE_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setCounter(String name) {
        // insert / update the pet count for the given pet in the database...

        try {
            // find the counter for the current petType;
            FindPersonCount.setString(1, name);
            ResultSet rsPersonGreeted = FindPersonCount.executeQuery();

            if (!rsPersonGreeted.next()) {
                // insertCreateNewPersonGreeted.setString(1, name);
                CreateNewPersonGreeted.setInt(2, 1);
                System.out.println(CreateNewPersonGreeted.execute());

            } else {
                int greetCounter = rsPersonGreeted.getInt("GREET_COUNT") + 1;
                UpdatePersonCount.setInt(1, greetCounter);
                UpdatePersonCount.setString(2, name);
                UpdatePersonCount.execute();
            }

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int totalPeopleGreeted(String name) {
        // get the pet type count from the database - using a sql query...
        try {
            FindPersonCount.setString(1, name);
            ResultSet rs = FindPersonCount.executeQuery();
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
        try {
            ResultSet rs = countPeoplePreparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            return 0;
          //  e.printStackTrace();
        }
        return 0;
    }

    public boolean checkName(String name){

        return false;
    }

    public String clearUsers(){
        try {
            // Execute deletion
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            return "All User's have been cleared!";
        } catch (SQLException ex){
            ex.printStackTrace();
        }
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
