package com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.elsynergy.nigerianpostcodes.model.DAO.accountentities.Audit;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;

/**
*
* @author silver.ibenye
*
*/
@Entity
@Table(name = "rural_postcodes")
public class RuralPostcode extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "town")
    private String town;

    @Column(name = "district")
    private String district;

    @Column(name = "postcode")
    private String postcode;

    @ManyToOne(optional=false)
    @JoinColumn(name="lgaid", nullable=false)
    private LocalGovernmentArea localGovernmentArea;

    @ManyToOne(optional=false)
    @JoinColumn(name="ruralAreaId", nullable=false)
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

    public String getDistrict()
    {
        return this.district;
    }

    public void setDistrict(final String district)
    {
        this.district = district;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

    public LocalGovernmentArea getLocalGovernmentArea()
    {
        return this.localGovernmentArea;
    }

    public void setLocalGovernmentArea(final LocalGovernmentArea localGovernmentArea)
    {
        this.localGovernmentArea = localGovernmentArea;
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
