package com.elsynergy.nigerianpostcodes.model.response.geographyentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class UrbanStreetResponse extends BaseEntityResponse
{
    private Integer urbanStreetId;

    private String urbanStreetName;

    private Integer urbanAreaId;

    private String urbanAreaName;

    private String urbanTownName;

    private String stateCode;

    private String stateName;

    public Integer getUrbanStreetId()
    {
        return urbanStreetId;
    }

    public void setUrbanStreetId(Integer urbanStreetId)
    {
        this.urbanStreetId = urbanStreetId;
    }

    public String getUrbanStreetName()
    {
        return urbanStreetName;
    }

    public void setUrbanStreetName(String urbanStreetName)
    {
        this.urbanStreetName = urbanStreetName;
    }

    public Integer getUrbanAreaId()
    {
        return urbanAreaId;
    }

    public void setUrbanAreaId(Integer ruralAreaId)
    {
        this.urbanAreaId = ruralAreaId;
    }

    public String getUrbanAreaName()
    {
        return urbanAreaName;
    }

    public void setUrbanAreaName(String ruralAreaName)
    {
        this.urbanAreaName = ruralAreaName;
    }

    public String getUrbanTownName()
    {
        return urbanTownName;
    }

    public void setUrbanTownName(String urbanTownName)
    {
        this.urbanTownName = urbanTownName;
    }

    public String getStateCode()
    {
        return stateCode;
    }

    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getStateName()
    {
        return stateName;
    }

    public void setStateName(String stateName)
    {
        this.stateName = stateName;
    }



}
