package com.it_academy.final_proj.fitness.core.dto.user;

import com.it_academy.final_proj.fitness.core.enums.Role;
import com.it_academy.final_proj.fitness.core.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * дто для создания нового пользователя
 */
public class UserCreateDTO {
	@NotBlank(message = "eMail должен быть заполнен")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "введён не eMail")
	private String mail;

	@NotBlank(message = "ФИО пользователя должно быть заполнено")
	private String fio;

	@NotNull(message = "Роль пользователя должна быть указана")
	private Role role;

	@NotNull(message = "Статус пользователя должен быть указан")
	private Status status;

	@NotBlank(message = "Пароль должен быть указан")
	@Size(min = 8, message = "Пароль должен иметь не менее 8 символов")
	private String password;

	public UserCreateDTO(String mail, String fio, Role role, Status status, String password) {
		this.mail = mail;
		this.fio = fio;
		this.role = role;
		this.status = status;
		this.password = password;
	}

	public UserCreateDTO(){

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		UserCreateDTO that = (UserCreateDTO) o;
		return Objects.equals(mail, that.mail)
				&& Objects.equals(fio, that.fio)
				&& role == that.role
				&& status == that.status
				&& Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mail, fio, role, status, password);
	}

	@Override
	public String toString() {
		return "UserCreateDTO{" +
				"mail='" + mail + '\'' +
				", fio='" + fio + '\'' +
				", role=" + role +
				", status=" + status +
				", password='" + password + '\'' +
				'}';
	}
}
