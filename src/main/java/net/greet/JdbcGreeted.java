package net.greet;

import java.sql.*;

public class JdbcGreeted implements PersonGreeted {

    final String INSERT_PERSON_SQL = "insert into GREETINGS_COUNTER (USERNAME, GREET_COUNT) values(?, ?)";
    final String FIND_PERSON_SQL = "select GREET_COUNT from GREETINGS_COUNTER where USERNAME = ?";
    final String UPDATE_PERSON_SQL = "update GREETINGS_COUNTER set GREET_COUNT = ? where USERNAME = ?";
    final String COUNT_PEOPLE_SQL = "select count(*) as counter from GREETINGS_COUNTER";
    final String DELETE_ROW_SQL = "delete from GREETINGS_COUNTER where USERNAME = ?";
    final String DELETE_ALL_USERS_SQL = "delete from GREETINGS_COUNTER";
    final String VIEW_TABLE_SQL = "select USERNAME, GREET_COUNT from GREETINGS_COUNTER";

    Connection conn;
    PreparedStatement createNewPersonGreeted;
    PreparedStatement findPersonCount;
    PreparedStatement updatePersonCount;
    PreparedStatement countPeoplePreparedStatement;
    PreparedStatement deleteUserRow;
    PreparedStatement deleteAllUsers;
    PreparedStatement viewTable;

    public JdbcGreeted() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/greetings", "bekz", "");
            createNewPersonGreeted = conn.prepareStatement(INSERT_PERSON_SQL);
            findPersonCount = conn.prepareStatement(FIND_PERSON_SQL);
            updatePersonCount = conn.prepareStatement(UPDATE_PERSON_SQL);
            countPeoplePreparedStatement = conn.prepareStatement(COUNT_PEOPLE_SQL);
            deleteUserRow = conn.prepareStatement(DELETE_ROW_SQL);
            deleteAllUsers = conn.prepareStatement(DELETE_ALL_USERS_SQL);
            viewTable = conn.prepareStatement(VIEW_TABLE_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setCounter(String name) {
        // insert or update the person count for the given person in the database...

        try {
            // find the counter for the current person
            findPersonCount.setString(1, name);
            ResultSet rsPersonGreeted = findPersonCount.executeQuery();

            if (!rsPersonGreeted.next()) {
                // insertCreateNewPersonGreeted.setString(1, name);
                createNewPersonGreeted.setString(1, name);
                createNewPersonGreeted.setInt(2, 1);
                createNewPersonGreeted.execute();

            } else {
                int greetCounter = rsPersonGreeted.getInt("GREET_COUNT") + 1;
                updatePersonCount.setInt(1, greetCounter);
                updatePersonCount.setString(2, name);
                updatePersonCount.execute();
            }

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int totalPeopleGreeted(String name) {
        // get the person count from the database - using a sql query...
        try {
            findPersonCount.setString(1, name);
            ResultSet rs = findPersonCount.executeQuery();
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
        //     This function gets the size of the map..
        try {
            ResultSet rs = countPeoplePreparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt("counter");
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }

    public boolean checkName(String name){
        //        This function checks for the name if it exists in the map..
        try {
            findPersonCount.setString(1, name);
            ResultSet rsPersonGreeted = findPersonCount.executeQuery();

            if(rsPersonGreeted.next() ){
                return true;
            }
        }catch (SQLException e){
            return false;
        }
        return false;
    }

    public String clearUsers(){
        //        This function deletes all the users in the maps..
        try {
            deleteAllUsers.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public int getCounter(String name){
        //        This function gets a count on how many time an individual has been greeted..
        try {
            findPersonCount.setString(1, name);
            ResultSet rs = findPersonCount.executeQuery();
            if (rs.next()) {
                return rs.getInt("GREET_COUNT");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // if this person wasn't greeted yet
        return 0;
    }

    public int clearCount(String name){
        //        This function simply deletes the user from the table in the database..
        try {

            deleteUserRow.setString(1, name);
            deleteUserRow.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // if this person wasn't greeted yet
        return 0;
    }

    public int totalPeopleGreeted(){

        try {
            ResultSet rs = countPeoplePreparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt("counter");
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }

    public void viewData(){
//        Take all the information on the DB and insert it to a HashMap and then return it in this section.
        try{
            ResultSet rs = viewTable.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

//          Iterate through the data in the result set and display it.
            while (rs.next()) {
                //Print one row
                for(int i = 1 ; i <= columnsNumber; i++){
                    System.out.print("| " + rs.getString(i) + " "); //Print one element of a row
                }
                System.out.println("   |");
                System.out.println("----------------------");
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
