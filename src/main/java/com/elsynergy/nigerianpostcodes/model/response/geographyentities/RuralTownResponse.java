package com.elsynergy.nigerianpostcodes.model.response.geographyentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class RuralTownResponse extends BaseEntityResponse
{
    private Integer ruralTownId;

    private String ruralTownName;

    private Integer ruralAreaId;

    private String ruralAreaName;

    private Integer localGovernmentAreaId;

    private String localGovernmentAreaName;

    private String stateCode;

    private String stateName;

    public Integer getRuralTownId()
    {
        return this.ruralTownId;
    }

    public void setRuralTownId(final Integer ruralTownId)
    {
        this.ruralTownId = ruralTownId;
    }

    public String getRuralTownName()
    {
        return this.ruralTownName;
    }

    public void setRuralTownName(final String ruralTownName)
    {
        this.ruralTownName = ruralTownName;
    }

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

    public Integer getLocalGovernmentAreaId()
    {
        return this.localGovernmentAreaId;
    }

    public void setLocalGovernmentAreaId(final Integer localGovernmentAreaId)
    {
        this.localGovernmentAreaId = localGovernmentAreaId;
    }

    public String getLocalGovernmentAreaName()
    {
        return this.localGovernmentAreaName;
    }

    public void setLocalGovernmentAreaName(final String localGovernmentAreaName)
    {
        this.localGovernmentAreaName = localGovernmentAreaName;
    }

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getStateName()
    {
        return this.stateName;
    }

    public void setStateName(final String stateName)
    {
        this.stateName = stateName;
    }
}
