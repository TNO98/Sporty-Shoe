package com.malay.shortyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malay.shortyshoe.model.Shoe;


@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer>{

}
