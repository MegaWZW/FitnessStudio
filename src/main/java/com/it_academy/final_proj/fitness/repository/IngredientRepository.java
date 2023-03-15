package com.it_academy.final_proj.fitness.repository;

import com.it_academy.final_proj.fitness.db.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<IngredientEntity, UUID> {
}
