package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralVillage;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralVillageResponse;

/**
 * Maps RuralTown to RuralTownResponse.
 *
 * @author silver.ibenye
 *
 */
@Component
public class RuralVillageResponseMapper implements IResponseMapper<RuralVillage, RuralVillageResponse>
{

    @Override
    public RuralVillageResponse map(final RuralVillage toMap)
    {
        final RuralVillageResponse ruralTownResponse = new RuralVillageResponse();
        ruralTownResponse.setRuralVillageId(toMap.getId());
        ruralTownResponse.setRuralVillageName(toMap.getName());
        ruralTownResponse.setRuralAreaId(toMap.getRuralArea().getId());
        ruralTownResponse.setRuralAreaName(toMap.getRuralArea().getName());
        ruralTownResponse.setLocalGovernmentAreaId(toMap.getRuralArea().getLocalGovernmentArea().getId());
        ruralTownResponse.setLocalGovernmentAreaName(toMap.getRuralArea().getLocalGovernmentArea().getName());
        ruralTownResponse.setStateCode(toMap.getRuralArea().getLocalGovernmentArea().getState().getCode());
        ruralTownResponse.setStateName(toMap.getRuralArea().getLocalGovernmentArea().getState().getName());
        return ruralTownResponse;
    }

}
