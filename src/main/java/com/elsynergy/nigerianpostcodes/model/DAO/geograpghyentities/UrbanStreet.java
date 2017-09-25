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
@Table(name = "urban_streets")
public class UrbanStreet extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "street")
    private String street;

    @ManyToOne(optional=false)
    @JoinColumn(name="urbanAreaId", nullable=false)
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
