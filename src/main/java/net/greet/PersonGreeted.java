package net.greet;

public interface PersonGreeted {
//        inter connects the relationship in between the greeted class and the JdbcGreeted..
        void setCounter(String name);
        int totalPeopleGreeted(String name);
        int getTotalNumberOfPeople();
        boolean checkName(String name);
        String clearUsers();
        int getCounter(String name);
        int clearCount(String name);
        int totalPeopleGreeted();
        void viewData();
}
