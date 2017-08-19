package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.List;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;

/**
 *
 * @author silver.ibenye
 *
 */
public interface RuralPostcodeRepositoryCustom
{
    public List<RuralPostcode> getRuralPostcodes(String stateCode,String localGovtAreaName, String district, String town);

    public List<RuralPostcode> reverseLookup(String postcode);

}
