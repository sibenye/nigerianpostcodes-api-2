package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanStreet;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanStreetResponse;

/**
 * Maps UrbanStreet to UrbanStreetResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class UrbanStreetResponseMapper implements IResponseMapper<UrbanStreet, UrbanStreetResponse>
{

    @Override
    public UrbanStreetResponse map(final UrbanStreet toMap)
    {
        final UrbanStreetResponse urbanStreetResponse = new UrbanStreetResponse();
        urbanStreetResponse.setUrbanStreetId(toMap.getId());
        urbanStreetResponse.setUrbanStreetName(toMap.getStreet());
        urbanStreetResponse.setUrbanAreaId(toMap.getUrbanArea().getId());
        urbanStreetResponse.setUrbanAreaName(toMap.getUrbanArea().getName());
        urbanStreetResponse.setUrbanTownName(toMap.getUrbanArea().getUrbanTown().getName());
        urbanStreetResponse.setStateCode(toMap.getUrbanArea().getUrbanTown().getState().getCode());
        urbanStreetResponse.setStateName(toMap.getUrbanArea().getUrbanTown().getState().getName());
        return urbanStreetResponse;
    }

}
