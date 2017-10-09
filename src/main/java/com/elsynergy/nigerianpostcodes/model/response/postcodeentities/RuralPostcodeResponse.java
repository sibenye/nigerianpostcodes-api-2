package com.elsynergy.nigerianpostcodes.model.response.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class RuralPostcodeResponse extends BaseEntityResponse
{
    private String town;

    private String district;

    private String localGovernmentAreaName;

    private String stateCode;

    private String stateName;

    private String postcode;

    public String getTown()
    {
        return this.town;
    }

    public void setTown(final String town)
    {
        this.town = town;
    }

    public String getDistrict()
    {
        return this.district;
    }

    public void setDistrict(final String district)
    {
        this.district = district;
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
