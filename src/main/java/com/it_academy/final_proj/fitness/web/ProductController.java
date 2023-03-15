package com.it_academy.final_proj.fitness.web;

import com.it_academy.final_proj.fitness.core.dto.PageDTO;
import com.it_academy.final_proj.fitness.core.dto.product.ProductCreateDTO;
import com.it_academy.final_proj.fitness.core.dto.product.ProductDTO;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import com.it_academy.final_proj.fitness.service.api.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/product")
@Validated
public class ProductController {

	private final IProductService productService;
	private final ConversionService conversionService;

	public ProductController(IProductService productService, ConversionService conversionService) {
		this.productService = productService;
		this.conversionService = conversionService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductCreateDTO dto){
		ProductEntity entity = conversionService.convert(dto, ProductEntity.class);
		productService.add(entity);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Продукт был добавлен в справочник");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageDTO<ProductDTO>> getPage(
			@RequestParam(name = "page", required = false)
			@PositiveOrZero(message = "Номер страницы не может быть отрицательным")
			Integer page,
			@RequestParam(name = "size", required = false)
			@Positive(message = "Размер страницы должен быть больше нуля")
			Integer size){

		Page<ProductEntity> products = productService.getPage(page, size);
		Set<ProductDTO> productsSet = new HashSet<>();
		for(ProductEntity item : products.getContent()){
			ProductDTO dto = conversionService.convert(item, ProductDTO.class);
			productsSet.add(dto);
		}

		PageDTO.PageBuilder<ProductDTO> builder = PageDTO.builder();
		PageDTO<ProductDTO> pageOfProducts = builder.setNumber(products.getNumber())
				.setSize(products.getSize())
				.setTotalPages(products.getTotalPages())
				.setTotalElements(products.getTotalElements())
				.setFirst(products.isFirst())
				.setLast(products.isLast())
				.setNumberOfElements(products.getNumberOfElements())
				.setContent(productsSet)
				.build();

		return ResponseEntity.status(HttpStatus.OK).body(pageOfProducts);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{uuid}/dt_update/{dt_update}")
	public ResponseEntity<?> updateProduct(
			@PathVariable(name = "uuid") UUID uuid,
			@PathVariable(name = "dt_update") Long dtUpdate,
			@Valid @RequestBody ProductCreateDTO dto) {
		ProductEntity entity = conversionService.convert(dto, ProductEntity.class);
		LocalDateTime dt = conversionService.convert(dtUpdate, LocalDateTime.class);
		productService.update(entity, uuid, dt);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Продукт обновлён");
	}
}
