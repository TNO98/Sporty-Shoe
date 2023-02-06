 package com.malay.shortyshoe.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malay.shortyshoe.exception.BusinessException;
import com.malay.shortyshoe.model.Customer;
import com.malay.shortyshoe.repository.UserRepository;

@Service
public class UserService {
	
	List<Customer> userList = null;
	
	@Autowired
	UserRepository userRepo;
	
//	@PostConstruct
//	public void Load_50_Users() {
//		
//		userList = IntStream.rangeClosed(1, 50)
//				.mapToObj(i-> User.builder()
//						.name("product"+ i)
//						.password("password" + i)
//						.email("user"+i+"@gmail.com")
//						.build()).collect(Collectors.toList());
//		userRepo.saveAll(userList);
//		
//	}
	
	
	// read all users
	public List<Customer> getAllUser(){
		
		return userRepo.findAll();
		
	}
	
	// search a user by id
	public Optional<Customer> getUserById(int id) throws BusinessException  {
		Optional<Customer> user = userRepo.findById(id);
		
		if(user.isPresent()) {
			
			return user;
		}
		else {
			throw new BusinessException("User not found with this id"+id);
		}
	}
	
	
	// save list of users
	public List<Customer> saveUsers(List<Customer> users){
		
		return userRepo.saveAll(users);
	
	}
	
	public Customer createSingleUser(Customer user) {
		return userRepo.save(user);
	}
	
	
	public Customer updateUser(int id, Customer user) throws BusinessException {
		
		Optional<Customer> userOpt=userRepo.findById(id);
		
		if(userOpt.isPresent()) {
			user.setId(id);
			return userRepo.save(user);	
		}	
		else {
			throw new BusinessException("User is not present with this id " + id);
		}
		
	}
	public void deleteUserById(int id ) {
		userRepo.deleteById(id);
	}

	

}
