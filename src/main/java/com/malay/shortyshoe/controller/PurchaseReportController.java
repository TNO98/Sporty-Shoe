package com.malay.shortyshoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.PurchaseReport;
import com.malay.shortyshoe.service.PurchaseReportService;


@RestController

@RequestMapping("/api/pr")
public class PurchaseReportController {
	
	@Autowired
	PurchaseReportService prService;
	
	@GetMapping("/")
	public ResponseEntity<List<PurchaseReport>> getAllPR(){
		List<PurchaseReport> prList = prService.getAllPurchaseReport();
		
		return  ResponseEntity.ok(prList);
		
	}
	@PostMapping("/")
	public ResponseEntity<PurchaseReport> createPr(@RequestBody PurchaseReport pr){
		
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(prService.createPurchaseReport(pr));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delPr(@PathVariable int id) throws BusinessException{
		
		prService.deletePurchaseReport(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PurchaseReport> getPrById(@PathVariable int id) {
		
		return ResponseEntity.ok(prService.findPrById(id).orElseThrow());
	}
		
		
		
}
