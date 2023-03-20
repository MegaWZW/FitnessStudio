package com.it_academy.final_proj.fitness.core.dto.user;

import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserTokenCreate implements UserDetails {
	private String mail;
	private String role;
	private String fio;

	public UserTokenCreate(String mail, String role, String fio) {
		this.mail = mail;
		this.role = role;
		this.fio = fio;
	}

	public UserTokenCreate(UserEntity entity){
		this.mail = entity.getMail();
		this.role = entity.getRole().name();
		this.fio = entity.getFio();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public String getFio() {
		return fio;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> authority = new ArrayList<>();
		authority.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authority;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return fio;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
