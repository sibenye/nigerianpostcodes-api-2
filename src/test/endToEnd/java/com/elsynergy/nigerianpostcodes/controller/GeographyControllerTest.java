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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.elsynergy.nigerianpostcodes.Application;
import com.elsynergy.nigerianpostcodes.util.QueryUriHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(locations = "classpath:e2etest.properties")
@WebAppConfiguration
public class GeographyControllerTest
{
    private static final String GEOGRAPHY_ENDPOINT = "/geography";

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
    public void testGetStates() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/states";
        this.mvc.perform(get(endpoint))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(37)))
        .andExpect(jsonPath("$.response.content", hasSize(37)))
        .andExpect(jsonPath("$.response.content..stateId").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists())
        .andExpect(jsonPath("$.response.content..stateCapital").exists())
        .andExpect(jsonPath("$.response.content..stateRegion").exists());
    }

    @Test
    public void testGetSingleState() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/states";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("stateCode", "KO");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..stateId").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists())
        .andExpect(jsonPath("$.response.content..stateCapital").exists())
        .andExpect(jsonPath("$.response.content..stateRegion").exists());
    }

    @Test
    public void testGetLGAs() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/lgas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("stateCode", "KO");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleLGA() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/lgas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("stateCode", "KO");
        this.qBuilder.addParam("lgaId", "424");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetRuralAreas() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/ruralAreas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("lgaId", "424");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaId").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleRuralArea() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/ruralAreas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("ruralAreaId", "1951");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaId").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetRuralVillages() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/ruralVillages";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("ruralAreaId", "1951");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..ruralVillageId").exists())
        .andExpect(jsonPath("$.response.content..ruralVillageName").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaId").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleRuralVillage() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/ruralVillages";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("ruralVillageId", "29050");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..ruralVillageId").exists())
        .andExpect(jsonPath("$.response.content..ruralVillageName").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaId").exists())
        .andExpect(jsonPath("$.response.content..ruralAreaName").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetUrbanTowns() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanTowns";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("stateCode", "IM");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..urbanTownId").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleUrbanTowns() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanTowns";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("urbanTownId", "57");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..urbanTownId").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetUrbanAreas() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanAreas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("urbanTownId", "57");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaId").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownId").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleUrbanArea() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanAreas";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("urbanAreaId", "386");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaId").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownId").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetUrbanStreets() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanStreets";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("urbanAreaId", "386");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..urbanStreetId").exists())
        .andExpect(jsonPath("$.response.content..urbanStreetName").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaId").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleUrbanStreet() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/urbanStreets";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("urbanStreetId", "7766");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..urbanStreetId").exists())
        .andExpect(jsonPath("$.response.content..urbanStreetName").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaId").exists())
        .andExpect(jsonPath("$.response.content..urbanAreaName").exists())
        .andExpect(jsonPath("$.response.content..urbanTownName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetFacilitiesInState() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/facilities";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("stateCode", "LA");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..rangeOfPOB").exists())
        .andExpect(jsonPath("$.response.content..rangeOfPMB").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityId").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityName").exists())
        .andExpect(jsonPath("$.response.content..facilityType").exists())
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..street").exists())
        .andExpect(jsonPath("$.response.content..town").exists())
        .andExpect(jsonPath("$.response.content..area").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetFacilitiesInLGA() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/facilities";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("lgaId", "457");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", greaterThan(0)))
        .andExpect(jsonPath("$.response.content", hasSize(greaterThan(0))))
        .andExpect(jsonPath("$.response.content..rangeOfPOB").exists())
        .andExpect(jsonPath("$.response.content..rangeOfPMB").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityId").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityName").exists())
        .andExpect(jsonPath("$.response.content..facilityType").exists())
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..street").exists())
        .andExpect(jsonPath("$.response.content..town").exists())
        .andExpect(jsonPath("$.response.content..area").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

    @Test
    public void testGetSingleFacility() throws Exception
    {
        final String endpoint = GEOGRAPHY_ENDPOINT + "/facilities";
        this.qBuilder = new QueryUriHelper();
        this.qBuilder.setPath(endpoint);
        this.qBuilder.addParam("postOfficeFacilityId", "1068");

        this.mvc.perform(get(this.qBuilder.buildUri()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.response.numberOfResults", equalTo(1)))
        .andExpect(jsonPath("$.response.content", hasSize(1)))
        .andExpect(jsonPath("$.response.content..rangeOfPOB").exists())
        .andExpect(jsonPath("$.response.content..rangeOfPMB").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityId").exists())
        .andExpect(jsonPath("$.response.content..postOfficeFacilityName").exists())
        .andExpect(jsonPath("$.response.content..facilityType").exists())
        .andExpect(jsonPath("$.response.content..postcode").exists())
        .andExpect(jsonPath("$.response.content..street").exists())
        .andExpect(jsonPath("$.response.content..town").exists())
        .andExpect(jsonPath("$.response.content..area").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaId").exists())
        .andExpect(jsonPath("$.response.content..localGovernmentAreaName").exists())
        .andExpect(jsonPath("$.response.content..stateCode").exists())
        .andExpect(jsonPath("$.response.content..stateName").exists());
    }

}
