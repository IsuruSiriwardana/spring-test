package isuru.test.springtest.dao;

import isuru.test.springtest.model.PersonDetails;

import java.util.List;

public interface PersonDetailsDao {

    List<PersonDetails> loadAllPersonDetails();
    void insertPersonDetails(PersonDetails personDetails);
}
