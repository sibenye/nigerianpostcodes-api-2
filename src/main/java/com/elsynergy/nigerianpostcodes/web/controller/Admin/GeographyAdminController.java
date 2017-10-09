package com.elsynergy.nigerianpostcodes.web.controller.Admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elsynergy.nigerianpostcodes.model.request.admin.LocalGovernmentAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.RuralAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.RuralVillageRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.StateRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanStreetRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanTownRequest;
import com.elsynergy.nigerianpostcodes.model.response.ApiResponse;
import com.elsynergy.nigerianpostcodes.service.geographyentities.GeographyService;
import com.elsynergy.nigerianpostcodes.web.exception.BadRequestException;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;
import com.elsynergy.nigerianpostcodes.web.validation.GeographyPostRequestValidator;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin/geography")
/**
 * Geography Controller.
 *
 * @author silver.ibenye
 *
 */
public class GeographyAdminController
{
    @Autowired
    private GeographyPostRequestValidator requestValidator;

    @Autowired
    private GeographyService geographyService;

    @ApiOperation(value = "Add/Update State.")
    @RequestMapping(method = RequestMethod.POST, value = "/states")
    public @ResponseBody ApiResponse postStates(
            @Valid @RequestBody final StateRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postState(request));
    }

    @ApiOperation(value = "Add/Update LGA.")
    @RequestMapping(method = RequestMethod.POST, value = "/lgas")
    public @ResponseBody ApiResponse postLga(
            @Valid @RequestBody final LocalGovernmentAreaRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postLga(request));
    }

    @ApiOperation(value = "Add/Update Rural Area.")
    @RequestMapping(method = RequestMethod.POST, value = "/ruralAreas")
    public @ResponseBody ApiResponse postRuralArea(
            @Valid @RequestBody final RuralAreaRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postRuralArea(request));
    }

    @ApiOperation(value = "Add/Update Urban Town.")
    @RequestMapping(method = RequestMethod.POST, value = "/urbanTowns")
    public @ResponseBody ApiResponse postUrbanTown(
            @Valid @RequestBody final UrbanTownRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postUrbanTown(request));
    }

    @ApiOperation(value = "Add/Update Urban Area.")
    @RequestMapping(method = RequestMethod.POST, value = "/urbanAreas")
    public @ResponseBody ApiResponse postUrbanArea(
            @Valid @RequestBody final UrbanAreaRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postUrbanArea(request));
    }

    @ApiOperation(value = "Add/Update Urban Street.")
    @RequestMapping(method = RequestMethod.POST, value = "/urbanStreets")
    public @ResponseBody ApiResponse postUrbanStreet(
            @Valid @RequestBody final UrbanStreetRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postUrbanStreet(request));
    }

    @ApiOperation(value = "Add/Update Rural Village.")
    @RequestMapping(method = RequestMethod.POST, value = "/ruralVillages")
    public @ResponseBody ApiResponse postRuralVillage(
            @Valid @RequestBody final RuralVillageRequest request
            ) throws BadRequestException, ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.postRuralVillage(request));
    }

    @InitBinder
    private void initBinder(final WebDataBinder binder)
    {
        binder.addValidators(this.requestValidator);
    }

}
