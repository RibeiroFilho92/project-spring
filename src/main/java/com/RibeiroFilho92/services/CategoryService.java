package com.RibeiroFilho92.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RibeiroFilho92.domain.Category;
import com.RibeiroFilho92.repositories.CategoryRepository;
import com.RibeiroFilho92.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository rep;
	
	public Category find(Long ID) {
		Optional<Category> obj = rep.findById(ID);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found. ID: " + ID + ", type " + Category.class.getName()));
	}
	
}
