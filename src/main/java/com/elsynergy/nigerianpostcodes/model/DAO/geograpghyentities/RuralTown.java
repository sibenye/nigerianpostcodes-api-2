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
@Table(name = "rural_towns")
public class RuralTown extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "town")
    private String town;

    @ManyToOne(optional=false)
    @JoinColumn(name="ruralareaid", nullable=false)
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
