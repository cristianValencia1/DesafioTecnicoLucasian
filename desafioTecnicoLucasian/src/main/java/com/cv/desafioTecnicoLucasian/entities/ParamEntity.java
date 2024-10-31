package com.cv.desafioTecnicoLucasian.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "params")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paramId;
    private String name;
    private String value;
    private String description;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Timestamp modifiedAt;

//    @ManyToMany
//    @JoinTable(
//            name = "parametro_transaccion",
//            joinColumns = @JoinColumn(name = "param_id"),
//            inverseJoinColumns = @JoinColumn(name = "transaction_id")
//    )
//    private List<TransactionEntity> transactionEntities;

}
