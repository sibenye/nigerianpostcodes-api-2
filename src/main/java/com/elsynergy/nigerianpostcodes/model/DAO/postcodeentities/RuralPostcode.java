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

    private String ruralVillageName;

    private RuralArea ruralArea;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getRuralVillageName()
    {
        return this.ruralVillageName;
    }

    public void setRuralVillageName(final String ruralVillageName)
    {
        this.ruralVillageName = ruralVillageName;
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
