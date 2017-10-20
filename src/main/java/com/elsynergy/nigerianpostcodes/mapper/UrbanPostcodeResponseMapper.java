package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.UrbanPostcodeResponse;

/**
 * Maps UrbanPostcode to UrbanPostcodeResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class UrbanPostcodeResponseMapper implements IResponseMapper<UrbanPostcode, UrbanPostcodeResponse>
{

    @Override
    public UrbanPostcodeResponse map(final UrbanPostcode toMap)
    {
        final UrbanPostcodeResponse out = new UrbanPostcodeResponse();
        out.setUrbanAreaName(toMap.getUrbanArea().getName());
        out.setPostcode(toMap.getUrbanArea().getPostcode());
        out.setUrbanStreetName(toMap.getUrbanStreetName());
        out.setUrbanTownName(toMap.getUrbanArea().getUrbanTown().getName());
        out.setStateCode(toMap.getUrbanArea().getUrbanTown().getState().getCode());
        out.setStateName(toMap.getUrbanArea().getUrbanTown().getState().getName());
        return out;
    }

}
