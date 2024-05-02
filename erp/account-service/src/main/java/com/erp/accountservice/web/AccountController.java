package com.erp.accountservice.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.erp.accountservice.clients.CustomerRestClient;
import com.erp.accountservice.entities.Account;
import com.erp.accountservice.models.Customer;
import com.erp.accountservice.repositories.AccountRepository;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        List<Account> accounts = accountRepository.findAll();

        accounts.forEach(account -> {
            Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        });

        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public Account geAccount(@PathVariable String id) {
        Account account = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);

        return account;
    }

}
