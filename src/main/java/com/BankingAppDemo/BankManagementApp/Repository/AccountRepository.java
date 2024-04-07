package com.BankingAppDemo.BankManagementApp.Repository;

import com.BankingAppDemo.BankManagementApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
