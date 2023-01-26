package com.malay.shortyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malay.shortyshoe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
