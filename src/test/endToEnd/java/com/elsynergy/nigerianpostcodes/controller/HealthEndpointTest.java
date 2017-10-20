package com.elsynergy.nigerianpostcodes.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class HealthEndpointTest
{
    private static final String HEALTH_ENDPOINT = "/health";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception
    {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void testHealthEndpoint()
            throws Exception
    {
        this.mvc.perform(get(HEALTH_ENDPOINT))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status", equalTo("UP")))
        .andExpect(jsonPath("$.db.status", equalTo("UP")))
        .andExpect(jsonPath("$.diskSpace").doesNotExist());
    }

}
