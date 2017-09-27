package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralAreaResponse;

/**
 * Maps RuralArea to RuralAreaResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class RuralAreaResponseMapper implements IResponseMapper<RuralArea, RuralAreaResponse>
{

    @Override
    public RuralAreaResponse map(final RuralArea toMap)
    {
        final RuralAreaResponse ruralAreaResponse = new RuralAreaResponse();
        ruralAreaResponse.setRuralAreaId(toMap.getId());
        ruralAreaResponse.setRuralAreaName(toMap.getName());
        ruralAreaResponse.setPostcode(toMap.getPostcode());
        ruralAreaResponse.setLocalGovernmentAreaId(toMap.getLocalGovernmentArea().getId());
        ruralAreaResponse.setLocalGovernmentAreaName(toMap.getLocalGovernmentArea().getName());
        ruralAreaResponse.setStateCode(toMap.getLocalGovernmentArea().getState().getCode());
        ruralAreaResponse.setStateName(toMap.getLocalGovernmentArea().getState().getName());
        return ruralAreaResponse;
    }

}
