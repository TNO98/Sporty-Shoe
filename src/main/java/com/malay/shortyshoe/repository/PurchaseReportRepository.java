package com.malay.shortyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malay.shortyshoe.model.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{

}
