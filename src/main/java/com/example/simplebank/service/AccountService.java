package com.example.simplebank.service;

import com.example.simplebank.model.Account;
import com.example.simplebank.model.AccountInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    ResponseEntity<Object> save(Account account);

    ResponseEntity<List<AccountInfo>> getInfoAboutAllAccounts();

    Account findAccountById(Long id);

    void addMoney(Long accountId, Long value);

    void withdrawMoney(Long accountId, Long value);
}
