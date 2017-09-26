package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.StateResponse;

/**
 * Maps State to StateResponse
 * @author silver.ibenye
 *
 */
@Component
public class StateResponseMapper implements IResponseMapper<State, StateResponse>
{

    @Override
    public StateResponse map(final State toMap)
    {
        final StateResponse stateResponse = new StateResponse();
        stateResponse.setStateId(toMap.getId());
        stateResponse.setStateCode(toMap.getCode());
        stateResponse.setStateName(toMap.getName());
        stateResponse.setStateCapital(toMap.getCapital());
        stateResponse.setStateRegion(toMap.getRegion());
        return stateResponse;
    }

}
