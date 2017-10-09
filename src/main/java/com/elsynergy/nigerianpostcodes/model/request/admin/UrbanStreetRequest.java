package com.elsynergy.nigerianpostcodes.model.request.admin;

public class UrbanStreetRequest extends GeographyPostRequest
{
    private String urbanStreetName;

    private Integer urbanAreaId;

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

    public String getUrbanStreetName()
    {
        return urbanStreetName;
    }

    public void setUrbanStreetName(String urbanStreetName)
    {
        this.urbanStreetName = urbanStreetName;
    }

}
