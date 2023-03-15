package com.it_academy.final_proj.fitness.core.dto.product;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductCreateDTO {
	@NotBlank(message = "Название продукта должно быть заполнено")
	private String title;

	@NotNull(message = "Вес продукта не может быть пустым")
	@PositiveOrZero(message = "Вес продукта не может быть отрицательным числом")
	private Integer weight;

	@NotNull(message = "Количество калорий продукта не может быть пустым")
	@PositiveOrZero(message = "Количество калорий продукта не может быть отрицательным числом")
	private Integer calories;

	@NotNull(message = "Количество белков продукта не может быть пустым")
	@PositiveOrZero(message = "Количество белков продукта не может быть отрицательным числом")
	@Digits(integer = 9, fraction = 1, message = "Должно быть не более 9 цифр слева от запятой и не более 1 цифры справа от запятой")
	private BigDecimal proteins;

	@NotNull(message = "Количество жиров продукта не может быть пустым")
	@PositiveOrZero(message = "Количество жиров продукта не может быть отрицательным числом")
	@Digits(integer = 9, fraction = 1, message = "Должно быть не более 9 цифр слева от запятой и не более 1 цифры справа от запятой")
	private BigDecimal fats;

	@NotNull(message = "Количество углеводов продукта не может быть пустым")
	@PositiveOrZero(message = "Количество углеводов продукта не может быть отрицательным числом")
	@Digits(integer = 9, fraction = 1, message = "Должно быть не более 9 цифр слева от запятой и не более 1 цифры справа от запятой")
	private BigDecimal carbohydrates;

	public ProductCreateDTO(String title, Integer weight, Integer calories,
	                        BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
		this.title = title;
		this.weight = weight;
		this.calories = calories;
		this.proteins = proteins;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
	}

	public ProductCreateDTO(){

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public BigDecimal getProteins() {
		return proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
	}

	public BigDecimal getFats() {
		return fats;
	}

	public void setFats(BigDecimal fats) {
		this.fats = fats;
	}

	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductCreateDTO that = (ProductCreateDTO) o;
		return Objects.equals(title, that.title)
				&& Objects.equals(weight, that.weight)
				&& Objects.equals(calories, that.calories)
				&& Objects.equals(proteins, that.proteins)
				&& Objects.equals(fats, that.fats)
				&& Objects.equals(carbohydrates, that.carbohydrates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, weight, calories, proteins, fats, carbohydrates);
	}

	@Override
	public String toString() {
		return "ProductDTO{" +
				"title='" + title + '\'' +
				", weight=" + weight +
				", calories=" + calories +
				", proteins=" + proteins +
				", fats=" + fats +
				", carbohydrates=" + carbohydrates +
				'}';
	}
}
