package com.elsynergy.nigerianpostcodes.model.response.geographyentities;

import com.elsynergy.nigerianpostcodes.model.response.BaseEntityResponse;

/**
*
* @author silver.ibenye
*
*/
public class PostOfficeFacilityResponse extends BaseEntityResponse
{
    private Integer postOfficeFacilityId;

    private String postOfficeFacilityName;

    private String facilityType;

    private String town;

    private String area;

    private String street;

    private Integer localGovernmentAreaId;

    private String localGovernmentAreaName;

    private String stateCode;

    private String stateName;

    private String postcode;

    private String rangeOfPOB;

    private String rangeOfPMB;

    public Integer getPostOfficeFacilityId()
    {
        return this.postOfficeFacilityId;
    }

    public void setPostOfficeFacilityId(final Integer postOfficeFacilityId)
    {
        this.postOfficeFacilityId = postOfficeFacilityId;
    }

    public String getPostOfficeFacilityName()
    {
        return this.postOfficeFacilityName;
    }

    public void setPostOfficeFacilityName(final String postOfficeFacilityName)
    {
        this.postOfficeFacilityName = postOfficeFacilityName;
    }

    public String getFacilityType()
    {
        return this.facilityType;
    }

    public void setFacilityType(final String facilityType)
    {
        this.facilityType = facilityType;
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

    public String getTown()
    {
        return this.town;
    }

    public void setTown(final String town)
    {
        this.town = town;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(final String area)
    {
        this.area = area;
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

    public String getRangeOfPOB()
    {
        return this.rangeOfPOB;
    }

    public void setRangeOfPOB(final String rangeOfPOB)
    {
        this.rangeOfPOB = rangeOfPOB;
    }

    public String getRangeOfPMB()
    {
        return this.rangeOfPMB;
    }

    public void setRangeOfPMB(final String rangeOfPMB)
    {
        this.rangeOfPMB = rangeOfPMB;
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
