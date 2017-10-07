package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.PostOfficeFacility;

/**
*
* @author silver.ibenye
*
*/
public interface PostOfficeFacilityRepository extends CrudRepository<PostOfficeFacility, Integer>
{
    public List<PostOfficeFacility> findByLocalGovernmentAreaStateCode(String stateCode);

    public List<PostOfficeFacility> findByLocalGovernmentAreaId(Integer lgaId);

    public List<PostOfficeFacility> findByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaId(String stateCode, Integer localGovernmentAreaId);

}
