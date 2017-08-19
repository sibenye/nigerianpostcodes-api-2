package com.elsynergy.nigerianpostcodes.model.response;

import java.util.List;

import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.FacilityPostcodeResponse;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.RuralPostcodeResponse;
import com.elsynergy.nigerianpostcodes.model.response.postcodeentities.UrbanPostcodeResponse;

public class PostcodeReverseLookupResponse extends BaseResponse
{
    private String postcodeType;

    private List<RuralPostcodeResponse> ruralPostcodeResponses;

    private List<UrbanPostcodeResponse> urbanPostcodeResponses;

    private List<FacilityPostcodeResponse> facilityPostcodeResponses;

    public String getPostcodeType()
    {
        return this.postcodeType;
    }

    public void setPostcodeType(final String postcodeType)
    {
        this.postcodeType = postcodeType;
    }

    public List<RuralPostcodeResponse> getRuralPostcodeResponses()
    {
        return ruralPostcodeResponses;
    }

    public void setRuralPostcodeResponses(List<RuralPostcodeResponse> ruralPostcodeResponses)
    {
        this.ruralPostcodeResponses = ruralPostcodeResponses;
    }

    public List<UrbanPostcodeResponse> getUrbanPostcodeResponses()
    {
        return urbanPostcodeResponses;
    }

    public void setUrbanPostcodeResponses(List<UrbanPostcodeResponse> urbanPostcodeResponses)
    {
        this.urbanPostcodeResponses = urbanPostcodeResponses;
    }

    public List<FacilityPostcodeResponse> getFacilityPostcodeResponses()
    {
        return facilityPostcodeResponses;
    }

    public void setFacilityPostcodeResponses(List<FacilityPostcodeResponse> facilityPostcodeResponses)
    {
        this.facilityPostcodeResponses = facilityPostcodeResponses;
    }



}
