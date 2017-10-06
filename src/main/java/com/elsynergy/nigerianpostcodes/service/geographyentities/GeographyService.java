package com.elsynergy.nigerianpostcodes.service.geographyentities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsynergy.nigerianpostcodes.mapper.LocalGovernmentAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.RuralAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.RuralTownResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.StateResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanAreaResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanStreetResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanTownResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralTown;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanStreet;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.request.admin.LocalGovernmentAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.RuralAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.StateRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanTownRequest;
import com.elsynergy.nigerianpostcodes.model.response.ApiFindResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.LocalGovernmentAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.RuralTownResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.StateResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanAreaResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanStreetResponse;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.UrbanTownResponse;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.LocalGovernmentAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.RuralAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.RuralTownRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.StateRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.UrbanAreaRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.UrbanStreetRepository;
import com.elsynergy.nigerianpostcodes.repo.geographyentities.UrbanTownRepository;
import com.elsynergy.nigerianpostcodes.web.exception.BadRequestException;
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

    @Autowired
    private UrbanStreetRepository urbanStreetRepository;

    @Autowired
    private UrbanStreetResponseMapper urbanStreetResponseMapper;

    @Autowired
    private RuralTownRepository ruralTownRepository;

    @Autowired
    private RuralTownResponseMapper ruralTownResponseMapper;



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

    public ApiFindResponse getLocalGovernmentArea(final String stateCode, final Integer localGovtAreaId)
            throws ResourceNotFoundException
    {
        List<LocalGovernmentArea> localGovernmentAreas = new ArrayList<>();

        if (localGovtAreaId != null) {
            final LocalGovernmentArea localGovernmentArea = this.localGovernmentAreaRepository.findOne(localGovtAreaId);

            if (localGovernmentArea == null) {
                throw new ResourceNotFoundException();
            }

            localGovernmentAreas.add(localGovernmentArea);
        } else {
            localGovernmentAreas = this.localGovernmentAreaRepository.findByStateCode(stateCode);
        }

        final List<LocalGovernmentAreaResponse> localGovernmentAreaResponses = new ArrayList<>();

        for (final LocalGovernmentArea lga : localGovernmentAreas) {
            localGovernmentAreaResponses.add(this.localGovernmentAreaResponseMapper.map(lga));
        }

        return new ApiFindResponse(localGovernmentAreaResponses);
    }

    public ApiFindResponse getRuralArea(final Integer localGovtAreaId, final Integer ruralAreaId)
            throws ResourceNotFoundException
    {
        List<RuralArea> ruralAreas = new ArrayList<>();

        if (ruralAreaId != null) {
            final RuralArea ruralArea = this.ruralAreaRepository.findOne(ruralAreaId);

            if (ruralArea == null) {
                throw new ResourceNotFoundException();
            }

            ruralAreas.add(ruralArea);
        } else {
            ruralAreas = this.ruralAreaRepository.findByLocalGovernmentAreaId(localGovtAreaId);
        }

        final List<RuralAreaResponse> ruralAreaResponses = new ArrayList<>();

        for (final RuralArea ruralArea : ruralAreas) {
            ruralAreaResponses.add(this.ruralAreaResponseMapper.map(ruralArea));
        }

        return new ApiFindResponse(ruralAreaResponses);

    }

    public ApiFindResponse getUrbanArea(final Integer urbanTownId, final Integer urbanAreaId)
            throws ResourceNotFoundException
    {
        List<UrbanArea> urbanAreas = new ArrayList<>();

        if (urbanAreaId != null) {
            final UrbanArea urbanArea = this.urbanAreaRepository.findOne(urbanAreaId);

            if (urbanArea == null) {
                throw new ResourceNotFoundException();
            }

            urbanAreas.add(urbanArea);
        } else {
            urbanAreas = this.urbanAreaRepository.findByUrbanTownId(urbanTownId);
        }

        final List<UrbanAreaResponse> urbanAreaResponses = new ArrayList<>();

        for (final UrbanArea urbanArea : urbanAreas) {
            urbanAreaResponses.add(this.urbanAreaResponseMapper.map(urbanArea));
        }

        return new ApiFindResponse(urbanAreaResponses);

    }

    public ApiFindResponse getUrbanTown(final String stateCode, final Integer urbanTownId)
            throws ResourceNotFoundException
    {
        List<UrbanTown> urbanTowns = new ArrayList<>();

        if (urbanTownId != null) {
            final UrbanTown urbanTown = this.urbanTownRepository.findOne(urbanTownId);

            if (urbanTown == null) {
                throw new ResourceNotFoundException();
            }

            urbanTowns.add(urbanTown);
        }else {
            urbanTowns = this.urbanTownRepository.findByStateCode(stateCode);
        }

        final List<UrbanTownResponse> urbanTownResponses = new ArrayList<>();

        for (final UrbanTown urbanTown : urbanTowns) {
            urbanTownResponses.add(this.urbanTownResponseMapper.map(urbanTown));
        }

        return new ApiFindResponse(urbanTownResponses);

    }

    public ApiFindResponse getUrbanStreet(final Integer urbanAreaId, final Integer urbanStreetId)
            throws ResourceNotFoundException
    {
        List<UrbanStreet> urbanStreets = new ArrayList<>();

        if (urbanStreetId != null) {
            final UrbanStreet urbanStreet = this.urbanStreetRepository.findOne(urbanStreetId);

            if (urbanStreet == null) {
                throw new ResourceNotFoundException();
            }

            urbanStreets.add(urbanStreet);
        } else {
            urbanStreets = this.urbanStreetRepository.findByUrbanAreaId(urbanAreaId);
        }

        final List<UrbanStreetResponse> urbanStreetResponses = new ArrayList<>();

        for (final UrbanStreet urbanStreet: urbanStreets) {
            urbanStreetResponses.add(this.urbanStreetResponseMapper.map(urbanStreet));
        }

        return new ApiFindResponse(urbanStreetResponses);

    }

    public ApiFindResponse getRuralTown(final Integer ruralAreaId, final Integer ruralTownId)
            throws ResourceNotFoundException
    {
        List<RuralTown> ruralTowns = new ArrayList<>();

        if (ruralTownId != null) {
            final RuralTown ruralTown = this.ruralTownRepository.findOne(ruralTownId);

            if (ruralTown == null) {
                throw new ResourceNotFoundException();
            }

            ruralTowns.add(ruralTown);
        } else {
            ruralTowns = this.ruralTownRepository.findByRuralAreaId(ruralAreaId);
        }

        final List<RuralTownResponse> ruralTownResponses = new ArrayList<>();

        for (final RuralTown ruralTown : ruralTowns) {
            ruralTownResponses.add(this.ruralTownResponseMapper.map(ruralTown));
        }

        return new ApiFindResponse(ruralTownResponses);

    }

    public StateResponse postState(final StateRequest stateRequest)
            throws BadRequestException, ResourceNotFoundException
    {
        if (stateRequest.getId() != null) {
            return this.updateState(stateRequest.getId(), stateRequest.getStateCode(), stateRequest.getStateName());
        } else {
            return this.addState(stateRequest.getStateCode(), stateRequest.getStateName());
        }
    }

    public LocalGovernmentAreaResponse postLga(final LocalGovernmentAreaRequest request)
            throws BadRequestException, ResourceNotFoundException
    {
        if (request.getLgaId() != null) {
            return this.updateLga(request.getLgaId(), request.getLgaName(), request.getStateCode());
        } else {
            return this.addLga(request.getLgaName(), request.getStateCode());
        }
    }

    public RuralAreaResponse postRuralArea(final RuralAreaRequest request)
            throws BadRequestException, ResourceNotFoundException
    {
        if (request.getRuralAreaId() != null) {
            return this.updateRuralArea(request.getRuralAreaId(), request.getRuralAreaName(), request.getLgaName(), request.getStateCode());
        } else {
            return this.addRuralArea(request.getRuralAreaName(), request.getLgaName(), request.getStateCode());
        }
    }

    public UrbanTownResponse postUrbanTown(final UrbanTownRequest request)
            throws BadRequestException, ResourceNotFoundException
    {
        if (request.getUrbanTownId() != null) {
            return this.updateUrbanTown(request.getUrbanTownId(), request.getUrbanTownName(), request.getStateCode());
        } else {
            return this.addUrbanTown(request.getUrbanTownName(), request.getStateCode());
        }
    }

    public UrbanAreaResponse postUrbanArea(final UrbanAreaRequest request)
            throws BadRequestException, ResourceNotFoundException
    {
        if (request.getUrbanAreaId() != null) {
            return this.updateUrbanArea(request.getUrbanAreaId(), request.getUrbanAreaName(), request.getUrbanTownName(), request.getStateCode());
        } else {
            return this.addUrbanArea(request.getUrbanAreaName(), request.getUrbanTownName(), request.getStateCode());
        }
    }

    private StateResponse updateState(final Integer id, final String stateCode, final String stateName)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensurre the id is valid
        final State existingState = this.stateRepository.findOne(id);

        if (existingState == null) {
            throw new ResourceNotFoundException(String.format("State with id:'%s' was not found", id));
        }

        //ensure the new stateCode or stateName does not belong to another
        final Optional<State> existingStateWithStateCode = this.stateRepository.findOneByCode(stateCode);

        if (existingStateWithStateCode.isPresent()
                && existingStateWithStateCode.get().getId() != existingState.getId()) {
            throw new BadRequestException(String.format("State code:'%s' already belongs to another", stateCode));
        }

        final Optional<State> existingStateWithStateName = this.stateRepository.findOneByName(stateName);

        if (existingStateWithStateName.isPresent()
                && existingStateWithStateName.get().getId() != existingState.getId()) {
            throw new BadRequestException(String.format("State name:'%s' already belongs to another", stateName));
        }

        final State state = new State();
        state.setId(id);
        if (stateCode != null && !stateCode.isEmpty()) {
            state.setCode(stateCode);
        }
        if (stateName != null && !stateName.isEmpty()) {
            state.setName(stateName);
        }

        final State updatedState = this.stateRepository.save(state);

        return this.stateResponseMapper.map(updatedState);
    }

    private StateResponse addState(final String stateCode, final String stateName)
            throws BadRequestException
    {
        //ensure the stateCode and stateName do not exist
        Optional<State> existingState = this.stateRepository.findOneByCode(stateCode);

        if (existingState.isPresent()) {
            throw new BadRequestException(String.format("The State code: '%s' already exists", stateCode));
        }

        existingState = this.stateRepository.findOneByName(stateName);

        if (existingState.isPresent()) {
            throw new BadRequestException(String.format("The State name: '%s' already exists", stateName));
        }

        final State state = new State();
        state.setCode(stateCode);
        state.setName(stateName);

        final State savedState = this.stateRepository.save(state);

        return this.stateResponseMapper.map(savedState);

    }

    private LocalGovernmentAreaResponse addLga(final String lgaName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }
        //ensure LgaName does not belong to another
        final Optional<LocalGovernmentArea> existingLga = this.localGovernmentAreaRepository.findOneByStateCodeAndName(stateCode, lgaName);

        if (existingLga.isPresent()) {
            throw new BadRequestException(String.format("The LGA name: '%1s' in State: '%2s' already exists", lgaName, stateCode));
        }

        final LocalGovernmentArea localGovernmentArea = new LocalGovernmentArea();
        localGovernmentArea.setName(lgaName);
        localGovernmentArea.setState(stateByCode.get());

        final LocalGovernmentArea savedLga = this.localGovernmentAreaRepository.save(localGovernmentArea);

        return this.localGovernmentAreaResponseMapper.map(savedLga);
    }

    private LocalGovernmentAreaResponse updateLga(final Integer lgaId, final String lgaName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure LGA Id is valid
        final LocalGovernmentArea existingLgaById = this.localGovernmentAreaRepository.findOne(lgaId);

        if (existingLgaById == null) {
            throw new ResourceNotFoundException(String.format("The LGA Id: '%s' was not found", lgaId));
        }
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

        //ensure LgaName does not belong to another
        final Optional<LocalGovernmentArea> existingLga = this.localGovernmentAreaRepository.findOneByStateCodeAndName(stateCode, lgaName);

        if (existingLga.isPresent() && existingLga.get().getId() != lgaId) {
            throw new BadRequestException(String.format("The LGA name: '%1s' in State: '%2s' already exist for a different LGA Id", lgaName, stateCode));
        }

        final LocalGovernmentArea localGovernmentArea = new LocalGovernmentArea();
        localGovernmentArea.setId(lgaId);
        localGovernmentArea.setName(lgaName);
        localGovernmentArea.setState(stateByCode.get());

        final LocalGovernmentArea savedLga = this.localGovernmentAreaRepository.save(localGovernmentArea);

        return this.localGovernmentAreaResponseMapper.map(savedLga);
    }

    private RuralAreaResponse addRuralArea(final String ruralAreaName, final String lgaName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

        //ensure LgaName is valid
        final Optional<LocalGovernmentArea> existingLga = this.localGovernmentAreaRepository.findOneByStateCodeAndName(stateCode, lgaName);

        if (!existingLga.isPresent()) {
            throw new ResourceNotFoundException(String.format("The LGA name: '%1s' in State: '%2s' was not found", lgaName, stateCode));
        }

        //ensure the ruralAreaName does not already exist
        final Optional<RuralArea> existingRuralArea = this.ruralAreaRepository
                .findOneByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaNameAndName(stateCode, lgaName, ruralAreaName);

        if (existingRuralArea.isPresent()) {
            throw new BadRequestException(String.format("The Rural Area name: '%1s' in LGA: '%2s', in State: '%3s' already exists", ruralAreaName, lgaName, stateCode));
        }

        final RuralArea ruralArea = new RuralArea();
        ruralArea.setLocalGovernmentArea(existingLga.get());
        ruralArea.setName(ruralAreaName);

        final RuralArea savedRuralArea = this.ruralAreaRepository.save(ruralArea);

        return this.ruralAreaResponseMapper.map(savedRuralArea);
    }

    private RuralAreaResponse updateRuralArea(final Integer ruralAreaId, final String ruralAreaName, final String lgaName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure LGA Id is valid
        final RuralArea existingRuralAreaById = this.ruralAreaRepository.findOne(ruralAreaId);

        if (existingRuralAreaById == null) {
            throw new ResourceNotFoundException(String.format("The Rural Area Id: '%s' was not found", ruralAreaId));
        }
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

      //ensure LgaName is valid
        final Optional<LocalGovernmentArea> existingLga = this.localGovernmentAreaRepository.findOneByStateCodeAndName(stateCode, lgaName);

        if (!existingLga.isPresent()) {
            throw new ResourceNotFoundException(String.format("The LGA name: '%1s' in State: '%2s' was not found", lgaName, stateCode));
        }

        //ensure ruralAreaName does not belong to another
        final Optional<RuralArea> existingRuralArea = this.ruralAreaRepository.findOneByLocalGovernmentAreaStateCodeAndLocalGovernmentAreaNameAndName(stateCode, lgaName, ruralAreaName);

        if (existingRuralArea.isPresent() && existingRuralArea.get().getId() != ruralAreaId) {
            throw new BadRequestException(String.format("The Rural Area name: '%1s' in LGA: '%2s', in State: '%3s' already exist for a different Rural Area Id", ruralAreaName, lgaName, stateCode));
        }

        final RuralArea ruralArea = new RuralArea();
        ruralArea.setId(ruralAreaId);
        ruralArea.setLocalGovernmentArea(existingLga.get());
        ruralArea.setName(ruralAreaName);

        final RuralArea savedRuralArea = this.ruralAreaRepository.save(ruralArea);

        return this.ruralAreaResponseMapper.map(savedRuralArea);
    }

    private UrbanTownResponse addUrbanTown(final String urbanTownName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }
        //ensure urbanTownName does not belong to another
        final Optional<UrbanTown> existingUrbanTown = this.urbanTownRepository.findOneByStateCodeAndName(stateCode, urbanTownName);

        if (existingUrbanTown.isPresent()) {
            throw new BadRequestException(String.format("The Urban Town name: '%1s' in State: '%2s' already exists", urbanTownName, stateCode));
        }

        final UrbanTown urbanTown = new UrbanTown();
        urbanTown.setName(urbanTownName);
        urbanTown.setState(stateByCode.get());

        final UrbanTown savedUrbanTown = this.urbanTownRepository.save(urbanTown);

        return this.urbanTownResponseMapper.map(savedUrbanTown);
    }

    private UrbanTownResponse updateUrbanTown(final Integer urbanTownId, final String urbanTownName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure UrbanTown Id is valid
        final UrbanTown existingUrbanTownById = this.urbanTownRepository.findOne(urbanTownId);

        if (existingUrbanTownById == null) {
            throw new ResourceNotFoundException(String.format("The Urban Town Id: '%s' was not found", urbanTownId));
        }
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

        //ensure UrbanTownName does not belong to another
        final Optional<UrbanTown> existingUrbanTown = this.urbanTownRepository.findOneByStateCodeAndName(stateCode, urbanTownName);

        if (existingUrbanTown.isPresent() && existingUrbanTown.get().getId() != urbanTownId) {
            throw new BadRequestException(String.format("The Urban Town name: '%1s' in State: '%2s' already exist for a different LGA Id", urbanTownName, stateCode));
        }

        final UrbanTown urbanTown = new UrbanTown();
        urbanTown.setId(urbanTownId);
        urbanTown.setName(urbanTownName);
        urbanTown.setState(stateByCode.get());

        final UrbanTown savedUrbanTown = this.urbanTownRepository.save(urbanTown);

        return this.urbanTownResponseMapper.map(savedUrbanTown);
    }

    private UrbanAreaResponse addUrbanArea(final String urbanAreaName, final String urbanTownName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

        //ensure urbanTownName is valid
        final Optional<UrbanTown> existingUrbanTown = this.urbanTownRepository.findOneByStateCodeAndName(stateCode, urbanTownName);

        if (!existingUrbanTown.isPresent()) {
            throw new ResourceNotFoundException(String.format("The Urban Town name: '%1s' in State: '%2s' was not found", urbanTownName, stateCode));
        }

        //ensure the urbanAreaName does not already exist
        final Optional<UrbanArea> existingUrbanArea = this.urbanAreaRepository
                .findOneByUrbanTownStateCodeAndUrbanTownNameAndName(stateCode, urbanTownName, urbanAreaName);

        if (existingUrbanArea.isPresent()) {
            throw new BadRequestException(String.format("The Urban Area name: '%1s' in Urban Town: '%2s', in State: '%3s' already exists", urbanAreaName, urbanTownName, stateCode));
        }

        final UrbanArea urbanArea = new UrbanArea();
        urbanArea.setUrbanTown(existingUrbanTown.get());
        urbanArea.setName(urbanAreaName);

        final UrbanArea savedUrbanArea = this.urbanAreaRepository.save(urbanArea);

        return this.urbanAreaResponseMapper.map(savedUrbanArea);
    }

    private UrbanAreaResponse updateUrbanArea(final Integer urbanAreaId, final String urbanAreaName, final String urbanTownName, final String stateCode)
            throws ResourceNotFoundException, BadRequestException
    {
        //ensure Urban Area Id is valid
        final UrbanArea existingUrbanAreaById = this.urbanAreaRepository.findOne(urbanAreaId);

        if (existingUrbanAreaById == null) {
            throw new ResourceNotFoundException(String.format("The Urban Area Id: '%s' was not found", urbanAreaId));
        }
        //ensure stateCode is valid
        final Optional<State> stateByCode = this.stateRepository.findOneByCode(stateCode);

        if (!stateByCode.isPresent()) {
            throw new ResourceNotFoundException(String.format("State with code:'%s' was not found", stateCode));
        }

      //ensure urbanTownName is valid
        final Optional<UrbanTown> existingUrbanTown = this.urbanTownRepository.findOneByStateCodeAndName(stateCode, urbanTownName);

        if (!existingUrbanTown.isPresent()) {
            throw new ResourceNotFoundException(String.format("The Urban Town name: '%1s' in State: '%2s' was not found", urbanTownName, stateCode));
        }

        //ensure urbanAreaName does not belong to another
        final Optional<UrbanArea> existingUrbanArea = this.urbanAreaRepository.findOneByUrbanTownStateCodeAndUrbanTownNameAndName(stateCode, urbanTownName, urbanAreaName);

        if (existingUrbanArea.isPresent() && existingUrbanArea.get().getId() != urbanAreaId) {
            throw new BadRequestException(String.format("The Urban Area name: '%1s' in Urban Town: '%2s', in State: '%3s' already exist for a different Urban Area Id", urbanAreaName, urbanTownName, stateCode));
        }

        final UrbanArea urbanArea = new UrbanArea();
        urbanArea.setId(urbanAreaId);
        urbanArea.setUrbanTown(existingUrbanTown.get());
        urbanArea.setName(urbanAreaName);

        final UrbanArea savedUrbanArea = this.urbanAreaRepository.save(urbanArea);

        return this.urbanAreaResponseMapper.map(savedUrbanArea);
    }


}
