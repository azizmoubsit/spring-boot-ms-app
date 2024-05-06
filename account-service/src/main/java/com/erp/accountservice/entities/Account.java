package com.erp.accountservice.entities;

import java.time.LocalDate;

import com.erp.accountservice.enums.AccountType;
import com.erp.accountservice.models.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
