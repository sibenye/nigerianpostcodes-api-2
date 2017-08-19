package com.elsynergy.nigerianpostcodes.service.postcodeentities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsynergy.nigerianpostcodes.mapper.FacilityPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.RuralPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.FacilityPostcode;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;
import com.elsynergy.nigerianpostcodes.model.request.FacilityPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.response.ApiFindResponse;
import com.elsynergy.nigerianpostcodes.model.response.PostcodeReverseLookupResponse;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.FacilityPostcodeResponse;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.RuralPostcodeResponse;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.UrbanPostcodeResponse;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.FacilityPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.PostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.RuralPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.UrbanPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;

/**
 *
 * @author silver.ibenye
 *
 */
@Service
public class PostcodeService
{
    @Autowired
    private FacilityPostcodeRepositoryCustom facilityPostcodeRepository;

    @Autowired
    private RuralPostcodeRepositoryCustom ruralPostcodeRepository;

    @Autowired
    private UrbanPostcodeRepositoryCustom urbanPostcodeRepository;

    @Autowired
    private FacilityPostcodeResponseMapper facilityPostcodeResponseMapper;

    @Autowired
    private RuralPostcodeResponseMapper ruralPostcodeResponseMapper;

    @Autowired
    private UrbanPostcodeResponseMapper urbanPostcodeResponseMapper;

    @Autowired
    private PostcodeRepositoryCustom postcodeRepository;

    public ApiFindResponse getFacilityPostcodes(final FacilityPostcodeRequest request) throws ResourceNotFoundException {
        final List<FacilityPostcode> facilityPostcodes = this.facilityPostcodeRepository.getFacilityPostcodes(
                request.getStateCode(), request.getLocalGovtAreaName(), request.getFacilityName());

        if (facilityPostcodes.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<FacilityPostcodeResponse> facilityPostcodeResponses = new ArrayList<>();

        for (final FacilityPostcode facilityPostcode : facilityPostcodes) {
            facilityPostcodeResponses.add(this.facilityPostcodeResponseMapper.map(facilityPostcode));
        }
        return new ApiFindResponse(facilityPostcodeResponses);
    }

    public ApiFindResponse getRuralPostcodes(final RuralPostcodeRequest request) throws ResourceNotFoundException {
        final List<RuralPostcode> ruralPostcodes = this.ruralPostcodeRepository.getRuralPostcodes(
                request.getStateCode(), request.getLocalGovtAreaName(), request.getDistrict(), request.getTown());

        if (ruralPostcodes.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<RuralPostcodeResponse> ruralPostcodeResponses = new ArrayList<>();

        for (final RuralPostcode ruralPostcode : ruralPostcodes) {
            ruralPostcodeResponses.add(this.ruralPostcodeResponseMapper.map(ruralPostcode));
        }
        return new ApiFindResponse(ruralPostcodeResponses);
    }

    public ApiFindResponse getUrbanPostcodes(final UrbanPostcodeRequest request) throws ResourceNotFoundException {
        final List<UrbanPostcode> urbanPostcodes = this.urbanPostcodeRepository.getUrbanPostcodes(
                request.getStateCode(), request.getTown(), request.getArea(), request.getStreet());

        if (urbanPostcodes.size() == 0) {
            throw new ResourceNotFoundException();
        }

        final List<UrbanPostcodeResponse> urbanPostcodeResponses = new ArrayList<>();

        for (final UrbanPostcode urbanPostcode : urbanPostcodes) {
            urbanPostcodeResponses.add(this.urbanPostcodeResponseMapper.map(urbanPostcode));
        }
        return new ApiFindResponse(urbanPostcodeResponses);
    }

    public ApiFindResponse searchUrbanPostcodes(final String stateCode, final String town, final String hint) {
        final List<UrbanPostcode> urbanPostcodes = this.urbanPostcodeRepository.searchUrbanPostcodes(
                stateCode, town, hint);

        final List<UrbanPostcodeResponse> urbanPostcodeResponses = new ArrayList<>();

        for (final UrbanPostcode urbanPostcode : urbanPostcodes) {
            urbanPostcodeResponses.add(this.urbanPostcodeResponseMapper.map(urbanPostcode));
        }
        return new ApiFindResponse(urbanPostcodeResponses);

    }

    public PostcodeReverseLookupResponse reverseLookup(final String postcode) throws ResourceNotFoundException {
        final String postcodeType = this.postcodeRepository.getPostcodeType(postcode);

        if (postcodeType == null || postcodeType.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        final PostcodeReverseLookupResponse postcodeReverseLookupResponse = new PostcodeReverseLookupResponse();

        switch (postcodeType) {
        case "rural":
            final List<RuralPostcode> ruralPostcodes = this.ruralPostcodeRepository.reverseLookup(postcode);

            final List<RuralPostcodeResponse> ruralPostcodeResponses = new ArrayList<>();

            for (final RuralPostcode ruralPostcode : ruralPostcodes) {
                ruralPostcodeResponses.add(this.ruralPostcodeResponseMapper.map(ruralPostcode));
            }

            postcodeReverseLookupResponse.setPostcodeType(postcodeType);
            postcodeReverseLookupResponse.setRuralPostcodeResponses(ruralPostcodeResponses);
            break;

        case "urban":
            final List<UrbanPostcode> urbanPostcodes = this.urbanPostcodeRepository.reverseLookup(postcode);

            final List<UrbanPostcodeResponse> urbanPostcodeResponses = new ArrayList<>();

            for (final UrbanPostcode urbanPostcode : urbanPostcodes) {
                urbanPostcodeResponses.add(this.urbanPostcodeResponseMapper.map(urbanPostcode));
            }

            postcodeReverseLookupResponse.setPostcodeType(postcodeType);
            postcodeReverseLookupResponse.setUrbanPostcodeResponses(urbanPostcodeResponses);
            break;

        case "facility":
            final List<FacilityPostcode> facilityPostcodes = this.facilityPostcodeRepository.reverseLookup(postcode);

            final List<FacilityPostcodeResponse> facilityPostcodeResponses = new ArrayList<>();

            for (final FacilityPostcode facilityPostcode : facilityPostcodes) {
                facilityPostcodeResponses.add(this.facilityPostcodeResponseMapper.map(facilityPostcode));
            }

            postcodeReverseLookupResponse.setPostcodeType(postcodeType);
            postcodeReverseLookupResponse.setFacilityPostcodeResponses(facilityPostcodeResponses);
            break;

        default:
            break;
        }

        return postcodeReverseLookupResponse;

    }
}
