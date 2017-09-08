package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;

/**
*
* @author silver.ibenye
*
*/
public interface RuralAreaRepository extends CrudRepository<RuralArea, Integer>
{
    public List<RuralArea> findByLocalGovernmentAreaStateCode(String stateCode);

    public List<RuralArea> findByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaName(String stateCode, String localGovernmentAreaName);

    public List<RuralArea> findByLocalGovernmentAreaStateCodeAndName(String stateCode, String ruralAreaName);

    public List<RuralArea> findByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaNameAndName(String stateCode, String localGovernmentAreaName, String name);

}
