package com.cv.desafioTecnicoLucasian.config.configError;


import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ParamValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ParamEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ParamEntity paramEntity = (ParamEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "es requerido!");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","NotBlank.paramEntity.description");
        if (null == paramEntity.getName() || paramEntity.getName().isBlank()){

            errors.rejectValue("description", "Es requerido!!");
        }


    }
}
