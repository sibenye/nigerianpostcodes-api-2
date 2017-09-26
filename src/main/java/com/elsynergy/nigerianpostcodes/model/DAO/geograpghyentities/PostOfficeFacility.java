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
@Table(name = "facilities")
public class PostOfficeFacility extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "facility")
    private String facility;

    @Column(name = "type")
    private String type;

    @Column(name = "town")
    private String town;

    @Column(name = "area")
    private String area;

    @Column(name = "street")
    private String street;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "rangeofpob")
    private String rangeOfPOB;

    @Column(name = "rangeofpmb")
    private String rangeOfPMB;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @ManyToOne(optional=false)
    @JoinColumn(name="lgaid", nullable=false)
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

    public String getType()
    {
        return this.type;
    }

    public void setType(final String type)
    {
        this.type = type;
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

    public String getLatitude()
    {
        return this.latitude;
    }

    public void setLatitude(final String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return this.longitude;
    }

    public void setLongitude(final String longitude)
    {
        this.longitude = longitude;
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
