package com.elsynergy.nigerianpostcodes.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.RuralAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralAreaResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RuralAreaResponseMapperTest
{
    @InjectMocks
    private RuralAreaResponseMapper ruralAreaResponseMapper;

    @Test
    public void testMap()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final LocalGovernmentArea lga = new LocalGovernmentArea();
        lga.setId(15);
        lga.setName("testLga");
        lga.setState(state);

        final RuralArea in = new RuralArea();
        in.setId(1);
        in.setName("testRuralArea");
        in.setPostcode("1234");
        in.setLocalGovernmentArea(lga);

        final RuralAreaResponse out = this.ruralAreaResponseMapper.map(in);

        assertEquals(in.getId(), out.getRuralAreaId());
        assertEquals(in.getName(), out.getRuralAreaName());
        assertEquals(in.getPostcode(), out.getPostcode());
        assertEquals(in.getLocalGovernmentArea().getId(), out.getLocalGovernmentAreaId());
        assertEquals(in.getLocalGovernmentArea().getName(), out.getLocalGovernmentAreaName());
        assertEquals(in.getLocalGovernmentArea().getState().getCode(), out.getStateCode());
        assertEquals(in.getLocalGovernmentArea().getState().getName(), out.getStateName());
    }

}
