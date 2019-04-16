package net.greet;

public class JdbcGreeted implements PersonGreeter {

    final String INSERT_PET_SQL = "insert into pet_spot_count (pet_type, pet_count) values(?, ?)";

    final String FIND_PET_TYPE_SQL = "select pet_count from pet_spot_count where pet_type = ?";

    final String UPDATE_PET_TYPE_SQL = "update pet_spot_count set pet_count = ? where pet_type = ?";



    @Override
    public int totalPeopleGreeted() {
        return 0;
    }
}
