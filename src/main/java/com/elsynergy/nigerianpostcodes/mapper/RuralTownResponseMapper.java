package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralTown;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralTownResponse;

/**
 * Maps RuralTown to RuralTownResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class RuralTownResponseMapper implements IResponseMapper<RuralTown, RuralTownResponse>
{

    @Override
    public RuralTownResponse map(final RuralTown toMap)
    {
        final RuralTownResponse ruralTownResponse = new RuralTownResponse();
        ruralTownResponse.setRuralTownId(toMap.getId());
        ruralTownResponse.setRuralTownName(toMap.getTown());
        ruralTownResponse.setRuralAreaId(toMap.getRuralArea().getId());
        ruralTownResponse.setRuralAreaName(toMap.getRuralArea().getName());
        ruralTownResponse.setLocalGovernmentAreaId(toMap.getRuralArea().getLocalGovernmentArea().getId());
        ruralTownResponse.setLocalGovernmentAreaName(toMap.getRuralArea().getLocalGovernmentArea().getName());
        ruralTownResponse.setStateCode(toMap.getRuralArea().getLocalGovernmentArea().getState().getCode());
        ruralTownResponse.setStateName(toMap.getRuralArea().getLocalGovernmentArea().getState().getName());
        return ruralTownResponse;
    }

}
