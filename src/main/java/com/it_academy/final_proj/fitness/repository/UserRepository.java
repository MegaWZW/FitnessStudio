package com.it_academy.final_proj.fitness.repository;

import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	Optional<UserEntity> findByMail(String mail);
}
