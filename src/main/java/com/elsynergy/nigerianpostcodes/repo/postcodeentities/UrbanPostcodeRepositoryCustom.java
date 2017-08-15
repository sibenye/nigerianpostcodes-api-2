package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.List;

import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;

/**
 *
 * @author silver.ibenye
 *
 */
public interface UrbanPostcodeRepositoryCustom
{
    public List<UrbanPostcode> getUrbanPostcodes(String stateCode,String town, String area, String street);

    public List<UrbanPostcode> searchUrbanPostcodes(String stateCode, String town, String hint);

}
