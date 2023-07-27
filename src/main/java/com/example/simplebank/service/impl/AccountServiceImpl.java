package com.example.simplebank.service.impl;

import com.example.simplebank.model.Account;
import com.example.simplebank.model.AccountInfo;
import com.example.simplebank.repository.AccountRepository;
import com.example.simplebank.repository.BeneficiaryRepository;
import com.example.simplebank.service.AccountService;
import com.example.simplebank.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    BeneficiaryRepository beneficiaryRepository;

    ValidationService validationService;

    /**
     * Create new account
     * @param account
     * @return response status
     */
    @Override
    public ResponseEntity<Object> save(Account account) {
        if (!validationService.isValidBeneficiary(account.getBeneficiaryName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Beneficiary not found.");
        }
        if (!validationService.isValidPinCode(account.getPin())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pin code need 4 digits only.");
        }
        accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.OK).body("Success: account created. Account id = " + account.getId());
    }

    @Override
    public ResponseEntity<List<AccountInfo>> getInfoAboutAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountInfo> accountInfoList = new ArrayList<>();
        for (Account account : accountList) {
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountId(account.getId());
            accountInfo.setBalance(account.getBalance());
            accountInfo.setBeneficiaryName(account.getBeneficiaryName());
            accountInfoList.add(accountInfo);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountInfoList);
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public void addMoney(Long accountId, Long value) {
        accountRepository.addMoney(accountId, value);
    }

    @Override
    public void withdrawMoney(Long accountId, Long value) {
        accountRepository.withdrawMoney(accountId, value);
    }
}
