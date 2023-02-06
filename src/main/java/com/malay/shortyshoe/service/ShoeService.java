package com.malay.shortyshoe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.Shoe;
import com.malay.shortyshoe.repository.ShoeRepository;

@Service
public class ShoeService {
	
	@Autowired
	ShoeRepository shoeRepo;
	
	//get all the shoes 
	public List<Shoe> getAllShoe(){
		return shoeRepo.findAll();
	}
	
	
	// Search a single shoe by ID
	public Optional<Shoe> findShoeById(int id) {
		return shoeRepo.findById(id);
	}
	
	// Create a shoe
	public Shoe CreateShoe(Shoe shoe) {
		
		return shoeRepo.save(shoe);
	
	}
	
	//Update a Shoe
	public Shoe updateShoe(int id, Shoe shoe) throws BusinessException {
		
		if (shoeRepo.findById(id).isEmpty()) throw new BusinessException("No Shoe found for the given id");
		shoe.setId(id);	
		return shoeRepo.save(shoe);
	}
	
	//Delete a Shoe
	public void delShoe(int id ) throws BusinessException {
		if(shoeRepo.findById(id).isEmpty()) throw new BusinessException("Show not found with given id");
		shoeRepo.deleteById(id);
	}
	
	
	


}
