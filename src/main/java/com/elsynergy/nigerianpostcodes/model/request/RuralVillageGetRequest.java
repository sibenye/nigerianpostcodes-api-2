package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class RuralVillageGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "Rural Area id")
    private Integer ruralAreaId;

    @ApiParam(value = "Rural Village id")
    private Integer ruralVillageId;

    public Integer getRuralAreaId()
    {
        return this.ruralAreaId;
    }

    public void setRuralAreaId(final Integer ruralAreaId)
    {
        this.ruralAreaId = ruralAreaId;
    }

    public Integer getRuralVillageId()
    {
        return this.ruralVillageId;
    }

    public void setRuralVillageId(final Integer ruralVillageId)
    {
        this.ruralVillageId = ruralVillageId;
    }

}
