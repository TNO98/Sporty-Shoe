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
import com.malay.shortyshoe.model.Category;
import com.malay.shortyshoe.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCtegory(){
		
		return ResponseEntity.ok(categoryService.getAllCategories());
		
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
		
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> CreateCategory(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.createCategory(category));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id , @RequestBody Category updatedCategory) throws BusinessException{
		
		Category category =categoryService.getCategoryById(id);
		
		if(category!=null) {
			updatedCategory.setCategoryId(id);
			return ResponseEntity.ok(categoryService.createCategory(updatedCategory));
		}
		
		throw new BusinessException("Category not found with given id" + id);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id ) throws BusinessException{
		if (categoryService.deleteCategory(id)) return ResponseEntity.noContent().build();
		else throw new BusinessException("Category not found with given id " +id);
		
	}
	



}
