package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.repository.IngredientRepository;
import com.it_academy.final_proj.fitness.service.IngredientService;
import com.it_academy.final_proj.fitness.service.api.IIngredientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IngredientServiceConfig {

	@Bean
	public IIngredientService ingredientService(IngredientRepository repository){
		return new IngredientService(repository);
	}
}
