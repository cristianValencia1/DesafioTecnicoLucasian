package com.cv.desafioTecnicoLucasian.controllers.param;


import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import com.cv.desafioTecnicoLucasian.services.params.ParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/param")
@Slf4j
public class ParamController {

    private ParamService paramService;

    @GetMapping
    public List<ParamEntity> getAllParams(){
        log.info("Obteniendo todos los parámetros");
        return paramService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getParamById(@PathVariable UUID id) {
//        Optional<ParamEntity> paramOptional = paramService.findById(id);
//        if (!paramOptional.equals(id) && !paramOptional.equals("")) {
//            return ResponseEntity.ok(paramOptional.orElseThrow());
//        }
//
//        return ResponseEntity.notFound().build();

        log.info("Obteniendo el parámetro con ID: {}", id);

        return paramService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createParam(@RequestBody @Valid ParamEntity paramEntity, BindingResult result){
        log.info("Creando un nuevo parámetro: {}", paramEntity);
        // paramValidation.validate(paramEntity, result);
        if (result.hasFieldErrors()){
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(paramService.save(paramEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateParam(@Valid @RequestBody ParamEntity paramEntity, BindingResult result, @PathVariable UUID id){
        //paramValidation.validate(paramEntity, result);

        log.info("Actualizando el parámetro con ID: {}", id);
        if (result.hasFieldErrors()){
            return  validation(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(paramService.findById(id)
                .map(existingParam -> {
                    existingParam.setName(paramEntity.getName());
                    existingParam.setValue(paramEntity.getValue());
                    log.info("Parámetro actualizado: {}", existingParam);
                    return ResponseEntity.ok(paramService.save(existingParam));
                })
                .orElse(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        log.info("Eliminando el parámetro con ID: {}", id);
        if (paramService.findById(id).isPresent()) {

            log.info("Parámetro eliminado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(paramService.deleteById(id));
        }

        log.warn("Parámetro con ID: {} no encontrado", id);
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
