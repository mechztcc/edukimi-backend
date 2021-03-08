package com.edukimi.api.repositories;

import com.edukimi.api.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
