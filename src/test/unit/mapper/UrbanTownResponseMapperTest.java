package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.UrbanTownResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanTownResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UrbanTownResponseMapperTest
{
    @InjectMocks
    private UrbanTownResponseMapper urbanTownResponseMapper;

    @Test
    public void testMap()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final UrbanTown in = new UrbanTown();
        in.setId(1);
        in.setName("testTown");
        in.setState(state);


        final UrbanTownResponse out = this.urbanTownResponseMapper.map(in);

        assertEquals(in.getId(), out.getUrbanTownId());
        assertEquals(in.getName(), out.getUrbanTownName());
        assertEquals(in.getState().getCode(), out.getStateCode());
        assertEquals(in.getState().getName(), out.getStateName());
    }

}
