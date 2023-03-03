package com.pratiti.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratiti.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer> {
	public Optional<Customer> findByEmail(String email);
	public boolean existsByEmail(String email);
	public Optional<Customer> findByEmailAndPassword(String email, String Password);
}
