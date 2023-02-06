package com.malay.shortyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malay.shortyshoe.model.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, Integer>{

}
