package com.example.simplebank.service.impl;

import com.example.simplebank.model.OperationDesc;
import com.example.simplebank.repository.HistoryRepository;
import com.example.simplebank.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository historyRepository;

    @Override
    public void saveOperationDesc(OperationDesc operationDesc) {
        historyRepository.save(operationDesc);
    }

    @Override
    public ResponseEntity<List<OperationDesc>> findAllOperationDescByAccountId(Long accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(historyRepository.findAllOperationByAccountId(accountId));
    }
}
