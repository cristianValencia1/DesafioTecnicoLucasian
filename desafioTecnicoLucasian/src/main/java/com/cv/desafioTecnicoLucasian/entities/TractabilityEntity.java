package com.cv.desafioTecnicoLucasian.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tractability")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class TractabilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Transaction_id")
    private Long TransactionId;
    private String action;
    private String description;
    private Timestamp dateAt;
}
