package com.it_academy.final_proj.fitness.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it_academy.final_proj.fitness.core.dto.user.UserCreateDTO;
import com.it_academy.final_proj.fitness.core.enums.Role;
import com.it_academy.final_proj.fitness.core.enums.Status;
import com.it_academy.final_proj.fitness.util.generators.VerificationCodeGenerator;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(schema = "fitness", name ="users")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid")
	private UUID uuid;

	@CreatedDate
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;

	@Version
	@Column(name = "dt_update")
	private LocalDateTime dtUpdate;

	@Column(name = "mail", unique = true)
	private String mail;

	@Column(name = "fio")
	private String fio;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "password")
	private String password;

	@JsonIgnore
	private String secret;

	public UserEntity(){

	}

	public UserEntity(UserCreateDTO dto){
		this.dtCreate = LocalDateTime.now();
		this.mail = dto.getMail();
		this.fio = dto.getFio();
		this.role = dto.getRole();
		this.status = dto.getStatus();
		this.password = dto.getPassword();
		this.secret = VerificationCodeGenerator.generate();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserEntity that = (UserEntity) o;
		return Objects.equals(uuid, that.uuid)
				&& Objects.equals(dtCreate, that.dtCreate)
				&& Objects.equals(dtUpdate, that.dtUpdate)
				&& Objects.equals(mail, that.mail)
				&& Objects.equals(fio, that.fio)
				&& role == that.role
				&& status == that.status
				&& Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, dtCreate, dtUpdate, mail, fio, role, status, password);
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"uuid=" + uuid +
				", dtCreate=" + dtCreate +
				", dtUpdate=" + dtUpdate +
				", mail='" + mail + '\'' +
				", fio='" + fio + '\'' +
				", role=" + role +
				", status=" + status +
				", password='" + password + '\'' +
				'}';
	}
}
