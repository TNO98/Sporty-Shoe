package com.malay.shortyshoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.Shoe;
import com.malay.shortyshoe.service.ShoeService;


@RestController
@RequestMapping("/api/shoe")
public class ShoeController {
	
	
	@Autowired
	ShoeService shoeService;
	
	@GetMapping("/")
	public ResponseEntity<List<Shoe>> getAllShoe(){
		
		return ResponseEntity.ok(shoeService.getAllShoe());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Shoe> searchShoeById(@PathVariable int id){
		
		return ResponseEntity.ok(shoeService.findShoeById(id).orElseThrow());
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe){
		return ResponseEntity.status(HttpStatus.CREATED).body(shoeService.CreateShoe(shoe));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Shoe> updateShoe(@PathVariable int id, @RequestBody Shoe shoe) throws BusinessException{
		
		return ResponseEntity.ok(shoeService.updateShoe(id, shoe));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShoe(@PathVariable int id) throws BusinessException{
		
		shoeService.delShoe(id);
		return ResponseEntity.noContent().build();
	}
	
}
