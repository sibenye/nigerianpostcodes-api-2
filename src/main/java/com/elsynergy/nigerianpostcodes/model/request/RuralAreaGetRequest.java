package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class RuralAreaGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "Local Government Area id")
    private Integer lgaId;

    @ApiParam(value = "Rural Area id")
    private Integer ruralAreaId;

    public Integer getLgaId()
    {
        return this.lgaId;
    }

    public void setLgaId(final Integer lgaId)
    {
        this.lgaId = lgaId;
    }

    public Integer getRuralAreaId()
    {
        return this.ruralAreaId;
    }

    public void setRuralAreaId(final Integer ruralAreaId)
    {
        this.ruralAreaId = ruralAreaId;
    }

}
