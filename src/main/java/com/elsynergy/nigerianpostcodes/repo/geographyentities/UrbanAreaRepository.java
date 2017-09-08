package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;

/**
*
* @author silver.ibenye
*
*/
public interface UrbanAreaRepository extends CrudRepository<UrbanArea, Integer>
{
    public List<UrbanArea> findByUrbanTownStateCode(String stateCode);

    public List<UrbanArea> findByUrbanTownStateCodeAndUrbanTownName(String stateCode, String urbanTownName);

    public List<UrbanArea> findByUrbanTownStateCodeAndName(String stateCode, String urbanAreaName);

    public List<UrbanArea> findByUrbanTownStateCodeAndUrbanTownNameAndName(String stateCode, String urbanTownName, String urbanAreaName);
}
