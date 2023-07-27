package com.example.simplebank.controller;

import com.example.simplebank.model.OperationDesc;
import com.example.simplebank.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST-контроллер для получения истории транзакций аккаунта
 */
@RestController
@RequestMapping("/histories")
@AllArgsConstructor
public class HistoryController {
    private HistoryService historyService;

    @GetMapping("/{accountId}")
    public ResponseEntity<List<OperationDesc>> getTransactionsHistory(@PathVariable Long accountId) {
        return historyService.findAllOperationDescByAccountId(accountId);
    }
}
