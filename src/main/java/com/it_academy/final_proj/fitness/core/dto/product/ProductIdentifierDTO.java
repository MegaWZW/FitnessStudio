package com.it_academy.final_proj.fitness.core.dto.product;

import com.it_academy.final_proj.fitness.util.validators.annotations.UUIDConstraint;

import java.util.Objects;
import java.util.UUID;

public class ProductIdentifierDTO {
	@UUIDConstraint
	private UUID uuid;

	public ProductIdentifierDTO(UUID uuid) {
		this.uuid = uuid;
	}

	public ProductIdentifierDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductIdentifierDTO that = (ProductIdentifierDTO) o;
		return Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public String toString() {
		return "ProductIdentifierDTO{" +
				"productUUID=" + uuid +
				'}';
	}
}
