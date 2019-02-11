package br.com.bb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.dto.ProductDTO;
import br.com.bb.entity.Category;
import br.com.bb.entity.Product;
import br.com.bb.repository.CategoryRepository;
import br.com.bb.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Product> listAll() {
		
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(p -> products.add(p));
		return products;
	}

	@Override
	public List<Product> listByCategoryId(long categoryId) {
		
		List<Product> products = productRepository.findProductsByCategoryIdOrderById(categoryId);
		return products;
	}

	@Override
	public Long createProduct(ProductDTO productDTO) {
		
		if (productDTO != null) {
			
			Category category = categoryRepository.findOne(productDTO.getCategoryId());
			if (category != null) {
				Product p = new Product();
				p.setName(productDTO.getName());
				p.setCategory(category);
				Product newProduct = productRepository.save(p);
				return newProduct.getId();
			}
		}
		return null;
	}
	
}
