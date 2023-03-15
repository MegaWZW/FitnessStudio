package com.it_academy.final_proj.fitness.service;

import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import com.it_academy.final_proj.fitness.repository.UserRepository;
import com.it_academy.final_proj.fitness.service.api.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


public class UserService implements IUserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public Page<UserEntity> getPage(Integer page, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize);
		return repository.findAll(pageRequest);
	}

	@Override
	public UserEntity get(UUID uuid) {
		return repository.getReferenceById(uuid);
	}

	@Override
	public void add(UserEntity entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public void delete(UUID uuid, LocalDateTime dtUpdate) {
		UserEntity entity = repository.getReferenceById(uuid);
		if(!entity.getDtUpdate().truncatedTo(ChronoUnit.MILLIS).equals(dtUpdate)) {
			throw new IllegalStateException("Пользователь был изменён ранее. Для удаления получите актуальную версию");
		}
		repository.delete(entity);
	}

	@Override
	public void update(UserEntity newUser, UUID uuid, LocalDateTime dtUpdate) {
		UserEntity user = repository.getReferenceById(uuid); //EntityNotFoundException
		if(!user.getDtUpdate().truncatedTo(ChronoUnit.MILLIS).equals(dtUpdate)) {
			throw new IllegalStateException("Пользователь был изменён ранее");
		}
		user.setMail(newUser.getMail());
		user.setFio(newUser.getFio());
		user.setRole(newUser.getRole());
		user.setStatus(newUser.getStatus());
		user.setPassword(newUser.getPassword());

		repository.saveAndFlush(user);
	}
}
