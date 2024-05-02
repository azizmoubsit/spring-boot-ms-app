package com.erp.accountservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erp.accountservice.entities.Account;
import com.erp.accountservice.enums.AccountType;
import com.erp.accountservice.repositories.AccountRepository;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			List<Account> accounts = List.of(
					Account.builder()
							.customerId(Long.valueOf(1))
							.balance(10000)
							.type(AccountType.CURRENT_ACCOUNT)
							.createdAt(LocalDate.now())
							.currency("MAD")
							.build(),
					Account.builder()
							.customerId(Long.valueOf(1))
							.balance(3500)
							.type(AccountType.SAVING_ACCOUNT)
							.createdAt(LocalDate.now())
							.currency("MAD")
							.build(),
					Account.builder()
							.customerId(Long.valueOf(2))
							.balance(4000)
							.type(AccountType.CURRENT_ACCOUNT)
							.createdAt(LocalDate.now())
							.currency("MAD")
							.build(),
					Account.builder()
							.customerId(Long.valueOf(2))
							.balance(12500)
							.type(AccountType.SAVING_ACCOUNT)
							.createdAt(LocalDate.now())
							.currency("MAD")
							.build());

			accountRepository.saveAll(accounts);
		};
	}

}
