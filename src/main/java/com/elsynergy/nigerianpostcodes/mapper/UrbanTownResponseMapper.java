package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanTownResponse;

/**
 * Maps UrbanTown to UrbanTownResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class UrbanTownResponseMapper implements IResponseMapper<UrbanTown, UrbanTownResponse>
{

    @Override
    public UrbanTownResponse map(final UrbanTown toMap)
    {
        final UrbanTownResponse urbanTownResponse = new UrbanTownResponse();
        urbanTownResponse.setUrbanTownName(toMap.getName());
        urbanTownResponse.setStateCode(toMap.getState().getCode());
        urbanTownResponse.setStateName(toMap.getState().getName());
        return urbanTownResponse;
    }

}
