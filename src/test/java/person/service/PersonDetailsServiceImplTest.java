package person.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import person.model.PersonDetails;

import java.util.List;

@SpringBootTest
@ActiveProfiles(value = "test")
public class PersonDetailsServiceImplTest {

	@Autowired
	private PersonDetailService personDetailService;

	@Test
	@DirtiesContext
	public void testInsert() {

		personDetailService.insert(new PersonDetails("Hello", 25, "M", null, null));
		List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
		Assertions.assertEquals(5, personDetails.size(), "Inserting new entry to person details table did not happen as expected");
	}

	@Test
	public void testLoadAll() {
		List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
		Assertions.assertEquals(4, personDetails.size(), "Number of person details received does not match the expected value");
	}
}
