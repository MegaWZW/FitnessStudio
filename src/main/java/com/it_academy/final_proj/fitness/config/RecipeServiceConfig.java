package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.repository.RecipeRepository;
import com.it_academy.final_proj.fitness.service.RecipeService;
import com.it_academy.final_proj.fitness.service.api.IRecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeServiceConfig {

	@Bean
	public IRecipeService recipeService(RecipeRepository repository) {
		return new RecipeService(repository);
	}
}
