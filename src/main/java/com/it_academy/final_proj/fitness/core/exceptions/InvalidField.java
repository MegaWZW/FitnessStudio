package com.it_academy.final_proj.fitness.core.exceptions;

import java.util.Objects;

public class InvalidField {
	private final String field;
	private final String message;

	public InvalidField(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InvalidField that = (InvalidField) o;
		return Objects.equals(field, that.field)
				&& Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(field, message);
	}

	@Override
	public String toString() {
		return "InvalidField{" +
				"field='" + field + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
