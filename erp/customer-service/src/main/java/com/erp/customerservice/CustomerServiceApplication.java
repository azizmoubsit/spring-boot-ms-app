package com.erp.customerservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erp.customerservice.entities.Customer;
import com.erp.customerservice.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.firstName("Aziz")
							.lastName("Moubsit")
							.email("azizmosbit@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Amine")
							.lastName("Modifiability")
							.email("amine@gmail.com")
							.build());

			customerRepository.saveAll(customers);
		};
	}

}
