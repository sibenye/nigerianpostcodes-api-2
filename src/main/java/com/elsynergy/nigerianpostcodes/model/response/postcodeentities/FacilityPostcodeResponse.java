package com.elsynergy.nigerianpostcodes.model.response.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class FacilityPostcodeResponse extends BaseEntityResponse
{
    private String facilityName;

    private String localGovernmentAreaName;

    private String stateCode;

    private String stateName;

    private String postcode;

    public String getFacilityName()
    {
        return this.facilityName;
    }

    public void setFacilityName(final String facilityName)
    {
        this.facilityName = facilityName;
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
