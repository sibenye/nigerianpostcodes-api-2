package com.elsynergy.nigerianpostcodes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elsynergy.nigerianpostcodes.model.request.FacilityPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.response.ApiResponse;
import com.elsynergy.nigerianpostcodes.service.postcodeentities.PostcodeService;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/postcodes")
/**
 * Postcode Controller.
 *
 * @author silver.ibenye
 *
 */
public class PostcodeController
{
    @Autowired
    private PostcodeService postcodeService;

    @ApiOperation(value = "Retrieve Rural Postcodes.")
    @RequestMapping(method = RequestMethod.GET, value = "/rural-postcodes")
    public @ResponseBody ApiResponse getRuralPostcodes(
            @Valid @ModelAttribute final RuralPostcodeRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.postcodeService.getRuralPostcodes(request));
    }


    @ApiOperation(value = "Retrieve Urban Postcodes.")
    @RequestMapping(method = RequestMethod.GET, value = "/urban-postcodes")
    public @ResponseBody ApiResponse getUrbanPostcodes(
            @Valid @ModelAttribute final UrbanPostcodeRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.postcodeService.getUrbanPostcodes(request));
    }

    @ApiOperation(value = "Retrieve Facility Postcodes.")
    @RequestMapping(method = RequestMethod.GET, value = "/facility-postcodes")
    public @ResponseBody ApiResponse getFacilityPostcodes(
            @Valid @ModelAttribute final FacilityPostcodeRequest request
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.postcodeService.getFacilityPostcodes(request));
    }

    @ApiOperation(value = "Search Urban Postcodes by Street.")
    @RequestMapping(method = RequestMethod.GET, value = "/urban-postcodes/search")
    public @ResponseBody ApiResponse searchUrbanPostcodes(
            @Valid @RequestParam ( required = true ) final String stateCode,
            @Valid @RequestParam ( required = true ) final String urbanTownName,
            @Valid @RequestParam ( required = true ) final String hint
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.postcodeService.searchUrbanPostcodes(stateCode, urbanTownName, hint));
    }

    @ApiOperation(value = "Reverse Lookup Postcode")
    @RequestMapping(method = RequestMethod.GET, value = "/reverse-lookup")
    public @ResponseBody ApiResponse reverseLookup(
            @Valid @RequestParam ( required = true ) final String postcode
            ) throws ResourceNotFoundException
    {
        return new ApiResponse(this.postcodeService.reverseLookup(postcode));
    }

}
