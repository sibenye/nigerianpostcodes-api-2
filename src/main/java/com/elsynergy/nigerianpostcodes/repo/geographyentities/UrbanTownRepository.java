package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;

/**
*
* @author silver.ibenye
*
*/
public interface UrbanTownRepository extends CrudRepository<UrbanTown, Integer>
{
    public List<UrbanTown> findByStateCode(String stateCode);

    public List<UrbanTown> findByStateCodeAndName(String stateCode, String urbanTownName);
}
