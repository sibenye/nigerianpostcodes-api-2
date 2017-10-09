package com.elsynergy.nigerianpostcodes.model.request.admin;

public class UrbanAreaRequest extends GeographyPostRequest
{
    private Integer urbanAreaId;

    private String urbanAreaName;

    private Integer urbanTownId;

    private Integer postcode;

    public Integer getUrbanAreaId()
    {
        return this.urbanAreaId;
    }

    public void setUrbanAreaId(final Integer urbanAreaId)
    {
        this.urbanAreaId = urbanAreaId;
    }

    public String getUrbanAreaName()
    {
        return this.urbanAreaName;
    }

    public void setUrbanAreaName(final String urbanAreaName)
    {
        this.urbanAreaName = urbanAreaName;
    }

    public Integer getUrbanTownId()
    {
        return this.urbanTownId;
    }

    public void setUrbanTownId(final Integer urbanTownId)
    {
        this.urbanTownId = urbanTownId;
    }

    public Integer getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final Integer postcode)
    {
        this.postcode = postcode;
    }

}
