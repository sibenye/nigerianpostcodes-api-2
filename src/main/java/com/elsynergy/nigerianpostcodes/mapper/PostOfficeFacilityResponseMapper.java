package com.elsynergy.nigerianpostcodes.mapper;

import org.springframework.stereotype.Component;

import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.PostOfficeFacility;
import com.elsynergy.nigerianpostcodes.model.response.geographyentities.PostOfficeFacilityResponse;

/**
 *
 * @author silver.ibenye
 *
 */
@Component
public class PostOfficeFacilityResponseMapper implements IResponseMapper<PostOfficeFacility, PostOfficeFacilityResponse>
{

    @Override
    public PostOfficeFacilityResponse map(final PostOfficeFacility toMap)
    {
        final PostOfficeFacilityResponse out = new PostOfficeFacilityResponse();
        out.setPostOfficeFacilityId(toMap.getId());
        out.setPostOfficeFacilityName(toMap.getFacility());
        out.setFacilityType(toMap.getType());
        out.setLocalGovernmentAreaId(toMap.getLocalGovernmentArea().getId());
        out.setLocalGovernmentAreaName(toMap.getLocalGovernmentArea().getName());
        out.setStateCode(toMap.getLocalGovernmentArea().getState().getCode());
        out.setStateName(toMap.getLocalGovernmentArea().getState().getName());
        out.setArea(toMap.getArea());
        out.setTown(toMap.getTown());
        out.setPostcode(toMap.getPostcode());
        out.setRangeOfPMB(toMap.getRangeOfPMB());
        out.setRangeOfPOB(toMap.getRangeOfPOB());

        return out;
    }

}
