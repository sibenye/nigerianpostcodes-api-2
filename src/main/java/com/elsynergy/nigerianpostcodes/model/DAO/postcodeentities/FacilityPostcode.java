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

    private String facility;

    private String postcode;

    private String town;

    private LocalGovernmentArea localGovernmentArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getFacility()
    {
        return this.facility;
    }

    public void setFacility(final String facility)
    {
        this.facility = facility;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

    public String getTown()
    {
        return this.town;
    }

    public void setTown(final String town)
    {
        this.town = town;
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
