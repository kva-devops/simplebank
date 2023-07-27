package com.example.simplebank.service;

import com.example.simplebank.model.OperationLog;

import java.util.List;

public interface HistoryService {
    List<OperationLog> findOperationsByAccountId(Long accountId);
}
