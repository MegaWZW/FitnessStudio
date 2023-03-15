package com.it_academy.final_proj.fitness.service.api;

import com.it_academy.final_proj.fitness.db.entity.RecipeEntity;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IRecipeService {
	Page<RecipeEntity> getPage(Integer page, Integer pageSize);
	RecipeEntity get(UUID uuid);
	void add(RecipeEntity entity);
	void delete(UUID uuid, LocalDateTime dtUpdate);
	void update(RecipeEntity newRecipe, UUID uuid, LocalDateTime dtUpdate);
}
