package com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author silver.ibenye
*
*/
@Entity
@Table(name = "states")
public class State
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy="state")
    private Set<LocalGovernmentArea> localGovernmentAreas;

    @Column(name = "capital")
    private String capital;

    @Column(name = "region")
    private Integer region;

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

    public String getCode()
    {
        return this.code;
    }

    public void setCode(final String code)
    {
        this.code = code;
    }

    public Set<LocalGovernmentArea> getLocalGovernmentAreas()
    {
        return this.localGovernmentAreas;
    }

    public void setLocalGovernmentAreas(final Set<LocalGovernmentArea> localGovernmentAreas)
    {
        this.localGovernmentAreas = localGovernmentAreas;
    }

    public String getCapital()
    {
        return this.capital;
    }

    public void setCapital(final String capital)
    {
        this.capital = capital;
    }

    public Integer getRegion()
    {
        return this.region;
    }

    public void setRegion(final Integer region)
    {
        this.region = region;
    }

}
