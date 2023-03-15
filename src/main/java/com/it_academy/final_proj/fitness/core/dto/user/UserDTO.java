package com.it_academy.final_proj.fitness.core.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it_academy.final_proj.fitness.core.enums.Role;
import com.it_academy.final_proj.fitness.core.enums.Status;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import com.it_academy.final_proj.fitness.util.serializers.LocalDateTimeToMillisCustomSerializer;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * дто для получения информации о существующем пользователе
 */
public class UserDTO {
	private UUID uuid;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtCreate;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtUpdate;

	private String mail;
	private String fio;
	private Role role;
	private Status status;

	public UserDTO(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
	               String mail, String fio, Role role, Status status) {
		this.uuid = uuid;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.mail = mail;
		this.fio = fio;
		this.role = role;
		this.status = status;
	}

	public UserDTO(UserEntity entity) {
		this.uuid = entity.getUuid();
		this.dtCreate = entity.getDtCreate();
		this.dtUpdate = entity.getDtUpdate();
		this.mail = entity.getMail();
		this.fio = entity.getFio();
		this.role = entity.getRole();
		this.status = entity.getStatus();
	}

	public UserDTO(){

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(LocalDateTime dtCreate) {
		this.dtCreate = dtCreate;
	}

	public LocalDateTime getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(LocalDateTime dtUpdate) {
		this.dtUpdate = dtUpdate;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserDTO userDTO = (UserDTO) o;
		return Objects.equals(uuid, userDTO.uuid)
				&& Objects.equals(dtCreate, userDTO.dtCreate)
				&& Objects.equals(dtUpdate, userDTO.dtUpdate)
				&& Objects.equals(mail, userDTO.mail)
				&& Objects.equals(fio, userDTO.fio)
				&& role == userDTO.role
				&& status == userDTO.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, dtCreate, dtUpdate, mail, fio, role, status);
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"uuid=" + uuid +
				", dtCreate=" + dtCreate +
				", dtUpdate=" + dtUpdate +
				", mail='" + mail + '\'' +
				", fio='" + fio + '\'' +
				", role=" + role +
				", status=" + status +
				'}';
	}
}
