package com.elsynergy.nigerianpostcodes.model.request.admin;

import io.swagger.annotations.ApiParam;

/**
 *
 * @author silver.ibenye
 *
 */
public class StateRequest extends GeographyPostRequest
{
    @ApiParam(value = "State id")
    private Integer id;

    @ApiParam(value = "State code")
    private String stateCode;

    @ApiParam(value = "State name")
    private String stateName;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(final String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getStateName()
    {
        return this.stateName;
    }

    public void setStateName(final String stateName)
    {
        this.stateName = stateName;
    }

}
