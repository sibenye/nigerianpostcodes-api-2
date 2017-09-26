package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author silver.ibenye
 *
 */
@Repository
public class PostcodeRepositoryCustomImpl implements PostcodeRepositoryCustom
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getPostcodeType(final String postcode)
    {
        final String query = "SELECT " +
                "DISTINCT postcode, " +
                "'rural' AS type " +
            "FROM " +
                "rural_areas " +
            "WHERE " +
                "postcode = ? " +
            "UNION ALL " +
            "SELECT " +
                "DISTINCT postcode, " +
                "'urban' AS type " +
            "FROM " +
                "urban_areas " +
            "WHERE " +
                "postcode = ? " +
            "UNION ALL " +
            "SELECT " +
                "DISTINCT postcode,  " +
                "'facility' AS type " +
            "FROM " +
                "facilities " +
            "WHERE " +
                "postcode = ?";

        List<String> types = new ArrayList<>();

        types = this.jdbcTemplate.query(
                query,
                new Object[] { postcode, postcode, postcode }, (result, rowNum) -> {

            final String type = result.getString("type");

            return type;
        });
        return types.size() > 0 ? types.get(0) : null;
    }

}
