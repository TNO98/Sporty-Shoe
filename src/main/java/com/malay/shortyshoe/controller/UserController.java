package com.malay.shortyshoe.controller;

import java.util.List;
import java.util.Optional;

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
import com.malay.shortyshoe.model.Customer;
import com.malay.shortyshoe.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllUsers() throws BusinessException {

		List<Customer> userList = userService.getAllUser();
		if (userList!=null) return ResponseEntity.ok(userList);
		throw new BusinessException("No users available");
	}

	@PostMapping("/")
	public ResponseEntity<Customer> createUser(@RequestBody Customer user) {

		Customer user1 = userService.createSingleUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getUserById(@PathVariable int id) throws BusinessException {
		Optional<Customer> user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateUser(@PathVariable int id, @RequestBody Customer updatedUser)
			throws BusinessException {
		Customer user = userService.updateUser(id, updatedUser);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	

}
