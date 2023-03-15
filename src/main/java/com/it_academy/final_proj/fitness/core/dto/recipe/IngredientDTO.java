package com.it_academy.final_proj.fitness.core.dto.recipe;

import com.it_academy.final_proj.fitness.core.dto.product.ProductDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class IngredientDTO {
	private ProductDTO product;
	private Integer weight;
	private Integer calories;
	private BigDecimal proteins;
	private BigDecimal fats;
	private BigDecimal carbohydrates;

	private IngredientDTO(IngredientDTO dto) {
		this.product = dto.product;
		this.weight = dto.weight;
		this.calories = dto.calories;
		this.proteins = dto.proteins;
		this.fats = dto.fats;
		this.carbohydrates = dto.carbohydrates;
	}

	private IngredientDTO() {

	}

	public static IngredientDTOBuilder builder(){
		return new IngredientDTOBuilder();
	}

	public ProductDTO getProduct() {
		return product;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getCalories() {
		return calories;
	}

	public BigDecimal getProteins() {
		return proteins;
	}

	public BigDecimal getFats() {
		return fats;
	}

	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IngredientDTO that = (IngredientDTO) o;
		return Objects.equals(product, that.product)
				&& Objects.equals(weight, that.weight)
				&& Objects.equals(calories, that.calories)
				&& Objects.equals(proteins, that.proteins)
				&& Objects.equals(fats, that.fats)
				&& Objects.equals(carbohydrates, that.carbohydrates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, weight, calories, proteins, fats, carbohydrates);
	}

	@Override
	public String toString() {
		return "IngredientDTO{" +
				"product=" + product +
				", weight=" + weight +
				", calories=" + calories +
				", proteins=" + proteins +
				", fats=" + fats +
				", carbohydrates=" + carbohydrates +
				'}';
	}

	public static class IngredientDTOBuilder {

		private final IngredientDTO ingredient = new IngredientDTO();

		public IngredientDTOBuilder setProduct(ProductDTO product) {
			ingredient.product = product;
			return this;
		}

		public IngredientDTOBuilder setWeight(Integer weight) {
			ingredient.weight = weight;
			return this;
		}

		public IngredientDTOBuilder setCalories(Integer calories) {
			ingredient.calories = calories;
			return this;
		}

		public IngredientDTOBuilder setProteins(BigDecimal proteins) {
			ingredient.proteins = proteins;
			return this;
		}

		public IngredientDTOBuilder setFats(BigDecimal fats) {
			ingredient.fats = fats;
			return this;
		}

		public IngredientDTOBuilder setCarbohydrates(BigDecimal carbohydrates) {
			ingredient.carbohydrates = carbohydrates;
			return this;
		}

		public IngredientDTO build(){
			return new IngredientDTO(ingredient);
		}
	}
}
