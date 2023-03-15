package com.it_academy.final_proj.fitness.repository;

import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID>{
}
