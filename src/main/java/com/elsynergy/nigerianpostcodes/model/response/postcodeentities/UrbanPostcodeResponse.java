package com.elsynergy.nigerianpostcodes.model.response.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class UrbanPostcodeResponse extends BaseEntityResponse
{
    private String urbanStreetName;

    private String urbanAreaName;

    private String urbanTownName;

    private String stateCode;

    private String stateName;

    private String postcode;

    public String getUrbanStreetName()
    {
        return this.urbanStreetName;
    }

    public void setUrbanStreetName(final String urbanStreetName)
    {
        this.urbanStreetName = urbanStreetName;
    }

    public String getUrbanAreaName()
    {
        return this.urbanAreaName;
    }

    public void setUrbanAreaName(final String urbanAreaName)
    {
        this.urbanAreaName = urbanAreaName;
    }

    public String getUrbanTownName()
    {
        return this.urbanTownName;
    }

    public void setUrbanTownName(final String urbanTownName)
    {
        this.urbanTownName = urbanTownName;
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
