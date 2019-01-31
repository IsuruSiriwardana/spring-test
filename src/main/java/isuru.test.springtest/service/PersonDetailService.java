package isuru.test.springtest.service;

import isuru.test.springtest.model.PersonDetails;

import java.util.List;

public interface PersonDetailService {
    List<PersonDetails> loadAllPersonDetails();
    void insert(PersonDetails personDetails);

}
