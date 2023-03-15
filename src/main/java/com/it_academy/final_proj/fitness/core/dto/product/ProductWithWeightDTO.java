package com.it_academy.final_proj.fitness.core.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public class ProductWithWeightDTO {
	@Valid
	private ProductIdentifierDTO product;

	@NotNull(message = "Вес ингредиента не может быть пустым")
	@Positive(message = "Вес ингредиента не может быть отрицательным числом или нулём")
	private Integer weight;

	public ProductWithWeightDTO(ProductIdentifierDTO product, Integer weight) {
		this.product = product;
		this.weight = weight;
	}

	public ProductWithWeightDTO(){

	}

	public ProductIdentifierDTO getProduct() {
		return product;
	}

	public void setProduct(ProductIdentifierDTO product) {
		this.product = product;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductWithWeightDTO that = (ProductWithWeightDTO) o;
		return Objects.equals(product, that.product) && Objects.equals(weight, that.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, weight);
	}

	@Override
	public String toString() {
		return "ProductWeightDTO{" +
				"identifier=" + product +
				", weight=" + weight +
				'}';
	}
}
