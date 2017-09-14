package com.elsynergy.nigerianpostcodes.model.request.admin;

/**
 *
 * @author silver.ibenye
 *
 */
public class LocalGovernmentAreaRequest extends GeographyRequest
{
    private Integer lgaId;

    private String lgaName;

    private String stateCode;

    public Integer getLgaId()
    {
        return this.lgaId;
    }

    public void setLgaId(final Integer lgaId)
    {
        this.lgaId = lgaId;
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
