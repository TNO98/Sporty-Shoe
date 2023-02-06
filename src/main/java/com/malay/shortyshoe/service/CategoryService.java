package com.malay.shortyshoe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malay.shortyshoe.model.Category;
import com.malay.shortyshoe.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	 private  CategoryRepository categoryRepository;

	

	  public List<Category> getAllCategories() {
	    return categoryRepository.findAll();
	  }

	  public Category getCategoryById(Integer id) {
	    Optional<Category> optionalCategory = categoryRepository.findById(id);
	    return optionalCategory.orElse(null);
	  }

	  public Category createCategory(Category newCategory) {
	    return categoryRepository.save(newCategory);
	  }

	  public Category updateCategory(Integer id, Category updatedCategory) {
	    Optional<Category> optionalCategory = categoryRepository.findById(id);
	    if (!optionalCategory.isPresent()) {
	      return null;
	    }
	    Category category = optionalCategory.get();
	    category.setCategoryName(updatedCategory.getCategoryName());
	    return categoryRepository.save(category);
	  }

	  public boolean deleteCategory(Integer id) {
	    Optional<Category> optionalCategory = categoryRepository.findById(id);
	    if (!optionalCategory.isPresent()) {
	      return false;
	    }
	    categoryRepository.deleteById(id);
	    return true;
	  }

}
