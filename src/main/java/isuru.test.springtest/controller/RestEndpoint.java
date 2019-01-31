package isuru.test.springtest.controller;

import isuru.test.springtest.model.PersonDetails;
import isuru.test.springtest.service.PersonDetailService;
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
        System.out.println("Received hello from: " + name);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date dateOfBirthValue = null;
        try {
            dateOfBirthValue = df.parse(dateOfBirth);
        }catch (Exception ex){}
        personDetailService.insert(new PersonDetails(name, age, gender, dateOfBirthValue, address));
        List<PersonDetails> personDetails = personDetailService.loadAllPersonDetails();
        System.out.println("Done: " + personDetails.size());
        return ResponseEntity.of(Optional.of(personDetails.size()));
    }

}
