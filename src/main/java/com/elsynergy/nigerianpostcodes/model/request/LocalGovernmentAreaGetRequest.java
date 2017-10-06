package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class LocalGovernmentAreaGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "State code")
    private String stateCode;

    @ApiParam(value = "Local Government Area id")
    private Integer lgaId;

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public Integer getLgaId()
    {
        return this.lgaId;
    }

    public void setLgaId(final Integer lgaId)
    {
        this.lgaId = lgaId;
    }

}
