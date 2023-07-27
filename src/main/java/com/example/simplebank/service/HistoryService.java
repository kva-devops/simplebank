package com.example.simplebank.service;

import com.example.simplebank.model.OperationDesc;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HistoryService {

    void saveOperationDesc(OperationDesc operationDesc);

    ResponseEntity<List<OperationDesc>> findAllOperationDescByAccountId(Long accountId);

}
