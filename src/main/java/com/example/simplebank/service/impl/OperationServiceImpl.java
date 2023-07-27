package com.example.simplebank.service.impl;

import com.example.simplebank.model.Account;
import com.example.simplebank.model.OperationDetails;
import com.example.simplebank.model.OperationTypes;
import com.example.simplebank.service.AccountService;
import com.example.simplebank.service.OperationService;
import com.example.simplebank.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class OperationServiceImpl implements OperationService {

    private AccountService accountService;

    private ValidationService validationService;

    @Transactional
    @Override
    public ResponseEntity<Object> execute(String operationType, OperationDetails operationDetails) {
        switch (OperationTypes.valueOf(operationType.toUpperCase())) {
            case ADD:
                return addMoney(operationDetails);

            case WITHDRAW:
                return withdrawMoney(operationDetails);

            case TRANSFER:
                return transferMoney(operationDetails);

            default:
                throw new IllegalArgumentException("Operation type '" + operationType + "' not supported");
        }
    }

    private ResponseEntity<Object> addMoney(OperationDetails operationDetails) {
        if (!validationService.checkPinCode(operationDetails.getInitiatorAccountId(), operationDetails.getPin())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect pin code. Please try again.");
        }
        accountService.addMoney(operationDetails.getInitiatorAccountId(), operationDetails.getValue());
        return ResponseEntity.status(HttpStatus.OK).body("Success: money added.");
    }

    private ResponseEntity<Object> withdrawMoney(OperationDetails operationDetails) {
        if (!validationService.checkPinCode(operationDetails.getInitiatorAccountId(), operationDetails.getPin())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect pin code. Please try again.");
        }
        if (!validationService.checkBalance(operationDetails.getInitiatorAccountId(), operationDetails.getValue())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance.");
        }
        accountService.withdrawMoney(operationDetails.getInitiatorAccountId(), operationDetails.getValue());
        return ResponseEntity.status(HttpStatus.OK).body("Success: withdraw money.");
    }

    private ResponseEntity<Object> transferMoney(OperationDetails operationDetails) {
        Account accountInitiator = accountService.findAccountById(operationDetails.getInitiatorAccountId());
        Account accountRecipient = accountService.findAccountById(operationDetails.getRecipientAccountId());
        if (!validationService.checkPinCode(operationDetails.getInitiatorAccountId(), operationDetails.getPin())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect pin code. Please try again.");
        }
        if (!validationService.isValidAccountId(operationDetails.getRecipientAccountId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("RecipientAccount not found. Recipient accountId: " + operationDetails.getRecipientAccountId());
        }
        if (!validationService.checkBalance(operationDetails.getInitiatorAccountId(), operationDetails.getValue())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance.");
        }
        accountService.addMoney(accountRecipient.getId(), operationDetails.getValue());
        accountService.withdrawMoney(accountInitiator.getId(), operationDetails.getValue());
        return ResponseEntity.status(HttpStatus.OK).body("Success: transfer money.");
    }


}
