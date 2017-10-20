package com.elsynergy.nigerianpostcodes.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.PostOfficeFacilityResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.PostOfficeFacility;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.PostOfficeFacilityResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PostOfficeFacilityResponseMapperTest
{
    @InjectMocks
    private PostOfficeFacilityResponseMapper postOfficeFacilityResponseMapper;

    @Test
    public void testMap()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final LocalGovernmentArea localGovernmentArea = new LocalGovernmentArea();
        localGovernmentArea.setId(1);
        localGovernmentArea.setName("testLga");
        localGovernmentArea.setState(state);

        final PostOfficeFacility in = new PostOfficeFacility();
        in.setFacility("testFacility");
        in.setPostcode("345678");
        in.setTown("testTown");
        in.setArea("testArea");
        in.setType("testType");
        in.setRangeOfPMB("testPMB");
        in.setRangeOfPOB("testPOB");
        in.setLocalGovernmentArea(localGovernmentArea);

        final PostOfficeFacilityResponse out = this.postOfficeFacilityResponseMapper.map(in);

        assertEquals(in.getFacility(), out.getPostOfficeFacilityName());
        assertEquals(in.getPostcode(), out.getPostcode());
        assertEquals(in.getTown(), out.getTown());
        assertEquals(in.getArea(), out.getArea());
        assertEquals(in.getType(), out.getFacilityType());
        assertEquals(in.getRangeOfPMB(), out.getRangeOfPMB());
        assertEquals(in.getRangeOfPOB(), out.getRangeOfPOB());
        assertEquals(in.getLocalGovernmentArea().getName(), out.getLocalGovernmentAreaName());
        assertEquals(in.getLocalGovernmentArea().getState().getCode(), out.getStateCode());
        assertEquals(in.getLocalGovernmentArea().getState().getName(), out.getStateName());
    }

}
