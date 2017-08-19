package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import org.springframework.stereotype.Repository;

/**
 *
 * @author silver.ibenye
 *
 */
@Repository
public interface PostcodeRepositoryCustom
{
    public String getPostcodeType(String postcode);

}
