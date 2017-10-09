package com.elsynergy.nigerianpostcodes.repo.postcodeentities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;

/**
 *
 * @author silver.ibenye
 *
 */
@Repository
public class RuralPostcodeRepositoryCustomImpl implements RuralPostcodeRepositoryCustom
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RuralPostcode> getRuralPostcodes(final String stateCode, final String localGovtAreaName, final String district,
            final String town)
    {
        final String query = "SELECT " +
                                "s.id AS stateId, " +
                                "s.name AS stateName, " +
                                "s.code AS stateCode, " +
                                "l.id AS lgaId, " +
                                "l.name AS lgaName, " +
                                "ra.id AS ruralAreaId, " +
                                "ra.name AS district, " +
                                "rv.id, " +
                                "rv.name AS village, " +
                                "ra.postcode " +
                            "FROM " +
                                "rural_villages rv " +
                            "INNER JOIN " +
                                "rural_areas ra ON rv.ruralAreaId = ra.id " +
                            "INNER JOIN " +
                                "lgas l ON ra.lgaId = l.id " +
                            "INNER JOIN " +
                                "states s ON l.stateId = s.id " +
                            "WHERE " +
                                "s.code = ? " +
                            "AND " +
                                "l.name = COALESCE(?, l.name) " +
                            "AND " +
                                "ra.name = COALESCE(?, ra.name) " +
                            "AND " +
                                "rv.name = COALESCE(?, rv.name)";

        List<RuralPostcode> ruralPostcodes = new ArrayList<>();

        ruralPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { stateCode, localGovtAreaName, district, town }, (rs, rowNum) -> {
                    final RuralPostcode ruralPostcode = new RuralPostcode();
            final RuralArea ruralArea = new RuralArea();
            final LocalGovernmentArea lga = new LocalGovernmentArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            lga.setId(rs.getInt("lgaId"));
            lga.setName(rs.getString("lgaName"));
            lga.setState(state);

            ruralArea.setId(rs.getInt("ruralAreaId"));
            ruralArea.setName(rs.getString("district"));
            ruralArea.setPostcode(rs.getInt("postcode"));
            ruralArea.setLocalGovernmentArea(lga);

            ruralPostcode.setId(rs.getInt("id"));
            ruralPostcode.setTown(rs.getString("village"));
            ruralPostcode.setRuralArea(ruralArea);

            return ruralPostcode;
        });
        return ruralPostcodes;
    }

    @Override
    public List<RuralPostcode> reverseLookup(final String postcode)
    {
        final String query = "SELECT " +
                "s.id AS stateId, " +
                "s.name AS stateName, " +
                "s.code AS stateCode, " +
                "l.id AS lgaId, " +
                "l.name AS lgaName, " +
                "ra.id AS ruralAreaId, " +
                "ra.name AS district, " +
                "rv.id, " +
                "rv.name AS village, " +
                "ra.postcode " +
            "FROM " +
                "rural_villages rv " +
            "INNER JOIN " +
                "rural_areas ra ON rv.ruralAreaId = ra.id " +
            "INNER JOIN " +
                "lgas l ON ra.lgaId = l.id " +
            "INNER JOIN " +
                "states s ON l.stateId = s.id " +
            "WHERE " +
                "ra.postcode = ? ";

        List<RuralPostcode> ruralPostcodes = new ArrayList<>();

        ruralPostcodes = this.jdbcTemplate.query(
                query,
                new Object[] { postcode }, (rs, rowNum) -> {
                    final RuralPostcode ruralPostcode = new RuralPostcode();
            final RuralArea ruralArea = new RuralArea();
            final LocalGovernmentArea lga = new LocalGovernmentArea();
            final State state = new State();

            state.setId(rs.getInt("stateId"));
            state.setCode(rs.getString("stateCode"));
            state.setName(rs.getString("stateName"));

            lga.setId(rs.getInt("lgaId"));
            lga.setName(rs.getString("lgaName"));
            lga.setState(state);

            ruralArea.setId(rs.getInt("ruralAreaId"));
            ruralArea.setName(rs.getString("district"));
            ruralArea.setPostcode(rs.getInt("postcode"));
            ruralArea.setLocalGovernmentArea(lga);

            ruralPostcode.setId(rs.getInt("id"));
            ruralPostcode.setTown(rs.getString("village"));
            ruralPostcode.setRuralArea(ruralArea);

            return ruralPostcode;
        });

        return ruralPostcodes;
    }

}
