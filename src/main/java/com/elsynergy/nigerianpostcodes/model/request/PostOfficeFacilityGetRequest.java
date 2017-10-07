package com.elsynergy.nigerianpostcodes.model.request;

import io.swagger.annotations.ApiParam;

public class PostOfficeFacilityGetRequest extends GeographyGetRequest
{
    @ApiParam(value = "State Code.")
    private String stateCode;

    @ApiParam(value = "Local Government Area Id.")
    private Integer lgaId;

    @ApiParam(value = "Post Office Facility Id.")
    private Integer postOfficeFacilityId;

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public Integer getLgaId()
    {
        return this.lgaId;
    }

    public void setLgaId(final Integer lgaId)
    {
        this.lgaId = lgaId;
    }

    public Integer getPostOfficeFacilityId()
    {
        return this.postOfficeFacilityId;
    }

    public void setPostOfficeFacilityId(final Integer postOfficeFacilityId)
    {
        this.postOfficeFacilityId = postOfficeFacilityId;
    }

}
