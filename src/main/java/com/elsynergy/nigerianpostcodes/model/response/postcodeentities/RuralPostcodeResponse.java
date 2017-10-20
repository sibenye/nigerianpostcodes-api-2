package com.elsynergy.nigerianpostcodes.model.response.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class RuralPostcodeResponse extends BaseEntityResponse
{
    private String ruralVillageName;

    private String ruralAreaName;

    private String localGovernmentAreaName;

    private String stateCode;

    private String stateName;

    private String postcode;

    public String getRuralVillageName()
    {
        return this.ruralVillageName;
    }

    public void setRuralVillageName(final String ruralVillageName)
    {
        this.ruralVillageName = ruralVillageName;
    }

    public String getRuralAreaName()
    {
        return this.ruralAreaName;
    }

    public void setRuralAreaName(final String ruralAreaName)
    {
        this.ruralAreaName = ruralAreaName;
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

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

}
