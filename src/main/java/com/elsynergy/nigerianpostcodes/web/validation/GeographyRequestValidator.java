package com.elsynergy.nigerianpostcodes.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.elsynergy.nigerianpostcodes.model.request.admin.GeographyRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.LocalGovernmentAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.RuralAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.StateRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanAreaRequest;
import com.elsynergy.nigerianpostcodes.model.request.admin.UrbanTownRequest;

/**
 * Geography Requests validation.
 *
 * @author silver.ibenye
 *
 */
@Component
public class GeographyRequestValidator implements Validator
{

    @Override
    public boolean supports(final Class<?> clazz)
    {
        return GeographyRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors)
    {
        if (target instanceof StateRequest) {
            this.validate((StateRequest) target, errors);
        } else if (target instanceof LocalGovernmentAreaRequest) {
            this.validate((LocalGovernmentAreaRequest) target, errors);
        } else if (target instanceof RuralAreaRequest) {
            this.validate((RuralAreaRequest) target, errors);
        } else if (target instanceof UrbanTownRequest) {
            this.validate((UrbanTownRequest) target, errors);
        } else if (target instanceof UrbanAreaRequest) {
            this.validate((UrbanAreaRequest) target, errors);
        }
    }

    private void validate(final StateRequest request, final Errors errors)
    {
        if ((request.getStateCode() == null || request.getStateCode().isEmpty())
                && (request.getStateName() == null || request.getStateName().isEmpty())) {
            errors.rejectValue("stateCode", "missingRequiredField", "stateCode and/or stateName is required.");
        }
    }

    private void validate(final LocalGovernmentAreaRequest request, final Errors errors)
    {
        if (request.getLgaName() == null
                || request.getLgaName().isEmpty()) {
            errors.rejectValue("lgaName", "missingRequiredField", "lgaName is required.");
        }

        if (request.getStateCode() == null
                || request.getStateCode().isEmpty()) {
            errors.rejectValue("stateCode", "missingRequiredField", "stateCode is required.");
        }
    }

    private void validate(final RuralAreaRequest request, final Errors errors)
    {
        if (request.getRuralAreaName() == null
                || request.getRuralAreaName().isEmpty()) {
            errors.rejectValue("ruralAreaName", "missingRequiredField", "ruralAreaName is required.");
        }

        if (request.getLgaName() == null
                || request.getLgaName().isEmpty()) {
            errors.rejectValue("lgaName", "missingRequiredField", "lgaName is required.");
        }

        if (request.getStateCode() == null
                || request.getStateCode().isEmpty()) {
            errors.rejectValue("stateCode", "missingRequiredField", "stateCode is required.");
        }
    }

    private void validate(final UrbanTownRequest request, final Errors errors)
    {
        if (request.getUrbanTownName() == null
                || request.getUrbanTownName().isEmpty()) {
            errors.rejectValue("urbanTownName", "missingRequiredField", "urbanTownName is required.");
        }

        if (request.getStateCode() == null
                || request.getStateCode().isEmpty()) {
            errors.rejectValue("stateCode", "missingRequiredField", "stateCode is required.");
        }
    }

    private void validate(final UrbanAreaRequest request, final Errors errors)
    {
        if (request.getUrbanAreaName() == null
                || request.getUrbanAreaName().isEmpty()) {
            errors.rejectValue("urbanAreaName", "missingRequiredField", "urbanAreaName is required.");
        }

        if (request.getUrbanTownName() == null
                || request.getUrbanTownName().isEmpty()) {
            errors.rejectValue("urbanTownName", "missingRequiredField", "urbanTownName is required.");
        }

        if (request.getStateCode() == null
                || request.getStateCode().isEmpty()) {
            errors.rejectValue("stateCode", "missingRequiredField", "stateCode is required.");
        }
    }

}
