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

    private String street;

    private UrbanArea urbanArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
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
