package person.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import person.model.PersonDetails;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=test"})
public class PersonDetailsServiceImplTest {

	@Autowired
	private PersonDetailService personDetailService;

	@Test
	@DirtiesContext
	public void testInsert() {

		personDetailService.insert(new PersonDetails("Hello", 25, "M", null, null));
		List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
		Assert.assertEquals("Inserting new entry to person details table did not happen as expected", 5, personDetails.size());
	}

	@Test
	public void testLoadAll() {
		List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
		Assert.assertEquals("Number of person details received does not match the expected value", 4, personDetails.size());
	}
}
