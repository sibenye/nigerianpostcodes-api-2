package com.elsynergy.nigerianpostcodes.exception;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.elsynergy.nigerianpostcodes.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApiExceptionHandlerTest
{
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
            .build();
    }

    @Test
    public void whenNoHandlerFoundException_thenNotFound() throws Exception
    {
        this.mvc.perform(
                get("/postcodes/ruralsss?stateCode=IM")
            )
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() throws Exception {
        this.mvc.perform(
                post("/postcodes/rural-postcodes?stateCode=IM")
            )
            .andExpect(status().isMethodNotAllowed())
            .andDo(print())
            .andExpect(jsonPath("$.response.message", is("Request method 'POST' not supported")));

    }

}
