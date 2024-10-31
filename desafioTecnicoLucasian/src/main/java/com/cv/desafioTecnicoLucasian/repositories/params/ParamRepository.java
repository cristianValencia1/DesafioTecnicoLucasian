package com.cv.desafioTecnicoLucasian.repositories.params;

import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParamRepository extends JpaRepository<ParamEntity, UUID> {

}
