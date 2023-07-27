package com.example.simplebank.service;

public interface ValidationService {
    boolean isValidPinCode(String pinCode);

    boolean isValidBeneficiary(String beneficiaryName);
    boolean checkPinCode(Long accountId, String pinCode);

    boolean isValidAccountId(Long accountId);

    boolean checkBalance(Long accountId, Long value);
}
