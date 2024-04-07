package com.BankingAppDemo.BankManagementApp.service;

import com.BankingAppDemo.BankManagementApp.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber, Double amount);
    public Account withdrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
