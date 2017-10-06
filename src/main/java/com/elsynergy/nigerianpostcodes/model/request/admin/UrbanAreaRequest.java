package com.elsynergy.nigerianpostcodes.model.request.admin;

public class UrbanAreaRequest extends GeographyPostRequest
{
    private Integer urbanAreaId;

    private String urbanAreaName;

    private String urbanTownName;

    private String stateCode;

    public Integer getUrbanAreaId()
    {
        return urbanAreaId;
    }

    public void setUrbanAreaId(Integer urbanAreaId)
    {
        this.urbanAreaId = urbanAreaId;
    }

    public String getUrbanAreaName()
    {
        return urbanAreaName;
    }

    public void setUrbanAreaName(String urbanAreaName)
    {
        this.urbanAreaName = urbanAreaName;
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

}
