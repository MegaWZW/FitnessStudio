package com.it_academy.final_proj.fitness.service;

import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import com.it_academy.final_proj.fitness.repository.IngredientRepository;
import com.it_academy.final_proj.fitness.service.api.IIngredientService;

import java.util.UUID;

public class IngredientService implements IIngredientService {

	private final IngredientRepository repository;

	public IngredientService(IngredientRepository repository){
		this.repository = repository;
	}

	@Override
	public IngredientEntity get(UUID uuid) {
		return repository.getReferenceById(uuid);
	}

	@Override
	public void add(IngredientEntity entity) {
		repository.saveAndFlush(entity);
	}
}
