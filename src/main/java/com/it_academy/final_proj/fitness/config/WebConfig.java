package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.service.api.IProductService;
import com.it_academy.final_proj.fitness.util.converters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	private final IProductService productService;

	public WebConfig(IProductService productService){
		this.productService = productService;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new UserEntityToUserDTO());
		registry.addConverter(new UserCreateDTOToUserEntity());
		registry.addConverter(new LongToLocalDateTime());
		registry.addConverter(new ProductCreateDTOToProductEntity());
		registry.addConverter(new ProductEntityToProductDTO());
		registry.addConverter(new RecipeCreateDTOToRecipeEntity(new ProductWithWeightDTOToIngredientEntity(productService)));
		registry.addConverter(new IngredientEntityToIngredientDTO(new ProductEntityToProductDTO()));
		registry.addConverter(new ProductWithWeightDTOToIngredientEntity(productService));
		registry.addConverter(new RecipeEntityToRecipeDTO(new IngredientEntityToIngredientDTO(new ProductEntityToProductDTO())));
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}
