package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.UrbanAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanAreaResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UrbanAreaResponseMapperTest
{
    @InjectMocks
    private UrbanAreaResponseMapper urbanAreaResponseMapper;

    @Test
    public void testMap()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final UrbanTown urbanTown = new UrbanTown();
        urbanTown.setName("testTown");
        urbanTown.setState(state);

        final UrbanArea in = new UrbanArea();
        in.setName("testArea");
        in.setUrbanTown(urbanTown);

        final UrbanAreaResponse out = this.urbanAreaResponseMapper.map(in);

        assertEquals(in.getName(), out.getUrbanAreaName());
        assertEquals(in.getUrbanTown().getName(), out.getUrbanTownName());
        assertEquals(in.getUrbanTown().getState().getCode(), out.getStateCode());
        assertEquals(in.getUrbanTown().getState().getName(), out.getStateName());
    }

}
