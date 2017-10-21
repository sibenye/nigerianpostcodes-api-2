package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

/**
 *
 * @author silver.ibenye
 *
 */
public class UrbanPostcodeRequest extends PostcodeRequest
{
    @ApiParam(value = "Urban Town Name.")
    private String urbaTownName;

    @ApiParam(value = "Urban Area Name.")
    private String urbanAreaName;

    @ApiParam(value = "Urban Street Name.")
    private String urbanStreetName;

    public String getUrbanTownName()
    {
        return this.urbaTownName;
    }

    public void setUrbanTownName(final String urbanTownName)
    {
        this.urbaTownName = urbanTownName;
    }

    public String getUrbanAreaName()
    {
        return this.urbanAreaName;
    }

    public void setUrbanAreaName(final String urbanAreaName)
    {
        this.urbanAreaName = urbanAreaName;
    }

    public String getUrbanStreetName()
    {
        return this.urbanStreetName;
    }

    public void setUrbanStreetName(final String urbanStreetName)
    {
        this.urbanStreetName = urbanStreetName;
    }
}
