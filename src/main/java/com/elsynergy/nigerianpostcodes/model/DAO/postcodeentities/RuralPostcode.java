package com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;

/**
*
* @author silver.ibenye
*
*/
public class RuralPostcode
{
    private Integer id;

    private String town;

    private RuralArea ruralArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getTown()
    {
        return this.town;
    }

    public void setTown(final String town)
    {
        this.town = town;
    }

    public RuralArea getRuralArea()
    {
        return this.ruralArea;
    }

    public void setRuralArea(final RuralArea ruralArea)
    {
        this.ruralArea = ruralArea;
    }

}
