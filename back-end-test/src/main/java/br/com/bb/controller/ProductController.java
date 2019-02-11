package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.dto.ProductDTO;
import br.com.bb.entity.Product;
import br.com.bb.service.IProductService;
import br.com.bb.utils.RestPreconditions;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Product>> listAll() {
		
		List<Product> products = productService.listAll();
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	@GetMapping("/listByCategory/{id}")
	public ResponseEntity<List<Product>> listByCategory(@PathVariable("id") long categoryId) {
		
		List<Product> products = productService.listByCategoryId(categoryId);
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Long> createProduct(@RequestBody ProductDTO productDTO) {
		
		RestPreconditions.checkNotNull(productDTO.getName(), "Nome do Produto");
		Long newId = productService.createProduct(productDTO);
		if (newId != null) {
			return new ResponseEntity<Long>(newId, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
