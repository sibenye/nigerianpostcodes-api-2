package com.elsynergy.nigerianpostcodes.repo.geographyentities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;

/**
 *
 * @author silver.ibenye
 *
 */
public interface StateRepository extends CrudRepository<State, Integer>
{
    Optional<State> findOneByCode(String stateCode);

    Optional<State> findOneByName(String stateName);
}
