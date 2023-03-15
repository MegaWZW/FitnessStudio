package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.repository.ProductRepository;
import com.it_academy.final_proj.fitness.service.ProductService;
import com.it_academy.final_proj.fitness.service.api.IProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceConfig {

	@Bean
	public IProductService productService(ProductRepository repository){
		return new ProductService(repository);
	}
}
