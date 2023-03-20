package com.it_academy.final_proj.fitness.web.controllers;

import com.it_academy.final_proj.fitness.core.dto.user.UserDTO;
import com.it_academy.final_proj.fitness.core.dto.user.UserLoginDTO;
import com.it_academy.final_proj.fitness.core.dto.user.UserRegistrationDTO;
import com.it_academy.final_proj.fitness.core.dto.user.UserTokenCreate;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import com.it_academy.final_proj.fitness.service.UserHolder;
import com.it_academy.final_proj.fitness.service.api.IAccountService;
import com.it_academy.final_proj.fitness.web.utils.JwtTokenHandler;
import jakarta.validation.Valid;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
@Validated
public class AccountController {

	private final IAccountService accountService;
	private final ConversionService conversionService;
	private final JwtTokenHandler tokenHandler;
	private final UserHolder userHolder;

	public AccountController(IAccountService accountService, ConversionService conversionService,
	                         JwtTokenHandler tokenHandler, UserHolder userHolder){
		this.accountService = accountService;
		this.conversionService = conversionService;
		this.tokenHandler = tokenHandler;
		this.userHolder = userHolder;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/registration")
	public ResponseEntity<?> registration(@Valid @RequestBody UserRegistrationDTO dto){
		UserEntity userEntity = conversionService.convert(dto, UserEntity.class);
		accountService.register(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Пользователь зарегистрирован. " +
				"На указанный Вами почтовый адрес выслано письмо с кодом активации аккаунта");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/verification")
	public ResponseEntity<?> verification(
			@RequestParam(name = "code") String code,
			@RequestParam(name = "mail") String mail
	) {
		accountService.verify(code, mail);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Пользователь верифицирован");
	}

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public String login(@Valid @RequestBody UserLoginDTO dto){
		UserEntity entity = accountService.login(dto);
		UserTokenCreate userTokenCreate = conversionService.convert(entity, UserTokenCreate.class);
		return tokenHandler.generateAccessToken(userTokenCreate);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/me")
	public ResponseEntity<UserDTO> getMe(){
		String mail = userHolder.getUser().getMail();
		UserEntity userEntity = accountService.getCard(mail);
		UserDTO dto = conversionService.convert(userEntity, UserDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}
