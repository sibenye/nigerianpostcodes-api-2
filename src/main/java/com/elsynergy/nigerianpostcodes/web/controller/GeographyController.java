package com.elsynergy.nigerianpostcodes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elsynergy.nigerianpostcodes.model.response.ApiResponse;
import com.elsynergy.nigerianpostcodes.service.geographyentities.GeographyService;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;

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

    @ApiOperation(value = "Retrieve States.")
    @RequestMapping(method = RequestMethod.GET, value = "/states")
    public @ResponseBody ApiResponse getStates(
            @Valid @RequestParam ( required = false ) final String stateCode
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getStates(stateCode));
    }

    @ApiOperation(value = "Retrieve LGAs.")
    @RequestMapping(method = RequestMethod.GET, value = "/states/{stateCode}/lgas")
    public @ResponseBody ApiResponse getLGAs(
            @Valid @PathVariable final String stateCode,
            @Valid @RequestParam ( required = false ) final Integer localGovtAreaId
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getLocalGovernmentArea(stateCode, localGovtAreaId));
    }

    @ApiOperation(value = "Retrieve Rural Areas.")
    @RequestMapping(method = RequestMethod.GET, value = "/states/{stateCode}/ruralAreas")
    public @ResponseBody ApiResponse getRuralAreas(
            @Valid @PathVariable final String stateCode,
            @Valid @RequestParam ( required = false ) final Integer localGovtAreaId,
            @Valid @RequestParam ( required = false ) final Integer ruralAreaId
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getRuralArea(stateCode, localGovtAreaId, ruralAreaId));
    }

    @ApiOperation(value = "Retrieve Urban Areas.")
    @RequestMapping(method = RequestMethod.GET, value = "/states/{stateCode}/urbanAreas")
    public @ResponseBody ApiResponse getUrbanAreas(
            @Valid @PathVariable final String stateCode,
            @Valid @RequestParam ( required = false ) final Integer urbanTownId,
            @Valid @RequestParam ( required = false ) final Integer urbanAreaId
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getUrbanArea(stateCode, urbanTownId, urbanAreaId));
    }

    @ApiOperation(value = "Retrieve Urban Towns.")
    @RequestMapping(method = RequestMethod.GET, value = "/states/{stateCode}/urbanTowns")
    public @ResponseBody ApiResponse getUrbanTowns(
            @Valid @PathVariable final String stateCode,
            @Valid @RequestParam ( required = false ) final Integer urbanTownId
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.geographyService.getUrbanTown(stateCode, urbanTownId));
    }

}
