package com.elsynergy.nigerianpostcodes.model.request.admin;

public class UrbanTownRequest extends GeographyRequest
{
    private Integer urbanTownId;

    private String urbanTownName;

    private String stateCode;

    public Integer getUrbanTownId()
    {
        return this.urbanTownId;
    }

    public void setUrbanTownId(final Integer urbanTownId)
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

}
