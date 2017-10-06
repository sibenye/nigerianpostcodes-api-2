package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class UrbanStreetGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "Urban Area id")
    private Integer urbanAreaId;

    @ApiParam(value = "Urban Street id")
    private Integer urbanStreetId;

    public Integer getUrbanAreaId()
    {
        return this.urbanAreaId;
    }

    public void setUrbanAreaId(final Integer urbanAreaId)
    {
        this.urbanAreaId = urbanAreaId;
    }

    public Integer getUrbanStreetId()
    {
        return this.urbanStreetId;
    }

    public void setUrbanStreetId(final Integer urbanStreetId)
    {
        this.urbanStreetId = urbanStreetId;
    }

}
