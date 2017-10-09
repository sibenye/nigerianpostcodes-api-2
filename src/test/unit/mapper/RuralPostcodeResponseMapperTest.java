package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.RuralPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.RuralPostcodeResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RuralPostcodeResponseMapperTest
{
    @InjectMocks
    private RuralPostcodeResponseMapper ruralPostcodeResponseMapper;

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

        final RuralArea ruralArea = new RuralArea();
        ruralArea.setName("testDistrict");
        ruralArea.setPostcode("23444");
        ruralArea.setLocalGovernmentArea(localGovernmentArea);

        final RuralPostcode in = new RuralPostcode();
        in.setTown("testTown");
        in.setRuralArea(ruralArea);

        final RuralPostcodeResponse out = this.ruralPostcodeResponseMapper.map(in);

        assertEquals(in.getRuralArea().getPostcode(), out.getPostcode());
        assertEquals(in.getTown(), out.getTown());
        assertEquals(in.getRuralArea().getName(), out.getDistrict());
        assertEquals(in.getRuralArea().getLocalGovernmentArea().getName(), out.getLocalGovernmentAreaName());
        assertEquals(in.getRuralArea().getLocalGovernmentArea().getState().getCode(), out.getStateCode());
        assertEquals(in.getRuralArea().getLocalGovernmentArea().getState().getName(), out.getStateName());
    }

}
