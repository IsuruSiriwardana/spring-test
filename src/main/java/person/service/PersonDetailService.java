package person.service;

import person.model.PersonDetails;

import java.util.List;

public interface PersonDetailService {
    List<PersonDetails> loadAllPersonDetails();
    void insert(PersonDetails personDetails);

}
