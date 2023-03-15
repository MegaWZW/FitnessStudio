package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.product.ProductWithWeightDTO;
import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import com.it_academy.final_proj.fitness.service.api.IProductService;
import org.springframework.core.convert.converter.Converter;

public class ProductWithWeightDTOToIngredientEntity implements Converter<ProductWithWeightDTO, IngredientEntity> {

	private IProductService productService;

	public ProductWithWeightDTOToIngredientEntity(IProductService productService){
		this.productService = productService;
	}

	@Override
	public IngredientEntity convert(ProductWithWeightDTO source) {
		ProductEntity productEntity = productService.get(source.getProduct().getUuid());
		IngredientEntity ingredientEntity = new IngredientEntity();
		ingredientEntity.setWeight(source.getWeight());
		ingredientEntity.setProduct(productEntity);
		return ingredientEntity;
	}
}
