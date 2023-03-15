package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.product.ProductCreateDTO;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductCreateDTOToProductEntity implements Converter<ProductCreateDTO, ProductEntity> {
	@Override
	public ProductEntity convert(ProductCreateDTO source) {
		return new ProductEntity(source);
	}
}
