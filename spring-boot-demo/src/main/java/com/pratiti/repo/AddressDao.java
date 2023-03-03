package com.pratiti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
