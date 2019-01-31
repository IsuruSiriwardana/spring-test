package isuru.test.springtest;

import isuru.test.springtest.model.PersonDetails;
import isuru.test.springtest.service.PersonDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=test"})
public class SpringTestApplicationTests {

	@Value("${spring.datasource.username}")
	private String userName;

	@Autowired
	private PersonDetailService personDetailService;

	@Test
	public void contextLoads() {
		System.out.println("Running: " + userName);
		List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
		System.out.println("Count: " + personDetails.size());
	}

}
