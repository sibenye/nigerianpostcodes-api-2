package com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;

/**
*
* @author silver.ibenye
*
*/
public class FacilityPostcode
{
    private Integer id;

    private String facilityName;

    private String postcode;

    private String townName;

    private LocalGovernmentArea localGovernmentArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getFacilityName()
    {
        return this.facilityName;
    }

    public void setFacilityName(final String facilityName)
    {
        this.facilityName = facilityName;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

    public String getTownName()
    {
        return this.townName;
    }

    public void setTownName(final String townName)
    {
        this.townName = townName;
    }

    public LocalGovernmentArea getLocalGovernmentArea()
    {
        return this.localGovernmentArea;
    }

    public void setLocalGovernmentArea(final LocalGovernmentArea localGovernmentArea)
    {
        this.localGovernmentArea = localGovernmentArea;
    }

}
