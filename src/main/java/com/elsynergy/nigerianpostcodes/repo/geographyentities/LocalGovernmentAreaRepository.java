package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;

/**
 *
 * @author silver.ibenye
 *
 */
public interface LocalGovernmentAreaRepository extends CrudRepository<LocalGovernmentArea, Integer>
{
    Optional<LocalGovernmentArea> findOneByName(String localGovtAreaName);

    public List<LocalGovernmentArea> findByStateCode(String stateCode);

    public List<LocalGovernmentArea> findByStateCodeAndName(String stateCode, String localGovtAreaName);

    public List<LocalGovernmentArea> findByStateCodeAndId(String stateCode, Integer localGovtAreaId);

    public Optional<LocalGovernmentArea> findOneByStateCodeAndName(String stateCode, String localGovtAreaName);
}
