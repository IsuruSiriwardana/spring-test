package isuru.test.springtest.service;

import isuru.test.springtest.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class StarterService {

    @Autowired
    private PersonDetailService personDetailService;

    public void startService(){
        System.out.println("Running");
        List<PersonDetails> personDetails = generateFewPersons();
        personDetailService.insert(personDetails.get(0));
        System.out.println("All done");
    }

    private List<PersonDetails> generateFewPersons() {
        PersonDetails person1 = new PersonDetails("person1", 25, "M", new Date(), "Address1" );
        PersonDetails person2 = new PersonDetails("person2", 15, "F", new Date(), "Address2" );
        PersonDetails person3 = new PersonDetails("person3", 40, "M", new Date(), "Address3" );
        return Arrays.asList(new PersonDetails[]{person1, person2, person3});
    }
}
