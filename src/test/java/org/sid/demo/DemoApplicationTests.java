package org.sid.demo;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.sid.demo.dao.PersonneRepeository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


//@SpringBootTest
//'@RunWith(SpringRunner.class)
@WebMvcTest
//@ContextConfiguration(classes= Application.class)
@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonneRepeository personneRepeository;

    @Test
    void contextLoads() throws Exception {

       when(personneRepeository.findAll()).thenReturn(
                Collections.emptyList()
        );

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/personnes")
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());


        //verify(personneRepeository.findAll());


    }

}
