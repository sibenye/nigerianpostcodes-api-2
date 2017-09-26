package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.FacilityPostcode;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.FacilityPostcodeResponse;

/**
 * Maps FacilityPostcode to FacilityPostcodeResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class FacilityPostcodeResponseMapper implements IResponseMapper<FacilityPostcode, FacilityPostcodeResponse>
{

    @Override
    public FacilityPostcodeResponse map(final FacilityPostcode toMap)
    {
        final FacilityPostcodeResponse out = new FacilityPostcodeResponse();
        out.setFacilityName(toMap.getFacility());
        out.setPostcode(toMap.getPostcode());
        out.setTown(toMap.getTown());
        out.setLocalGovernmentAreaName(toMap.getLocalGovernmentArea().getName());
        out.setStateCode(toMap.getLocalGovernmentArea().getState().getCode());
        out.setStateName(toMap.getLocalGovernmentArea().getState().getName());
        return out;
    }

}
