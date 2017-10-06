package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class UrbanTownGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "State code")
    private String stateCode;

    @ApiParam(value = "Urban Town id")
    private Integer urbanTownId;

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public Integer getUrbanTownId()
    {
        return this.urbanTownId;
    }

    public void setUrbanTownId(final Integer urbanTownId)
    {
        this.urbanTownId = urbanTownId;
    }

}
