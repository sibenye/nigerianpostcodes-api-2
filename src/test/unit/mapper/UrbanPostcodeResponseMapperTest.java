package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.UrbanPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
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

        final UrbanArea urbanArea = new UrbanArea();
        urbanArea.setName("testArea");
        urbanArea.setState(state);

        final UrbanPostcode in = new UrbanPostcode();
        in.setPostcode("34677");
        in.setStreet("testStreet");
        in.setTown("testTown");
        in.setUrbanArea(urbanArea);

        final UrbanPostcodeResponse out = this.urbanPostcodeResponseMapper.map(in);

        assertEquals(in.getPostcode(), out.getPostcode());
        assertEquals(in.getStreet(), out.getStreet());
        assertEquals(in.getTown(), out.getTown());
        assertEquals(in.getUrbanArea().getName(), out.getArea());
        assertEquals(in.getUrbanArea().getState().getCode(), out.getStateCode());
        assertEquals(in.getUrbanArea().getState().getName(), out.getStateName());
    }

}
