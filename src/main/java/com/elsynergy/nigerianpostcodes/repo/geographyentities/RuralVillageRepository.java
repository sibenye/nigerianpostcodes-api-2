package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralVillage;

/**
*
* @author silver.ibenye
*
*/
public interface RuralVillageRepository extends CrudRepository<RuralVillage, Integer>
{
    public List<RuralVillage> findByRuralAreaId(Integer ruralAreaId);
}
