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
        out.setArea(toMap.getArea());
        out.setPostcode(toMap.getPostcode());
        out.setStreet(toMap.getStreet());
        out.setTown(toMap.getTown());
        out.setStateCode(toMap.getState().getCode());
        out.setStateName(toMap.getState().getName());
        return out;
    }

}
