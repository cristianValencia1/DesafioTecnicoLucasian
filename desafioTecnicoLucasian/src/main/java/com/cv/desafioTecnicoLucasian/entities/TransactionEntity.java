package com.cv.desafioTecnicoLucasian.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TransactionId;
    private String type;
    private Double amount;
    private boolean status;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Timestamp  modifiedAt;

    @ManyToMany(mappedBy = "transactionEntities")
    private List<ParamEntity> params;
}
