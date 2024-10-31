package com.cv.desafioTecnicoLucasian.config.configError;


import com.cv.desafioTecnicoLucasian.services.params.ParamService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class IsExistDbValidation implements ConstraintValidator<IsExistDb, UUID> {

    @Autowired
    private ParamService service;


    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
