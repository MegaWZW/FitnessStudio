package com.it_academy.final_proj.fitness.core.dto.error;

import com.it_academy.final_proj.fitness.core.exceptions.InvalidField;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StructuredErrorResponseDTO {
	private final String logref = "structured_error";
	private List<InvalidField> errors = new ArrayList<>();

	public StructuredErrorResponseDTO(){

	}

	public String getLogref() {
		return logref;
	}

	public List<InvalidField> getErrors() {
		return errors;
	}

	public void addError(InvalidField invalidField) {
		this.errors.add(invalidField);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StructuredErrorResponseDTO that = (StructuredErrorResponseDTO) o;
		return Objects.equals(errors, that.errors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logref, errors);
	}

	@Override
	public String toString() {
		return "StructuredErrorResponseDTO{" +
				"logref='" + logref + '\'' +
				", errors=" + errors +
				'}';
	}
}
