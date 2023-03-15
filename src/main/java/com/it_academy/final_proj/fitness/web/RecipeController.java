package com.it_academy.final_proj.fitness.web;

import com.it_academy.final_proj.fitness.core.dto.PageDTO;
import com.it_academy.final_proj.fitness.core.dto.recipe.RecipeCreateDTO;
import com.it_academy.final_proj.fitness.core.dto.recipe.RecipeDTO;
import com.it_academy.final_proj.fitness.db.entity.RecipeEntity;
import com.it_academy.final_proj.fitness.service.api.IRecipeService;
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
@RequestMapping(path = "/api/v1/recipe")
@Validated
public class RecipeController {

	private final IRecipeService recipeService;
	private final ConversionService conversionService;

	public RecipeController(IRecipeService recipeService,
	                        ConversionService conversionService){
		this.recipeService = recipeService;
		this.conversionService = conversionService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeCreateDTO dto){
		RecipeEntity recipeEntity = conversionService.convert(dto, RecipeEntity.class);
		recipeService.add(recipeEntity);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Блюдо добавлено в справочник");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageDTO<RecipeDTO>> getPage(
			@RequestParam(name = "page", required = false)
			@PositiveOrZero(message = "Номер страницы не может быть отрицательным")
			Integer page,
			@RequestParam(name = "size", required = false)
			@Positive(message = "Размер страницы должен быть больше нуля")
			Integer size){

		Page<RecipeEntity> recipes = recipeService.getPage(page, size);
		Set<RecipeDTO> recipesSet = new HashSet<>();
		for(RecipeEntity item : recipes.getContent()){
			RecipeDTO dto = conversionService.convert(item, RecipeDTO.class);
			recipesSet.add(dto);
		}

		PageDTO.PageBuilder<RecipeDTO> builder = PageDTO.builder();
		PageDTO<RecipeDTO> pageOfRecipes = builder.setNumber(recipes.getNumber())
				.setSize(recipes.getSize())
				.setTotalPages(recipes.getTotalPages())
				.setTotalElements(recipes.getTotalElements())
				.setFirst(recipes.isFirst())
				.setLast(recipes.isLast())
				.setNumberOfElements(recipes.getNumberOfElements())
				.setContent(recipesSet)
				.build();

		return ResponseEntity.status(HttpStatus.OK).body(pageOfRecipes);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{uuid}/dt_update/{dt_update}")
	public ResponseEntity<?> updateRecipe(@PathVariable(name = "uuid") UUID uuid,
	                                       @PathVariable(name = "dt_update") Long dtUpdate,
	                                      @Valid @RequestBody RecipeCreateDTO dto) {
		RecipeEntity entity = conversionService.convert(dto, RecipeEntity.class);
		LocalDateTime dt = conversionService.convert(dtUpdate, LocalDateTime.class);
		recipeService.update(entity, uuid, dt);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Рецепт обновлён");
	}
}
