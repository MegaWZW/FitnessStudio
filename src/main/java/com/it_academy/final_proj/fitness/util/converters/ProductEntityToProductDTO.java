package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.product.ProductDTO;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductEntityToProductDTO implements Converter<ProductEntity, ProductDTO> {
	@Override
	public ProductDTO convert(ProductEntity source) {
		return new ProductDTO(source);
	}
}
