package com.example.simplebank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * DTO-класс для логгирования операций по счету
 */

@Component
@Data
@NoArgsConstructor
public class OperationLog {
    private Long id;
    private LocalDateTime localDateTime;
    private Long initiatorAccountId;
    private Long recipientAccountId;
    private String operation;
    private Long value;
    private Long initiatorAccountBalanceBefore;
    private Long initiatorAccountBalanceAfter;
    private Long recipientAccountBalanceBefore;
    private Long recipientAccountBalanceAfter;
}
