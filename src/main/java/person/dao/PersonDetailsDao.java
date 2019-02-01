package person.dao;

import person.model.PersonDetails;

import java.util.List;

public interface PersonDetailsDao {

    List<PersonDetails> loadAllPersonDetails();
    void insertPersonDetails(PersonDetails personDetails);
}
