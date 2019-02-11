package br.com.bb.service;

import java.util.List;

import br.com.bb.entity.Product;

public interface IProductService {
	
	public List<Product> listByCategoryId(long categoryId);

}
