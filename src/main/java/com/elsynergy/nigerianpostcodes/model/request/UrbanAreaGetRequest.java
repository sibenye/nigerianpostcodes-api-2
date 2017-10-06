package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class UrbanAreaGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "Urban Town id")
    private Integer urbanTownId;

    @ApiParam(value = "Urban Area id")
    private Integer urbanAreaId;

    public Integer getUrbanTownId()
    {
        return this.urbanTownId;
    }

    public void setUrbanTownId(final Integer urbanTownId)
    {
        this.urbanTownId = urbanTownId;
    }

    public Integer getUrbanAreaId()
    {
        return this.urbanAreaId;
    }

    public void setUrbanAreaId(final Integer urbanAreaId)
    {
        this.urbanAreaId = urbanAreaId;
    }

}
