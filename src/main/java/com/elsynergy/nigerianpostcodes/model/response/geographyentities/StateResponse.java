package com.elsynergy.nigerianpostcodes.model.response.geographyentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class StateResponse extends BaseEntityResponse
{
    private Integer stateId;

    private String stateCode;

    private String stateName;

    private String stateCapital;

    private Integer stateRegion;

    public Integer getStateId()
    {
        return this.stateId;
    }

    public void setStateId(final Integer stateId)
    {
        this.stateId = stateId;
    }

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getStateName()
    {
        return this.stateName;
    }

    public void setStateName(final String stateName)
    {
        this.stateName = stateName;
    }

    public String getStateCapital()
    {
        return this.stateCapital;
    }

    public void setStateCapital(final String stateCapital)
    {
        this.stateCapital = stateCapital;
    }

    public Integer getStateRegion()
    {
        return this.stateRegion;
    }

    public void setStateRegion(final Integer stateRegion)
    {
        this.stateRegion = stateRegion;
    }

}
