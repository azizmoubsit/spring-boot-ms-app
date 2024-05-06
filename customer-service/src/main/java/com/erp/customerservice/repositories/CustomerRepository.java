package com.erp.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.erp.customerservice.entities.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
