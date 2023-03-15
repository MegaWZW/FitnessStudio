package com.it_academy.final_proj.fitness.core.dto.error;

import java.util.Objects;

public class ErrorResponseDTO {
	private final String logref = "error";
	private String message;

	public ErrorResponseDTO(String message) {
		this.message = message;
	}

	public ErrorResponseDTO(){

	}

	public String getLogref() {
		return logref;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ErrorResponseDTO that = (ErrorResponseDTO) o;
		return Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logref, message);
	}

	@Override
	public String toString() {
		return "ErrorResponseDTO{" +
				"logref='" + logref + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
