package br.com.bb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.bb.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	//@Query("SELECT p FROM Product p WHERE p.category.id=:idCategory")
	List<Product> findProductByCategoryIdOrderById(long categoryId);

}
