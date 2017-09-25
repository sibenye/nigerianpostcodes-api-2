package com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.elsynergy.nigerianpostcodes.model.DAO.accountentities.Audit;

/**
*
* @author silver.ibenye
*
*/
@Entity
@Table(name = "urban_areas")
public class UrbanArea extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional=false)
    @JoinColumn(name="urbantownid", nullable=false)
    private UrbanTown urbanTown;

    @Column(name = "postcode")
    private Integer postcode;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public UrbanTown getUrbanTown()
    {
        return this.urbanTown;
    }

    public void setUrbanTown(final UrbanTown urbanTown)
    {
        this.urbanTown = urbanTown;
    }

    public Integer getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final Integer postcode)
    {
        this.postcode = postcode;
    }


}
