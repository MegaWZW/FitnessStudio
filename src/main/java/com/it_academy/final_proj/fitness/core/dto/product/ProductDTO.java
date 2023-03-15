package com.it_academy.final_proj.fitness.core.dto.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it_academy.final_proj.fitness.db.entity.ProductEntity;
import com.it_academy.final_proj.fitness.util.serializers.LocalDateTimeToMillisCustomSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ProductDTO {
	private UUID uuid;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtCreate;

	@JsonSerialize(using = LocalDateTimeToMillisCustomSerializer.class)
	private LocalDateTime dtUpdate;

	private String title;
	private Integer weight;
	private Integer calories;
	private BigDecimal proteins;
	private BigDecimal fats;
	private BigDecimal carbohydrates;

	public ProductDTO(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
	                  String title, Integer weight, Integer calories,
	                  BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
		this.uuid = uuid;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.title = title;
		this.weight = weight;
		this.calories = calories;
		this.proteins = proteins;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
	}

	public ProductDTO(ProductEntity entity){
		this.uuid = entity.getUuid();
		this.dtCreate = entity.getDtCreate();
		this.dtUpdate = entity.getDtUpdate();
		this.title = entity.getTitle();
		this.weight = entity.getWeight();
		this.calories = entity.getCalories();
		this.proteins = entity.getProteins();
		this.fats = entity.getFats();
		this.carbohydrates = entity.getCarbohydrates();
	}

	public ProductDTO(){

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
		ProductDTO that = (ProductDTO) o;
		return Objects.equals(uuid, that.uuid)
				&& Objects.equals(dtCreate, that.dtCreate)
				&& Objects.equals(dtUpdate, that.dtUpdate)
				&& Objects.equals(title, that.title)
				&& Objects.equals(weight, that.weight)
				&& Objects.equals(calories, that.calories)
				&& Objects.equals(proteins, that.proteins)
				&& Objects.equals(fats, that.fats)
				&& Objects.equals(carbohydrates, that.carbohydrates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, dtCreate, dtUpdate, title, weight, calories, proteins, fats, carbohydrates);
	}

	@Override
	public String toString() {
		return "ProductDTO{" +
				"uuid=" + uuid +
				", dtCreate=" + dtCreate +
				", dtUpdate=" + dtUpdate +
				", title='" + title + '\'' +
				", weight=" + weight +
				", calories=" + calories +
				", proteins=" + proteins +
				", fats=" + fats +
				", carbohydrates=" + carbohydrates +
				'}';
	}
}
