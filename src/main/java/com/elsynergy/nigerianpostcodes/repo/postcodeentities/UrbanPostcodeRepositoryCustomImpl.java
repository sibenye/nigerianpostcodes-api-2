package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;

/**
 *
 * @author silver.ibenye
 *
 */
@Repository
public class UrbanPostcodeRepositoryCustomImpl implements UrbanPostcodeRepositoryCustom
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UrbanPostcode> getUrbanPostcodes(final String stateCode, final String town, final String area, final String street)
    {
        final String query = "SELECT " +
                            "s.id AS stateId, " +
                            "s.name AS stateName, " +
                            "s.code AS stateCode, " +
                            "ua.id AS urbanAreaId, " +
                            "ua.name AS area, " +
                            "up.id, " +
                            "up.town, " +
                            "up.street, " +
                            "up.postcode " +
                        "FROM " +
                            "urban_postcodes up " +
                        "INNER JOIN " +
                            "urban_areas ua ON up.urbanAreaId = ua.id " +
                        "INNER JOIN " +
                            "states s ON ua.stateId = s.id " +
                        "WHERE " +
                            "s.code = ? " +
                        "AND " +
                            "up.town = COALESCE(?, up.town) " +
                        "AND " +
                            "ua.name = COALESCE(?, ua.name) " +
                        "AND " +
                            "up.street = COALESCE(?, up.street)";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { stateCode, town, area, street }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setState(state);


            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setTown(rs.getString("town"));
            urbanPostcode.setStreet(rs.getString("street"));
            urbanPostcode.setPostcode(rs.getString("postcode"));
            urbanPostcode.setState(state);
            urbanPostcode.setUrbanArea(urbanArea);

            return urbanPostcode;
        });

        return urbanPostcodes;
    }

    @Override
    public List<UrbanPostcode> searchUrbanPostcodes(final String stateCode, final String town, final String hint)
    {
        final String query = "SELECT " +
                "s.id AS stateId, " +
                "s.name AS stateName, " +
                "s.code AS stateCode, " +
                "ua.id AS urbanAreaId, " +
                "ua.name AS area, " +
                "up.id, " +
                "up.town, " +
                "up.street, " +
                "up.postcode " +
            "FROM " +
                "urban_postcodes up " +
            "INNER JOIN " +
                "urban_areas ua ON up.urbanAreaId = ua.id " +
            "INNER JOIN " +
                "states s ON ua.stateId = s.id " +
            "WHERE " +
                "s.code = ? " +
            "AND " +
                "up.town = ? " +
            "AND " +
                "up.street LIKE ? " +
            "ORDER BY " +
                "up.street";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        final String formattedHint = "%" + hint + "%";

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { stateCode, town, formattedHint }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setState(state);

            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setTown(rs.getString("town"));
            urbanPostcode.setStreet(rs.getString("street"));
            urbanPostcode.setPostcode(rs.getString("postcode"));
            urbanPostcode.setUrbanArea(urbanArea);

            return urbanPostcode;
        });

        return urbanPostcodes;

    }

    @Override
    public List<UrbanPostcode> reverseLookup(final String postcode)
    {
        final String query = "SELECT " +
                "s.id AS stateId, " +
                "s.name AS stateName, " +
                "s.code AS stateCode, " +
                "ua.id AS urbanAreaId, " +
                "ua.name AS area, " +
                "up.id, " +
                "up.town, " +
                "up.street, " +
                "up.postcode " +
            "FROM " +
                "urban_postcodes up " +
            "INNER JOIN " +
                "urban_areas ua ON up.urbanAreaId = ua.id " +
            "INNER JOIN " +
                "states s ON ua.stateId = s.id " +
            "WHERE " +
                "up.postcode = ? ";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { postcode }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setState(state);

            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setTown(rs.getString("town"));
            urbanPostcode.setStreet(rs.getString("street"));
            urbanPostcode.setPostcode(rs.getString("postcode"));
            urbanPostcode.setUrbanArea(urbanArea);

            return urbanPostcode;
        });

        return urbanPostcodes;
    }

}
