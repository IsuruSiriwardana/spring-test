package person.dao;

import person.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDetailsDaoImpl extends JdbcDaoSupport implements PersonDetailsDao {

    @Autowired
    protected DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public List<PersonDetails> loadAllPersonDetails() {
        String sql = "select name, age, gender, date_of_birth, address from person_details";
        return getJdbcTemplate().query(sql, new PersonDetailRowMapper());
    }

    public void insertPersonDetails(PersonDetails personDetails) {
        String sql = "insert into person_details (name, age, gender, date_of_birth, address) values (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql,
                personDetails.getName(),
                personDetails.getAge(),
                personDetails.getGender(),
                personDetails.getDateOfBirth(),
                personDetails.getAddress()
        );
    }
}

class PersonDetailRowMapper implements RowMapper<PersonDetails> {

    @Override
    public PersonDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        return new PersonDetails(
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getString("gender"),
                resultSet.getDate("date_of_birth"),
                resultSet.getString("address")
        );
    }
}