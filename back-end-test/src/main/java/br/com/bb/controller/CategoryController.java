package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.entity.Category;
import br.com.bb.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Category>> listAll() {
		
		List<Category> categories = categoryService.getAllCategories();
		
		if (!categories.isEmpty()) {
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
