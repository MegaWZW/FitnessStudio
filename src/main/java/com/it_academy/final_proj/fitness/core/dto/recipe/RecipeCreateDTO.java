package com.it_academy.final_proj.fitness.core.dto.recipe;

import com.it_academy.final_proj.fitness.core.dto.product.ProductWithWeightDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

public class RecipeCreateDTO {
	@NotBlank(message = "Название рецепта не должно быть пустым")
	private String title;
	private Set<@Valid ProductWithWeightDTO> composition;

	public RecipeCreateDTO(String title, Set<ProductWithWeightDTO> composition) {
		this.title = title;
		this.composition = composition;
	}

	public RecipeCreateDTO(){

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<ProductWithWeightDTO> getComposition() {
		return composition;
	}

	public void setComposition(Set<ProductWithWeightDTO> composition) {
		this.composition = composition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RecipeCreateDTO that = (RecipeCreateDTO) o;
		return Objects.equals(title, that.title)
				&& Objects.equals(composition, that.composition);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, composition);
	}

	@Override
	public String toString() {
		return "RecipeCreateDTO{" +
				"title='" + title + '\'' +
				", productWithWeight=" + composition +
				'}';
	}
}
