package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralTown;

/**
*
* @author silver.ibenye
*
*/
public interface RuralTownRepository extends CrudRepository<RuralTown, Integer>
{
    public List<RuralTown> findByRuralAreaId(Integer ruralAreaId);
}
