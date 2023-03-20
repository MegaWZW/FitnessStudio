package com.it_academy.final_proj.fitness.core.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * дто для самостоятельной регистрации пользователя
 */
public class UserRegistrationDTO {

	@NotBlank(message = "eMail должен быть заполнен")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "введён не eMail")
	private String mail;

	@NotBlank(message = "ФИО пользователя должно быть заполнено")
	private String fio;

	@NotBlank(message = "Пароль должен быть указан")
	@Size(min = 8, message = "Пароль должен иметь не менее 8 символов")
	private String password;

	public UserRegistrationDTO(String mail, String fio, String password) {
		this.mail = mail;
		this.fio = fio;
		this.password = password;
	}

	public UserRegistrationDTO(){

	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserRegistrationDTO that = (UserRegistrationDTO) o;
		return Objects.equals(mail, that.mail)
				&& Objects.equals(fio, that.fio)
				&& Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mail, fio, password);
	}

	@Override
	public String toString() {
		return "UserRegistrationDTO{" +
				"mail='" + mail + '\'' +
				", fio='" + fio + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
