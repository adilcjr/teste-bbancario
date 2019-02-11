package br.com.bb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.entity.Product;
import br.com.bb.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> listByCategoryId(long categoryId) {
		
		List<Product> products = productRepository.findProductsByCategoryIdOrderById(categoryId);
		return products;
	}
}
