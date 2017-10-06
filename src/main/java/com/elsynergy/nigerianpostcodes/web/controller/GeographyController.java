package com.elsynergy.nigerianpostcodes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elsynergy.nigerianpostcodes.model.request.LocalGovernmentAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralTownGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanStreetGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanTownGetRequest;
import com.elsynergy.nigerianpostcodes.model.response.ApiResponse;
import com.elsynergy.nigerianpostcodes.service.geographyentities.GeographyService;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;
import com.elsynergy.nigerianpostcodes.web.validation.GeographyGetRequestValidator;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/geography")
/**
 * Geography Controller.
 *
 * @author silver.ibenye
 *
 */
public class GeographyController
{
    @Autowired
    private GeographyService geographyService;

    @Autowired
    private GeographyGetRequestValidator requestValidator;

    @ApiOperation(value = "Retrieve States.")
    @RequestMapping(method = RequestMethod.GET, value = "/states")
    public @ResponseBody ApiResponse getStates(
            @Valid @RequestParam ( required = false ) final String stateCode
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getStates(stateCode));
    }

    @ApiOperation(value = "Retrieve LGAs.")
    @RequestMapping(method = RequestMethod.GET, value = "/lgas")
    public @ResponseBody ApiResponse getLGAs(
            @Valid @ModelAttribute final LocalGovernmentAreaGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getLocalGovernmentArea(request.getStateCode(), request.getLgaId()));
    }

    @ApiOperation(value = "Retrieve Rural Areas.")
    @RequestMapping(method = RequestMethod.GET, value = "/ruralAreas")
    public @ResponseBody ApiResponse getRuralAreas(
            @Valid @ModelAttribute final RuralAreaGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getRuralArea(request.getLgaId(), request.getRuralAreaId()));
    }

    @ApiOperation(value = "Retrieve Rural Villages.")
    @RequestMapping(method = RequestMethod.GET, value = "/ruralTowns")
    public @ResponseBody ApiResponse getRuralTowns(
            @Valid @ModelAttribute final RuralTownGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getRuralTown(request.getRuralAreaId(), request.getRuralTownId()));
    }

    @ApiOperation(value = "Retrieve Urban Towns.")
    @RequestMapping(method = RequestMethod.GET, value = "/urbanTowns")
    public @ResponseBody ApiResponse getUrbanTowns(
            @Valid @ModelAttribute final UrbanTownGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getUrbanTown(request.getStateCode(), request.getUrbanTownId()));
    }

    @ApiOperation(value = "Retrieve Urban Areas.")
    @RequestMapping(method = RequestMethod.GET, value = "/urbanAreas")
    public @ResponseBody ApiResponse getUrbanAreas(
            @Valid @ModelAttribute final UrbanAreaGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getUrbanArea(request.getUrbanTownId(), request.getUrbanAreaId()));
    }

    @ApiOperation(value = "Retrieve Urban Streets.")
    @RequestMapping(method = RequestMethod.GET, value = "/urbanStreets")
    public @ResponseBody ApiResponse getUrbanStreets(
            @Valid @ModelAttribute final UrbanStreetGetRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getUrbanStreet(request.getUrbanAreaId(), request.getUrbanStreetId()));
    }

    @InitBinder
    private void initBinder(final WebDataBinder binder)
    {
        binder.addValidators(this.requestValidator);
    }

}
