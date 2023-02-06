package com.malay.shortyshoe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.PurchaseReport;
import com.malay.shortyshoe.repository.PurchaseReportRepository;

@Service
public class PurchaseReportService {
	@Autowired
	PurchaseReportRepository prRepository;
	
	
	// Get all purchase reports
	public List<PurchaseReport> getAllPurchaseReport(){
		return prRepository.findAll();
	}
	
	//Get a Purchase Report by id
	public Optional<PurchaseReport> findPrById(int id){
		return prRepository.findById(id);
	}
	
	
	//Create a Purchase Report
	public PurchaseReport createPurchaseReport(PurchaseReport pr) {
		return prRepository.save(pr);
	}
	
	
	// del a pr 
	public void deletePurchaseReport(int id ) throws BusinessException {
		if (prRepository.existsById(id)) prRepository.deleteById(id);
		else throw new BusinessException("Purchase report not found with given id");
		
	}
	
	
}
