package com.erp.accountservice.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.erp.accountservice.entities.Account;
import com.erp.accountservice.repositories.AccountRepository;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/id")
    public Account geAccount(@PathVariable String id) {
        return accountRepository.findById(id).get();
    }

}
