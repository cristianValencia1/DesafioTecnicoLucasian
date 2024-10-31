package com.cv.desafioTecnicoLucasian.services.params;

import com.cv.desafioTecnicoLucasian.entities.ParamEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParamService {

    List<ParamEntity> findAll();
    Optional<ParamEntity> findById(UUID id);
    ParamEntity save(ParamEntity paramEntity);
    Optional<ParamEntity> update(UUID uuid, ParamEntity paramEntity);
    Optional<ParamEntity> deleteById(UUID id);
}
