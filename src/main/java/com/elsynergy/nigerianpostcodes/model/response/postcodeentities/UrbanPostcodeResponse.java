package com.elsynergy.nigerianpostcodes.model.response.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

public class UrbanPostcodeResponse extends BaseEntityResponse
{
    private String street;

    private String area;

    private String town;

    private String stateCode;

    private String stateName;

    private String postcode;

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(final String area)
    {
        this.area = area;
    }

    public String getTown()
    {
        return this.town;
    }

    public void setTown(final String town)
    {
        this.town = town;
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
