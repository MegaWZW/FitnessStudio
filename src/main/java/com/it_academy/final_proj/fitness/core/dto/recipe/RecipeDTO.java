package com.it_academy.final_proj.fitness.core.dto.recipe;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it_academy.final_proj.fitness.util.serializers.LocalDateTimeToMillisCustomSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class RecipeDTO {
	private UUID uuid;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtCreate;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtUpdate;

	private String title;
	private Set<IngredientDTO> composition;
	private Integer weight;
	private Integer calories;
	private BigDecimal proteins;
	private BigDecimal fats;
	private BigDecimal carbohydrates;

	public RecipeDTO(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
	                 String title, Set<IngredientDTO> composition, Integer weight,
	                 Integer calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
		this.uuid = uuid;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.title = title;
		this.composition = composition;
		this.weight = weight;
		this.calories = calories;
		this.proteins = proteins;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
	}

	public RecipeDTO() {

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<IngredientDTO> getComposition() {
		return composition;
	}

	public void setComposition(Set<IngredientDTO> composition) {
		this.composition = composition;
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
		RecipeDTO recipeDTO = (RecipeDTO) o;
		return Objects.equals(uuid, recipeDTO.uuid)
				&& Objects.equals(dtCreate, recipeDTO.dtCreate)
				&& Objects.equals(dtUpdate, recipeDTO.dtUpdate)
				&& Objects.equals(title, recipeDTO.title)
				&& Objects.equals(composition, recipeDTO.composition)
				&& Objects.equals(weight, recipeDTO.weight)
				&& Objects.equals(calories, recipeDTO.calories)
				&& Objects.equals(proteins, recipeDTO.proteins)
				&& Objects.equals(fats, recipeDTO.fats)
				&& Objects.equals(carbohydrates, recipeDTO.carbohydrates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, dtCreate, dtUpdate, title, composition, weight, calories, proteins, fats, carbohydrates);
	}

	@Override
	public String toString() {
		return "RecipeDTO{" +
				"uuid=" + uuid +
				", dtCreate=" + dtCreate +
				", dtUpdate=" + dtUpdate +
				", title='" + title + '\'' +
				", composition=" + composition +
				", weight=" + weight +
				", calories=" + calories +
				", proteins=" + proteins +
				", fats=" + fats +
				", carbohydrates=" + carbohydrates +
				'}';
	}
}
