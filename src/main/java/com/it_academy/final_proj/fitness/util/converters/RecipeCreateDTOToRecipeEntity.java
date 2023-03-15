package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.product.ProductWithWeightDTO;
import com.it_academy.final_proj.fitness.core.dto.recipe.RecipeCreateDTO;
import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import com.it_academy.final_proj.fitness.db.entity.RecipeEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class RecipeCreateDTOToRecipeEntity implements Converter<RecipeCreateDTO, RecipeEntity> {

	private final ProductWithWeightDTOToIngredientEntity converter;

	public RecipeCreateDTOToRecipeEntity(ProductWithWeightDTOToIngredientEntity converter){
		this.converter = converter;
	}

	@Override
	public RecipeEntity convert(RecipeCreateDTO source) {
		Set<IngredientEntity> ingredients = new HashSet<>();

		for(ProductWithWeightDTO item : source.getComposition()){
			IngredientEntity ingredient = converter.convert(item);
			ingredients.add(ingredient);
		}

		RecipeEntity recipe = new RecipeEntity();
		recipe.setDtCreate(LocalDateTime.now());
		recipe.setTitle(source.getTitle());
		recipe.setIngredients(ingredients);

		return recipe;
	}
}
