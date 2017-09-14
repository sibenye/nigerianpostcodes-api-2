package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.LocalGovernmentAreaResponse;

/**
 * Maps LocalGovernmentArea to LocalGovernmentAreaResponse
 * @author silver.ibenye
 *
 */
@Component
public class LocalGovernmentAreaResponseMapper implements IResponseMapper<LocalGovernmentArea, LocalGovernmentAreaResponse>
{

    @Override
    public LocalGovernmentAreaResponse map(final LocalGovernmentArea toMap)
    {
        final LocalGovernmentAreaResponse localGovernmentAreaResponse = new LocalGovernmentAreaResponse();
        localGovernmentAreaResponse.setLocalGovernmentAreaId(toMap.getId());
        localGovernmentAreaResponse.setLocalGovernmentAreaName(toMap.getName());
        localGovernmentAreaResponse.setStateCode(toMap.getState().getCode());
        localGovernmentAreaResponse.setStateName(toMap.getState().getName());
        return localGovernmentAreaResponse;
    }

}
