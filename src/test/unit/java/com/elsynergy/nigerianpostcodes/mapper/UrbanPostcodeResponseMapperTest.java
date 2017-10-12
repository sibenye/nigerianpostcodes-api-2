package com.elsynergy.nigerianpostcodes.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.UrbanPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.UrbanPostcodeResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UrbanPostcodeResponseMapperTest
{
    @InjectMocks
    private UrbanPostcodeResponseMapper urbanPostcodeResponseMapper;

    @Test
    public void testMap()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final UrbanTown urbanTown = new UrbanTown();
        urbanTown.setName("testTown");
        urbanTown.setState(state);

        final UrbanArea urbanArea = new UrbanArea();
        urbanArea.setName("testArea");
        urbanArea.setPostcode("34677");
        urbanArea.setUrbanTown(urbanTown);

        final UrbanPostcode in = new UrbanPostcode();
        in.setStreet("testStreet");
        in.setUrbanArea(urbanArea);

        final UrbanPostcodeResponse out = this.urbanPostcodeResponseMapper.map(in);

        assertEquals(in.getUrbanArea().getPostcode(), out.getPostcode());
        assertEquals(in.getStreet(), out.getStreet());
        assertEquals(in.getUrbanArea().getName(), out.getArea());
        assertEquals(in.getUrbanArea().getUrbanTown().getName(), out.getTown());
        assertEquals(in.getUrbanArea().getUrbanTown().getState().getCode(), out.getStateCode());
        assertEquals(in.getUrbanArea().getUrbanTown().getState().getName(), out.getStateName());
    }

}
