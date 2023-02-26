package com.Izicap.homework.tests;

import com.Izicap.homework.config.MyConfig;
import com.Izicap.homework.model.RequestToGpt;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest

public class AppTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc ;
    @Test
    public void testService() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.mockMvc.perform(post("/api/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"What is jenkins\"}"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful());
    }

}