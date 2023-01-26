package com.malay.shortyshoe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.User;
import com.malay.shortyshoe.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUser(){
		
		return userRepo.findAll();
		
	}
	
	public User getUserById(int id) throws BusinessException  {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isPresent()) {
			
			User user2=(User) user.stream().collect(Collectors.toList());
			return user2;
		}
		else {
			throw new BusinessException("User not found with this id"+id);
		}
	}

}
