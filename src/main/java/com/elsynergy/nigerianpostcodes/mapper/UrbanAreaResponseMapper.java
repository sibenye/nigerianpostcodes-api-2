package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanAreaResponse;

/**
 * Maps UrbanArea to UrbanAreaResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class UrbanAreaResponseMapper implements IResponseMapper<UrbanArea, UrbanAreaResponse>
{

    @Override
    public UrbanAreaResponse map(final UrbanArea toMap)
    {
        final UrbanAreaResponse urbanAreaResponse = new UrbanAreaResponse();
        urbanAreaResponse.setUrbanAreaName(toMap.getName());
        urbanAreaResponse.setUrbanTownName(toMap.getUrbanTown().getName());;
        urbanAreaResponse.setStateCode(toMap.getUrbanTown().getState().getCode());
        urbanAreaResponse.setStateName(toMap.getUrbanTown().getState().getName());
        return urbanAreaResponse;
    }

}
