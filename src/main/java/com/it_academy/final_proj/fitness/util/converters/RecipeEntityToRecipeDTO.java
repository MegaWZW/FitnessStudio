package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.recipe.IngredientDTO;
import com.it_academy.final_proj.fitness.core.dto.recipe.RecipeDTO;
import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import com.it_academy.final_proj.fitness.db.entity.RecipeEntity;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class RecipeEntityToRecipeDTO implements Converter<RecipeEntity, RecipeDTO> {

	private final IngredientEntityToIngredientDTO converter;

	public RecipeEntityToRecipeDTO(IngredientEntityToIngredientDTO converter){
		this.converter = converter;
	}

	@Override
	public RecipeDTO convert(RecipeEntity source) {
		RecipeDTO recipeDTO = new RecipeDTO();
		int weight = 0;
		int calories = 0;
		BigDecimal proteins = BigDecimal.valueOf(0);
		BigDecimal fats = BigDecimal.valueOf(0);
		BigDecimal carbohydrates = BigDecimal.valueOf(0);
		Set<IngredientDTO> ingredients = new HashSet<>();
		for(IngredientEntity item : source.getIngredients()){
			IngredientDTO ingredientDTO = converter.convert(item);
			ingredients.add(ingredientDTO);
			weight = weight + ingredientDTO.getWeight();
			calories = calories + ingredientDTO.getCalories();
			proteins = proteins.add(ingredientDTO.getProteins());
			fats = fats.add(ingredientDTO.getFats());
			carbohydrates = carbohydrates.add(ingredientDTO.getCarbohydrates());
		}

		recipeDTO.setUuid(source.getUuid());
		recipeDTO.setDtCreate(source.getDtCreate());
		recipeDTO.setDtUpdate(source.getDtUpdate());
		recipeDTO.setTitle(source.getTitle());
		recipeDTO.setComposition(ingredients);
		recipeDTO.setWeight(weight);
		recipeDTO.setCalories(calories);
		recipeDTO.setProteins(proteins);
		recipeDTO.setFats(fats);
		recipeDTO.setCarbohydrates(carbohydrates);

		return recipeDTO;
	}
}
