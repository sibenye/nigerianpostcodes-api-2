package com.elsynergy.nigerianpostcodes.model.request.admin;

public class RuralVillageRequest extends GeographyPostRequest
{
    private String ruralVillageName;

    private Integer ruralAreaId;

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

    public String getRuralVillageName()
    {
        return this.ruralVillageName;
    }

    public void setRuralVillageName(final String ruralVillageName)
    {
        this.ruralVillageName = ruralVillageName;
    }

}
