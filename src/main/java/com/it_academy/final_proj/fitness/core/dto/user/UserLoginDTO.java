package com.it_academy.final_proj.fitness.core.dto.user;

import java.util.Objects;

/**
 * дто для входа зарегистрированного пользователя
 */
public class UserLoginDTO {
	private String mail;
	private String password;

	public UserLoginDTO(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public UserLoginDTO(){

	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
		UserLoginDTO that = (UserLoginDTO) o;
		return Objects.equals(mail, that.mail)
				&& Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mail, password);
	}

	@Override
	public String toString() {
		return "UsedLoginDTO{" +
				"mail='" + mail + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
