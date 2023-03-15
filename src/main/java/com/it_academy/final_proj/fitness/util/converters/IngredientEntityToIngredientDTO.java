package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.product.ProductDTO;
import com.it_academy.final_proj.fitness.core.dto.recipe.IngredientDTO;
import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class IngredientEntityToIngredientDTO implements Converter<IngredientEntity, IngredientDTO> {

	private final ProductEntityToProductDTO converter;

	public IngredientEntityToIngredientDTO(ProductEntityToProductDTO converter){
		this.converter = converter;
	}

	@Override
	public IngredientDTO convert(IngredientEntity source) {
		ProductEntity productEntity = source.getProduct();
		ProductDTO productDTO = converter.convert(productEntity);
		IngredientDTO.IngredientDTOBuilder builder = IngredientDTO.builder();
		double productCalories = productEntity.getCalories();
		double productWeight = productEntity.getWeight();
		double entityWeight = source.getWeight();
		Integer ingredientCalories = (int)Math.round((productCalories / productWeight) * entityWeight);

		BigDecimal ingredientProteins = ((productEntity.getProteins().multiply(BigDecimal.valueOf(source.getWeight()).divide(BigDecimal.valueOf(productEntity.getWeight())).round(MathContext.DECIMAL32)))).setScale(1, RoundingMode.HALF_UP);

		BigDecimal ingredientFats = ((productEntity.getFats().multiply(BigDecimal.valueOf(source.getWeight()).divide(BigDecimal.valueOf(productEntity.getWeight()))).round(MathContext.DECIMAL32))).setScale(1, RoundingMode.HALF_UP);

		BigDecimal ingredientCarbs = ((productEntity.getCarbohydrates().multiply(BigDecimal.valueOf(source.getWeight())).divide(BigDecimal.valueOf(productEntity.getWeight()).round(MathContext.DECIMAL32)))).setScale(1, RoundingMode.HALF_UP);

		return builder.setProduct(productDTO)
				.setWeight(source.getWeight())
				.setCalories(ingredientCalories)
				.setProteins(ingredientProteins)
				.setFats(ingredientFats)
				.setCarbohydrates(ingredientCarbs).build();

	}
}
