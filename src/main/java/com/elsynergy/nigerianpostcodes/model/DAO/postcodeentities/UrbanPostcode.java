package com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;

/**
*
* @author silver.ibenye
*
*/
public class UrbanPostcode
{
    private Integer id;

    private String urbanStreetName;

    private UrbanArea urbanArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getUrbanStreetName()
    {
        return this.urbanStreetName;
    }

    public void setUrbanStreetName(final String street)
    {
        this.urbanStreetName = street;
    }

    public UrbanArea getUrbanArea()
    {
        return this.urbanArea;
    }

    public void setUrbanArea(final UrbanArea urbanArea)
    {
        this.urbanArea = urbanArea;
    }

}
