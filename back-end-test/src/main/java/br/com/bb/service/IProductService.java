package br.com.bb.service;

import java.util.List;

import br.com.bb.dto.ProductDTO;
import br.com.bb.entity.Product;

public interface IProductService {
	
	/**
	 * List all products from database
	 * @return a {@link List} of {@link Product}, null otherwise
	 */
	public List<Product> listAll();
	
	/**
	 * List all products by a given category, if category doesn't exist returns null
	 * 
	 * @param categoryId - the id from category.
	 * @return the {@link List} of {@link Product}, null otherwise
	 */
	public List<Product> listByCategoryId(long categoryId);
	
	/**
	 * Create a new product.
	 * 
	 * @param productDTO - a {@link ProductDTO}
	 * @return the id from new product
	 */
	public Long createProduct(ProductDTO productDTO);

}
