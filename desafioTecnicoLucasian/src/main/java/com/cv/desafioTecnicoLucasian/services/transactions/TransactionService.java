package com.cv.desafioTecnicoLucasian.services.transactions;

import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import com.cv.desafioTecnicoLucasian.entities.TransactionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionService {

    public List<TransactionEntity> findAll();
    Optional<TransactionEntity> findById(UUID id);
    TransactionEntity save(TransactionEntity transactionEntity);
    Optional<TransactionEntity> update(UUID uuid, TransactionEntity transactionEntity);
    Optional<TransactionEntity> deleteById(UUID id);
}
