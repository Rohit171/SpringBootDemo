package com.BankingAppDemo.BankManagementApp.service;

import com.BankingAppDemo.BankManagementApp.Repository.AccountRepository;
import com.BankingAppDemo.BankManagementApp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        Account account_save = repo.save(account);
        return account_save;
    }

    @Override
    public Account getDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account account_found=account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> accountList = repo.findAll();
        return accountList;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountpresent =account.get();
        Double totalBalance=accountpresent.getAccount_balance()+amount;
        accountpresent.setAccount_balance(totalBalance);
        repo.save(accountpresent);
        return accountpresent;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent=account.get();
       Double accountBalance= accountPresent.getAccount_balance()-amount;
       accountPresent.setAccount_balance(accountBalance);
       repo.save(accountPresent);

        return null;
    }

    @Override
    public void closeAccount(Long accountNumber) {
    getDetailsByAccountNumber(accountNumber);
    repo.deleteById(accountNumber);
    }
}
