package com.example.simplebank.service;

import com.example.simplebank.model.OperationDetails;
import org.springframework.http.ResponseEntity;

public interface OperationService {
    ResponseEntity<Object> execute(String operationType, OperationDetails operationDetails);
}
