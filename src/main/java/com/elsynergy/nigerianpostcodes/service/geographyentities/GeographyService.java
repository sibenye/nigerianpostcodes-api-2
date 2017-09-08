package com.elsynergy.nigerianpostcodes.service.geographyentities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsynergy.nigerianpostcodes.mapper.LocalGovernmentAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.RuralAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.StateResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanTownResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.response.ApiFindResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.LocalGovernmentAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.StateResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanTownResponse;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.LocalGovernmentAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.RuralAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.StateRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.UrbanAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.UrbanTownRepository;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;

/**
 *
 * @author silver.ibenye
 *
 */
@Service
public class GeographyService
{
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateResponseMapper stateResponseMapper;

    @Autowired
    private LocalGovernmentAreaResponseMapper localGovernmentAreaResponseMapper;

    @Autowired
    private LocalGovernmentAreaRepository localGovernmentAreaRepository;

    @Autowired
    private RuralAreaRepository ruralAreaRepository;

    @Autowired
    private RuralAreaResponseMapper ruralAreaResponseMapper;

    @Autowired
    private UrbanAreaRepository urbanAreaRepository;

    @Autowired
    private UrbanAreaResponseMapper urbanAreaResponseMapper;

    @Autowired
    private UrbanTownRepository urbanTownRepository;

    @Autowired
    private UrbanTownResponseMapper urbanTownResponseMapper;


    /**
     * Retrieve states/state.
     *
     * @param stateCode
     * @return
     * @throws ResourceNotFoundException
     */
    public ApiFindResponse getStates(final String stateCode) throws ResourceNotFoundException
    {
        final List<StateResponse> stateResponses = new ArrayList<>();
        if (stateCode != null) {
            final Optional<State> state = this.stateRepository.findOneByCode(stateCode);
            if (!state.isPresent()) {
                throw new ResourceNotFoundException("StateCode: " + stateCode + " Was Not Found.");
            }
            stateResponses.add(this.stateResponseMapper.map(state.get()));
        } else {
            final Iterable<State> states = this.stateRepository.findAll();
            for (final State state : states) {
                stateResponses.add(this.stateResponseMapper.map(state));
            }
        }
        return new ApiFindResponse(stateResponses);
    }

    public ApiFindResponse getLocalGovernmentArea(final String stateCode, final String localGovtAreaName) throws ResourceNotFoundException
    {
        List<LocalGovernmentArea> localGovernmentAreas = new ArrayList<>();

        if (stateCode != null && localGovtAreaName != null) {
            localGovernmentAreas = this.localGovernmentAreaRepository.findByStateCodeAndName(stateCode, localGovtAreaName);
        } else {
            localGovernmentAreas = this.localGovernmentAreaRepository.findByStateCode(stateCode);
        }

        if (localGovernmentAreas.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<LocalGovernmentAreaResponse> localGovernmentAreaResponses = new ArrayList<>();

        for (final LocalGovernmentArea lga : localGovernmentAreas) {
            localGovernmentAreaResponses.add(this.localGovernmentAreaResponseMapper.map(lga));
        }

        return new ApiFindResponse(localGovernmentAreaResponses);
    }

    public ApiFindResponse getRuralArea(final String stateCode, final String localGovtAreaName, final String ruralAreaName)
            throws ResourceNotFoundException
    {
        List<RuralArea> ruralAreas = new ArrayList<>();

        if (stateCode != null && localGovtAreaName != null && ruralAreaName != null) {
            ruralAreas = this.ruralAreaRepository.findByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaNameAndName(stateCode, localGovtAreaName, ruralAreaName);
        } else if (stateCode != null && localGovtAreaName != null) {
            ruralAreas = this.ruralAreaRepository.findByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaName(stateCode, localGovtAreaName);
        } else if (stateCode != null && ruralAreaName != null) {
            ruralAreas = this.ruralAreaRepository.findByLocalGovernmentAreaStateCodeAndName(stateCode, ruralAreaName);
        } else {
            ruralAreas = this.ruralAreaRepository.findByLocalGovernmentAreaStateCode(stateCode);
        }

        if (ruralAreas.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<RuralAreaResponse> ruralAreaResponses = new ArrayList<>();

        for (final RuralArea ruralArea : ruralAreas) {
            ruralAreaResponses.add(this.ruralAreaResponseMapper.map(ruralArea));
        }

        return new ApiFindResponse(ruralAreaResponses);

    }

    public ApiFindResponse getUrbanArea(final String stateCode, final String urbanTownName, final String urbanAreaName)
            throws ResourceNotFoundException
    {
        List<UrbanArea> urbanAreas = new ArrayList<>();

        if (stateCode != null && urbanTownName != null && urbanAreaName != null) {
            urbanAreas = this.urbanAreaRepository.findByUrbanTownStateCodeAndUrbanTownNameAndName(stateCode, urbanTownName, urbanAreaName);
        } else if (stateCode != null && urbanTownName != null) {
            urbanAreas = this.urbanAreaRepository.findByUrbanTownStateCodeAndUrbanTownName(stateCode, urbanTownName);
        } else if (stateCode != null && urbanAreaName != null) {
            urbanAreas = this.urbanAreaRepository.findByUrbanTownStateCodeAndName(stateCode, urbanAreaName);
        } else {
            urbanAreas = this.urbanAreaRepository.findByUrbanTownStateCode(stateCode);
        }

        if (urbanAreas.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<UrbanAreaResponse> urbanAreaResponses = new ArrayList<>();

        for (final UrbanArea urbanArea : urbanAreas) {
            urbanAreaResponses.add(this.urbanAreaResponseMapper.map(urbanArea));
        }

        return new ApiFindResponse(urbanAreaResponses);

    }

    public ApiFindResponse getUrbanTown(final String stateCode, final String urbanTownName)
            throws ResourceNotFoundException
    {
        List<UrbanTown> urbanTowns = new ArrayList<>();

        if (stateCode != null && urbanTownName != null) {
            urbanTowns = this.urbanTownRepository.findByStateCodeAndName(stateCode, urbanTownName);
        }else {
            urbanTowns = this.urbanTownRepository.findByStateCode(stateCode);
        }

        if (urbanTowns.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<UrbanTownResponse> urbanTownResponses = new ArrayList<>();

        for (final UrbanTown urbanTown : urbanTowns) {
            urbanTownResponses.add(this.urbanTownResponseMapper.map(urbanTown));
        }

        return new ApiFindResponse(urbanTownResponses);

    }


}
