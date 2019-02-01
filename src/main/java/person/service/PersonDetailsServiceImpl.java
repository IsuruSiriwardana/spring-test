package person.service;

import person.dao.PersonDetailsDao;
import person.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDetailsServiceImpl implements PersonDetailService {

    @Autowired
    private PersonDetailsDao personDetailsDao;

    public List<PersonDetails> loadAllPersonDetails() {
        return personDetailsDao.loadAllPersonDetails();
    }

    public void insert(PersonDetails personDetails) {
        personDetailsDao.insertPersonDetails(personDetails);
    }
}
