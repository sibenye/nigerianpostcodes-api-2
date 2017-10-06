package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class RuralTownGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "Rural Area id")
    private Integer ruralAreaId;

    @ApiParam(value = "Rural Town id")
    private Integer ruralTownId;

    public Integer getRuralAreaId()
    {
        return this.ruralAreaId;
    }

    public void setRuralAreaId(final Integer ruralAreaId)
    {
        this.ruralAreaId = ruralAreaId;
    }

    public Integer getRuralTownId()
    {
        return this.ruralTownId;
    }

    public void setRuralTownId(final Integer ruralTownId)
    {
        this.ruralTownId = ruralTownId;
    }

}
