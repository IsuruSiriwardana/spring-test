package person.controller;

import person.model.PersonDetails;
import person.service.PersonDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class RestEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestEndpoint.class);

    @Autowired
    protected PersonDetailService personDetailService;

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity receiveHello(
            @RequestParam(name="name") String name,
            @RequestParam(name = "age") Integer age,
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "dateOfBirth", required = false) String dateOfBirth,
            @RequestParam(name = "address", required = false) String address

    ) {
        log.info("Received hello from: {}", name);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date dateOfBirthValue = null;
        try {
            dateOfBirthValue = df.parse(dateOfBirth);
        }catch (Exception ex){
            log.error("Invalid date format found: ", ex);
        }
        personDetailService.insert(new PersonDetails(name, age, gender, dateOfBirthValue, address));
        List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
        log.info("Done: {}", personDetails.size());
        return ResponseEntity.of(Optional.of(personDetails.size()));
    }

}
