package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.FacilityPostcode;

/**
 *
 * @author silver.ibenye
 *
 */
@Repository
public interface FacilityPostcodeRepositoryCustom
{
    public List<FacilityPostcode> getFacilityPostcodes(String stateCode,String localGovtAreaName, String facilityName);

    public List<FacilityPostcode> reverseLookup(String postcode);

}
