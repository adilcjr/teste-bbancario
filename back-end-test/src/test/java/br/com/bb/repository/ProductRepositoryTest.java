package br.com.bb.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bb.entity.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testFindProductByCategoryIdOrderById() {
		
		List<Product> products = productRepository.findProductsByCategoryIdOrderById(1L);
		assertThat(products).isNotEmpty();
		
		products = productRepository.findProductsByCategoryIdOrderById(999L);
		assertThat(products).isEmpty();
	}

}
