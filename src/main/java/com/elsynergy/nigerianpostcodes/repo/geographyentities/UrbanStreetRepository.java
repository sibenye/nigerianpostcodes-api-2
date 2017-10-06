package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanStreet;

/**
 *
 * @author silver.ibenye
 *
 */
public interface UrbanStreetRepository extends CrudRepository<UrbanStreet, Integer>
{
    public List<UrbanStreet> findByUrbanAreaId(Integer urbanAreaId);

}
