package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.RuralPostcodeResponse;

/**
 * Maps RuralPostcode to RuralPostcodeResponse;
 *
 * @author silver.ibenye
 *
 */
@Component
public class RuralPostcodeResponseMapper implements IResponseMapper<RuralPostcode, RuralPostcodeResponse>
{

    @Override
    public RuralPostcodeResponse map(final RuralPostcode toMap)
    {
        final RuralPostcodeResponse out = new RuralPostcodeResponse();
        out.setRuralAreaName(toMap.getRuralArea().getName());
        out.setRuralVillageName(toMap.getRuralVillageName());
        out.setPostcode(toMap.getRuralArea().getPostcode());
        out.setLocalGovernmentAreaName(toMap.getRuralArea().getLocalGovernmentArea().getName());
        out.setStateCode(toMap.getRuralArea().getLocalGovernmentArea().getState().getCode());
        out.setStateName(toMap.getRuralArea().getLocalGovernmentArea().getState().getName());
        return out;
    }

}
