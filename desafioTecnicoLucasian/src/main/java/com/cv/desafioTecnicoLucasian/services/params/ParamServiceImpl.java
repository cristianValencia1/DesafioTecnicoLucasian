package com.cv.desafioTecnicoLucasian.services.params;

import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import com.cv.desafioTecnicoLucasian.repositories.params.ParamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParamServiceImpl implements ParamService{

    private ParamRepository paramRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ParamEntity> findAll() {
        return (List<ParamEntity>) paramRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<ParamEntity> findById(UUID id) {
        return paramRepository.findById(id);
    }

    @Override
    @Transactional
    public ParamEntity save(ParamEntity paramEntity) {
        return paramRepository.save(paramEntity);
    }

    @Override
    @Transactional
    public Optional<ParamEntity> update(UUID uuid, ParamEntity paramEntity) {
        Optional<ParamEntity> paramDb = paramRepository.findById(uuid);
        if(paramDb.isPresent()){
            ParamEntity paramEntity1 = paramDb.orElseThrow();

            //paramEntity1.(paramEntity.getSku());
            //paramEntity1.setPrice(paramEntity.getPrice());
            paramEntity1.setName(paramEntity.getName());
            paramEntity1.setValue(paramEntity.getValue());

            return Optional.of(paramRepository.save(paramEntity1));
        }
        return paramDb;
    }

    @Override
    @Transactional
    public Optional<ParamEntity> deleteById(UUID uuid) {
        Optional<ParamEntity> paramDb = paramRepository.findById(uuid);

        paramDb.ifPresent((param1 -> paramRepository.delete(param1)));
        return  paramDb;
    }
}
