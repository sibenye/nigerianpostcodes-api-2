package com.elsynergy.nigerianpostcodes.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
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
import com.elsynergy.nigerianpostcodes.util.QueryUriHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class PostcodeControllerTest
{
    private static final String POSTCODE_ENDPOINT = "/postcodes";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private QueryUriHelper qBuilder;

    @Before
    public void setUp() throws Exception
    {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void testGetRuralPostcodesByStateCode() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/rural-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode
        this.qBuilder.addParam("stateCode", "KO");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..ruralVillageName").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());

    }

    @Test
    public void testGetRuralPostcodesByStateCodeAndLga() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/rural-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and lgaName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("localGovtAreaName", "Adavi");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))));

    }

    @Test
    public void testGetRuralPostcodesByStateCodeAndRuralAreaName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/rural-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

      //by stateCode and ruralAreaName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("ruralAreaName", "Adavi");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))));

    }

    @Test
    public void testGetRuralPostcodesByStateCodeAndVillageName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/rural-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and villageName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("ruralVillageName", "Abagiri");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)));

    }

    @Test
    public void testGetUrbanPostcodesByStateCode() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/urban-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode
        this.qBuilder.addParam("stateCode", "KO");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..urbanStreetName").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());

    }


    @Test
    public void testGetUrbanPostcodesByStateCodeAndUrbanTownName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/urban-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and urbanTownName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("urbanTownName", "Kabba");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))));

    }

    @Test
    public void testGetUrbanPostcodesByStateCodeAndUrbanAreaName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/urban-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and urbanAreaName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("urbanAreaName", "Sir James Oloruntoba Way");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))));

    }

    @Test
    public void testGetUrbanPostcodesByStateCodeAndUrbanStreetName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/urban-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and urbanStreetName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("urbanStreetName", "Ayeteju  St.");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)));

    }

    @Test
    public void testGetFacilityPostcodesByStateCode() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/facility-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode
        this.qBuilder.addParam("stateCode", "KO");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..facilityName").exists())
        .andExpect(jsonPath("$.response.content..townName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());

    }

    @Test
    public void testGetFacilityPostcodesByStateCodeAndLgaName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/facility-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and lgaName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("localGovtAreaName", "Ajaokuta");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))));

    }

    @Test
    public void testGetFacilityPostcodesByStateCodeAndFacilityName() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/facility-postcodes";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        //by stateCode and facilityName
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("facilityName", "Ajaokuta");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)));

    }

    @Test
    public void testSearchUrbanPostcodes() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/urban-postcodes/search";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("urbanTownName", "Kabba");
        this.qBuilder.addParam("hint", "ay");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..urbanStreetName").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());

    }

    @Test
    public void testPostcodeReverseLookup() throws Exception
    {
        final String endpoint = POSTCODE_ENDPOINT + "/reverse-lookup";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);

        this.qBuilder.addParam("postcode", "261251");
        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.postcodeType").exists())
        .andExpect(jsonPath("$.response.ruralPostcodeResponses", equalTo(null)))
        .andExpect(jsonPath("$.response.urbanPostcodeResponses").exists())
        .andExpect(jsonPath("$.response.facilityPostcodeResponses", equalTo(null)));

    }

}
