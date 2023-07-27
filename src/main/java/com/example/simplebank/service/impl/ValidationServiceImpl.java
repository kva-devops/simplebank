package com.example.simplebank.service.impl;

import com.example.simplebank.model.Account;
import com.example.simplebank.repository.AccountRepository;
import com.example.simplebank.repository.BeneficiaryRepository;
import com.example.simplebank.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private BeneficiaryRepository beneficiaryRepository;

    private AccountRepository accountRepository;

    @Override
    public boolean isValidPinCode(String pinCode) {
        return pinCode != null && pinCode.matches("\\d{4}");
    }

    @Override
    public boolean isValidBeneficiary(String beneficiaryName) {
        return beneficiaryRepository.findBeneficiaryByName(beneficiaryName) != null;
    }

    @Override
    public boolean checkPinCode(Long accountId, String pinCode) {
        Account account = accountRepository.findAccountById(accountId);
        return account.getPin().equals(pinCode);
    }

    @Override
    public boolean isValidAccountId(Long accountId) {
        return accountRepository.findAccountById(accountId) != null;
    }

    @Override
    public boolean checkBalance(Long accountId, Long value) {
        return accountRepository.findAccountById(accountId).getBalance() >= value;
    }
}
