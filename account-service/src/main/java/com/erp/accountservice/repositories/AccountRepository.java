package com.erp.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.erp.accountservice.entities.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {
}
