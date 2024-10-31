package com.cv.desafioTecnicoLucasian.services.transactions;

import com.cv.desafioTecnicoLucasian.entities.TractabilityEntity;
import com.cv.desafioTecnicoLucasian.entities.TransactionEntity;
import com.cv.desafioTecnicoLucasian.repositories.transactions.TransactionRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;
    Timestamp now = new Timestamp(System.currentTimeMillis());
    @Override
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<TransactionEntity> findById(UUID id) {
        return transactionRepository.findById(id);
    }

    @Override
    public TransactionEntity save(TransactionEntity transactionEntity) {

        transactionEntity.setCreatedAt(now);
        transactionEntity.setModifiedAt(now);
        TransactionEntity newTransaction = transactionRepository.save(transactionEntity);
        registerTractability(newTransaction.getTransactionId(), "CREAR", "Transacción creada");
        return newTransaction;
    }

    @Override
    public Optional<TransactionEntity> update(UUID uuid, TransactionEntity transactionEntity) {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionEntity> deleteById(UUID id) {
        return Optional.empty();
    }

    private void registerTractability(UUID transactionId, String action, String description) {
        TractabilityEntity tractabilityEntity = new TractabilityEntity();

        tractabilityEntity.setId(transactionId);
        tractabilityEntity.setAction(action);
        tractabilityEntity.setDescription(description);
        tractabilityEntity.setDateAt(now);
        //trazabilidadRepository.save(trazabilidad);
    }
}
