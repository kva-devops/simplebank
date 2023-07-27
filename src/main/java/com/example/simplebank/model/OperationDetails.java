package com.example.simplebank.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * DTO-класс для передачи основной информации для совершения операции по счету
 */
@Component
@Getter
@Setter
public class OperationDetails {
    private Long initiatorAccountId;
    private Long recipientAccountId;
    private String pin;
    private Long value;
}
