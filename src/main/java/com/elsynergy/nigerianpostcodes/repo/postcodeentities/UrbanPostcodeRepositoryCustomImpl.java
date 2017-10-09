package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
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
                            "ut.id AS urbanTownId, " +
                            "ut.name AS town, " +
                            "ua.id AS urbanAreaId, " +
                            "ua.name AS area, " +
                            "us.id, " +
                            "us.name AS street, " +
                            "ua.postcode " +
                        "FROM " +
                            "urban_streets us " +
                        "INNER JOIN " +
                            "urban_areas ua ON us.urbanAreaId = ua.id " +
                        "INNER JOIN " +
                            "urban_towns ut ON ua.urbanTownId = ut.id " +
                        "INNER JOIN " +
                            "states s ON ut.stateId = s.id " +
                        "WHERE " +
                            "s.code = ? " +
                        "AND " +
                            "ut.name = COALESCE(?, ut.name) " +
                        "AND " +
                            "ua.name = COALESCE(?, ua.name) " +
                        "AND " +
                            "us.name = COALESCE(?, us.name)";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { stateCode, town, area, street }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
                    final UrbanTown urbanTown = new UrbanTown();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanTown.setId(rs.getInt("urbanTownId"));
            urbanTown.setName(rs.getString("town"));
            urbanTown.setState(state);

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setPostcode(rs.getString("postcode"));
            urbanArea.setUrbanTown(urbanTown);

            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setStreet(rs.getString("street"));
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
                "ut.id AS urbanTownId, " +
                "ut.name AS town, " +
                "ua.id AS urbanAreaId, " +
                "ua.name AS area, " +
                "us.id, " +
                "us.name AS street, " +
                "ua.postcode " +
            "FROM " +
                "urban_streets us " +
            "INNER JOIN " +
                "urban_areas ua ON us.urbanAreaId = ua.id " +
            "INNER JOIN " +
                "urban_towns ut ON ua.urbanTownId = ut.id " +
            "INNER JOIN " +
                "states s ON ut.stateId = s.id " +
            "WHERE " +
                "s.code = ? " +
            "AND " +
                "ut.name = ? " +
            "AND " +
                "us.name LIKE ? " +
            "ORDER BY " +
                "us.name";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        final String formattedHint = "%" + hint + "%";

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { stateCode, town, formattedHint }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
                    final UrbanTown urbanTown = new UrbanTown();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanTown.setId(rs.getInt("urbanTownId"));
            urbanTown.setName(rs.getString("town"));
            urbanTown.setState(state);

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setPostcode(rs.getString("postcode"));
            urbanArea.setUrbanTown(urbanTown);

            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setStreet(rs.getString("street"));
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
                "ut.id AS urbanTownId, " +
                "ut.name AS town, " +
                "ua.id AS urbanAreaId, " +
                "ua.name AS area, " +
                "us.id, " +
                "us.name AS street, " +
                "ua.postcode " +
            "FROM " +
                "urban_streets us " +
            "INNER JOIN " +
                "urban_areas ua ON us.urbanAreaId = ua.id " +
            "INNER JOIN " +
                "urban_towns ut ON ua.urbanTownId = ut.id " +
            "INNER JOIN " +
                "states s ON ut.stateId = s.id " +
            "WHERE " +
                "ua.postcode = ? ";

        List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        urbanPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { postcode }, (rs, rowNum) -> {
                    final UrbanPostcode urbanPostcode = new UrbanPostcode();
                    final UrbanTown urbanTown = new UrbanTown();
            final UrbanArea urbanArea = new UrbanArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            urbanTown.setId(rs.getInt("urbanTownId"));
            urbanTown.setName(rs.getString("town"));
            urbanTown.setState(state);

            urbanArea.setId(rs.getInt("urbanAreaId"));
            urbanArea.setName(rs.getString("area"));
            urbanArea.setPostcode(rs.getString("postcode"));
            urbanArea.setUrbanTown(urbanTown);

            urbanPostcode.setId(rs.getInt("id"));
            urbanPostcode.setStreet(rs.getString("street"));
            urbanPostcode.setUrbanArea(urbanArea);

            return urbanPostcode;
        });

        return urbanPostcodes;
    }

}
