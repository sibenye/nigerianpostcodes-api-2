package com.elsynergy.nigerianpostcodes.model.response.geographyentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class UrbanTownResponse extends BaseEntityResponse
{
    private Integer urbanTownId;

    private String urbanTownName;

    private String stateCode;

    private String stateName;

    public Integer getUrbanTownId()
    {
        return urbanTownId;
    }

    public void setUrbanTownId(Integer urbanTownId)
    {
        this.urbanTownId = urbanTownId;
    }

    public String getUrbanTownName()
    {
        return this.urbanTownName;
    }

    public void setUrbanTownName(final String urbanTownName)
    {
        this.urbanTownName = urbanTownName;
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

}
