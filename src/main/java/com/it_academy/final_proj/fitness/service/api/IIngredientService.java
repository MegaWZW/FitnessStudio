package com.it_academy.final_proj.fitness.service.api;

import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;

import java.util.UUID;

public interface IIngredientService {
	IngredientEntity get(UUID uuid);
	void add(IngredientEntity entity);
}
