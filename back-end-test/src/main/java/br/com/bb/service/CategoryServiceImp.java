package br.com.bb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.entity.Category;
import br.com.bb.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		
		List<Category> categories = new ArrayList<Category>();		
		Iterable<Category> itCategories = categoryRepository.findAll();		
		itCategories.forEach(category -> categories.add(category));
		
		return categories;
	}
}
