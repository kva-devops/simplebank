package com.example.simplebank.service.impl;

import com.example.simplebank.model.OperationLog;
import com.example.simplebank.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Override
    public List<OperationLog> findOperationsByAccountId(Long accountId) {
        return null;
    }
}
