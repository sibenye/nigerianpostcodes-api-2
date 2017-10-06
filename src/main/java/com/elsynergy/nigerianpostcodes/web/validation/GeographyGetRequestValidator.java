package com.elsynergy.nigerianpostcodes.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.elsynergy.nigerianpostcodes.model.request.GeographyGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.LocalGovernmentAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralVillageGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanAreaGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanStreetGetRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanTownGetRequest;

/**
 * Geography Requests validation.
 *
 * @author silver.ibenye
 *
 */
@Component
public class GeographyGetRequestValidator implements Validator
{

    @Override
    public boolean supports(final Class<?> clazz)
    {
        return GeographyGetRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors)
    {
        if (target instanceof LocalGovernmentAreaGetRequest) {
            this.validate((LocalGovernmentAreaGetRequest) target, errors);
        } else if (target instanceof RuralAreaGetRequest) {
            this.validate((RuralAreaGetRequest) target, errors);
        } else if (target instanceof RuralVillageGetRequest) {
            this.validate((RuralVillageGetRequest) target, errors);
        } else if (target instanceof UrbanTownGetRequest) {
            this.validate((UrbanTownGetRequest) target, errors);
        } else if (target instanceof UrbanAreaGetRequest) {
            this.validate((UrbanAreaGetRequest) target, errors);
        } else if (target instanceof UrbanStreetGetRequest) {
            this.validate((UrbanStreetGetRequest) target, errors);
        }
    }

    private void validate(final LocalGovernmentAreaGetRequest request, final Errors errors)
    {
        if ((request.getStateCode() == null || request.getStateCode().isEmpty())
                && (request.getLgaId() == null)) {
            errors.reject("missingRequiredField", "stateCode or lgaId is required");
        }
    }

    private void validate(final RuralAreaGetRequest request, final Errors errors)
    {
        if (request.getLgaId() == null
                && request.getRuralAreaId() == null) {
            errors.reject("missingRequiredField", "lgaId or ruralAreaId is required.");
        }
    }

    private void validate(final RuralVillageGetRequest request, final Errors errors)
    {
        if (request.getRuralAreaId() == null
                && request.getRuralVillageId() == null) {
            errors.reject("missingRequiredField", "ruralAreaId or ruralVillageId is required.");
        }
    }

    private void validate(final UrbanAreaGetRequest request, final Errors errors)
    {
        if (request.getUrbanAreaId() == null
                && request.getUrbanTownId() == null) {
            errors.reject("missingRequiredField", "urbanTownId or urbanAreaId is required.");
        }
    }

    private void validate(final UrbanStreetGetRequest request, final Errors errors)
    {
        if (request.getUrbanAreaId() == null
                && request.getUrbanStreetId() == null) {
            errors.reject("missingRequiredField", "urbanAreaId or urbanStreetId is required.");
        }
    }

    private void validate(final UrbanTownGetRequest request, final Errors errors)
    {
        if ((request.getStateCode() == null || request.getStateCode().isEmpty())
                && (request.getUrbanTownId() == null)) {
            errors.reject("missingRequiredField", "stateCode or urbanTownId is required");
        }
    }
}
