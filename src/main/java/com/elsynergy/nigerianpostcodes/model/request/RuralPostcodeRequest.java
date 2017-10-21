package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

/**
 *
 * @author silver.ibenye
 *
 */
public class RuralPostcodeRequest extends PostcodeRequest
{
    @ApiParam(value = "Local Government Area Name.")
    private String localGovtAreaName;

    @ApiParam(value = "Rural Area Name.")
    private String ruralAreaName;

    @ApiParam(value = "Rural Village Name.")
    private String ruralVillageName;

    public String getLocalGovtAreaName()
    {
        return this.localGovtAreaName;
    }

    public void setLocalGovtAreaName(final String localGovtAreaName)
    {
        this.localGovtAreaName = localGovtAreaName;
    }

    public String getRuralAreaName()
    {
        return this.ruralAreaName;
    }

    public void setRuralAreaName(final String ruralAreaName)
    {
        this.ruralAreaName = ruralAreaName;
    }

    public String getRuralVillageName()
    {
        return this.ruralVillageName;
    }

    public void setRuralVillageName(final String ruralVillageName)
    {
        this.ruralVillageName = ruralVillageName;
    }
}
