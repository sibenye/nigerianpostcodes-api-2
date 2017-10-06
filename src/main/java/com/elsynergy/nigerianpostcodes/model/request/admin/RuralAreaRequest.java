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

    private String lgaName;

    private String stateCode;

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

    public String getLgaName()
    {
        return this.lgaName;
    }

    public void setLgaName(final String lgaName)
    {
        this.lgaName = lgaName;
    }

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

}
