package com.elsynergy.nigerianpostcodes.model.request.admin;

/**
 *
 * @author silver.ibenye
 *
 */
public class RuralAreaRequest extends GeographyPostRequest
{
    private Integer ruralAreaId;

    private String ruralAreaName;

    private Integer lgaId;

    private String postcode;

    public Integer getRuralAreaId()
    {
        return this.ruralAreaId;
    }

    public void setRuralAreaId(final Integer ruralAreaId)
    {
        this.ruralAreaId = ruralAreaId;
    }

    public String getRuralAreaName()
    {
        return this.ruralAreaName;
    }

    public void setRuralAreaName(final String ruralAreaName)
    {
        this.ruralAreaName = ruralAreaName;
    }

    public Integer getLgaId()
    {
        return this.lgaId;
    }

    public void setLgaId(final Integer lgaId)
    {
        this.lgaId = lgaId;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

}
