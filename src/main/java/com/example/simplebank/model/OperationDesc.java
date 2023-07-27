package com.example.simplebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * DTO-класс для логгирования операций по счету
 */

@Entity
@Component
@NoArgsConstructor
@Setter
@Getter
public class OperationDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime localDateTime;

    private Long initiatorAccountId;

    private Long recipientAccountId;

    private String operationType;

    private Long amountOfOperation;

    private Long actualInitiatorAccountBalance;

    private Long actualRecipientAccountBalance;
}
