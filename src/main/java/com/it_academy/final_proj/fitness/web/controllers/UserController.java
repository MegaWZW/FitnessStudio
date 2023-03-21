package com.it_academy.final_proj.fitness.web.controllers;

import com.it_academy.final_proj.fitness.core.dto.PageDTO;
import com.it_academy.final_proj.fitness.core.dto.user.UserCreateDTO;
import com.it_academy.final_proj.fitness.core.dto.user.UserDTO;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import com.it_academy.final_proj.fitness.service.api.IUserService;
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
@RequestMapping(path = "/api/v1/users")
@Validated
public class UserController {

	private final IUserService userService;
	private final ConversionService conversionService;

	public UserController(IUserService service, ConversionService conversionService) {
		this.userService = service;
		this.conversionService = conversionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageDTO<UserDTO>> getPage(
			@RequestParam(name = "page", required = false, defaultValue = "0")
			@PositiveOrZero(message = "Номер страницы не может быть отрицательным")
			Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "20")
			@Positive(message = "Размер страницы должен быть больше нуля")
			Integer size){

		Page<UserEntity> users = userService.getPage(page, size);
		Set<UserDTO> usersSet = new HashSet<>();
		for(UserEntity entity : users.getContent()) {
			UserDTO dto = conversionService.convert(entity, UserDTO.class);
			usersSet.add(dto);
		}

		PageDTO.PageBuilder<UserDTO> builder = PageDTO.builder();
		PageDTO<UserDTO> pageOfUsers = builder.setNumber(users.getNumber())
				.setSize(users.getSize())
				.setTotalPages(users.getTotalPages())
				.setTotalElements(users.getTotalElements())
				.setFirst(users.isFirst())
				.setLast(users.isLast())
				.setNumberOfElements(users.getNumberOfElements())
				.setContent(usersSet).build();

		return ResponseEntity.status(HttpStatus.OK).body(pageOfUsers);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@Valid @RequestBody UserCreateDTO dto){
		UserEntity entity = conversionService.convert(dto, UserEntity.class);
		userService.add(entity);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Пользователь добавлен");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{uuid}")
	public ResponseEntity<UserDTO> getUser(@PathVariable(name = "uuid") UUID uuid) {
		UserEntity entity = userService.get(uuid);
		UserDTO dto = conversionService.convert(entity, UserDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{uuid}/dt_update/{dt_update}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "uuid") UUID uuid,
	                                    @PathVariable(name = "dt_update") Long dtUpdate,
	                                   @Valid @RequestBody UserCreateDTO dto) {
		UserEntity entity = conversionService.convert(dto, UserEntity.class);
		LocalDateTime dt = conversionService.convert(dtUpdate, LocalDateTime.class);
		userService.update(entity, uuid, dt);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Пользователь изменён");
	}
}