package com.example.simplebank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * DTO-класс для представления информации о счете, балансе и имени владельца
 */
@Component
@Data
@NoArgsConstructor
public class AccountInfo {
    private Long accountId;
    private String beneficiaryName;
    private Long balance;
}
