package br.com.bb.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.bb.Application;
import br.com.bb.dto.ProductDTO;
import br.com.bb.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductServiceTest {
	
	@TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
  
        @Bean
        public IProductService productService() {
            return new ProductServiceImp();
        }
    }
	
	@Autowired
	IProductService productService;
	
	@Autowired
	ProductRepository productRepository;

	@Test
	public void createProductOk() {
		
		ProductDTO p = new ProductDTO();
		p.setName("Test");
		p.setCategoryId(1);
		
		Long newId = productService.createProduct(p);		
		assertEquals(productRepository.findOne(newId).getName(), p.getName());
	}
	
	@Test
	public void createProductWithCategoryNotFound() {
		
		ProductDTO p = new ProductDTO();
		p.setName("Test");
		p.setCategoryId(0);
		
		Long newId = productService.createProduct(p);		
		assertEquals(null, newId);
	}
	
	@Test
	public void createProductWithCategoryNull() {
		
		ProductDTO p = new ProductDTO();
		p.setName("Test");		
		
		Long newId = productService.createProduct(p);		
		assertEquals(null, newId);
	}

}
