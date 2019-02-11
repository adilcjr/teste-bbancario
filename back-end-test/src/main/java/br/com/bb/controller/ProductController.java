package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.entity.Product;
import br.com.bb.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService; 
	
	@GetMapping("/teste")
	public String teste() {
		return "Teste 123";
	}
	
	@GetMapping("/listByCategory/{id}")
	public ResponseEntity<List<Product>> listByCategory(@PathVariable("id") long categoryId) {
		
		List<Product> products = productService.listByCategoryId(categoryId);
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
