package person.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
class RestEndpointTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    RestEndpoint restEndpoint;

    @Test
    @DirtiesContext
    void receiveHello() {
        Assertions.assertNotNull(restEndpoint);
        Assertions.assertNotNull(mvc);

        try {
            MvcResult mvcResult = mvc.perform(get("/hello")
                    .param("name", "abc")
                    .param("age", "15")
                    .param("gender", "M")
                    .param("dateOfBirth", "12-12-1998")
                    .param("address", "grgerthe wefrefgrwe"))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertEquals("5", mvcResult.getResponse().getContentAsString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    @DirtiesContext
    void receiveHello_InvalidDateFormat() {
        Assertions.assertNotNull(restEndpoint);
        Assertions.assertNotNull(mvc);

        try {
            MvcResult mvcResult = mvc.perform(get("/hello")
                    .param("name", "abc")
                    .param("age", "15")
                    .param("gender", "M")
                    .param("dateOfBirth", "12121998")
                    .param("address", "grgerthe wefrefgrwe"))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertEquals("5", mvcResult.getResponse().getContentAsString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}