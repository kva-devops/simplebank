package com.example.simplebank.controller;

import com.example.simplebank.model.Account;
import com.example.simplebank.model.AccountInfo;
import com.example.simplebank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST-контроллер для работы с аккаунтом
 */
@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    /**
     * Create new account
     * @param account
     */
    @PostMapping("/")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
       return accountService.save(account);
    }

    /**
     * Getting information about all accounts
     * @return list of all accounts
     */
    @GetMapping("/info")
    public ResponseEntity<List<AccountInfo>> getInfoAboutAllAccounts() {
        return accountService.getInfoAboutAllAccounts();
    }

}
