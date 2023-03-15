package com.it_academy.final_proj.fitness.core.dto;

import java.util.Objects;
import java.util.Set;

/**
 * дто страницы с содержимым
 * @param <T>
 */
public class PageDTO<T> {
	private Integer number; //current page number
	private Integer size; //number of requested elements
	private Integer totalPages; //depends on page size
	private Long totalElements; //amount of T in general
	private boolean first; //is this page first
	private Integer numberOfElements; //number of elements in THIS page
	private boolean last; //is this page last
	private Set<T> content; //set of page elements

	private PageDTO(PageDTO<T> dto) {
		this.number = dto.number;
		this.size = dto.size;
		this.totalPages = dto.totalPages;
		this.totalElements = dto.totalElements;
		this.first = dto.first;
		this.numberOfElements = dto.numberOfElements;
		this.last = dto.last;
		this.content = dto.content;
	}

	private PageDTO(){

	}

	public static <T> PageBuilder<T> builder(){
		return new PageBuilder<T>();
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public boolean isFirst() {
		return first;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public boolean isLast() {
		return last;
	}

	public Set<T> getContent() {
		return content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PageDTO<?> pageDTO = (PageDTO<?>) o;
		return first == pageDTO.first
				&& last == pageDTO.last
				&& Objects.equals(number, pageDTO.number)
				&& Objects.equals(size, pageDTO.size)
				&& Objects.equals(totalPages, pageDTO.totalPages)
				&& Objects.equals(totalElements, pageDTO.totalElements)
				&& Objects.equals(numberOfElements, pageDTO.numberOfElements)
				&& Objects.equals(content, pageDTO.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, size, totalPages, totalElements, first, numberOfElements, last, content);
	}

	@Override
	public String toString() {
		return "PageDTO{" +
				"number=" + number +
				", size=" + size +
				", totalPages=" + totalPages +
				", totalElements=" + totalElements +
				", first=" + first +
				", numberOfElements=" + numberOfElements +
				", last=" + last +
				", content=" + content +
				'}';
	}

	public static class PageBuilder<T> {

		private final PageDTO<T> page = new PageDTO<>();

		public PageBuilder<T> setNumber(Integer number) {
			page.number = number;
			return this;
		}

		public PageBuilder<T> setSize(Integer size) {
			page.size = size;
			return this;
		}

		public PageBuilder<T> setTotalPages(Integer totalPages) {
			page.totalPages = totalPages;
			return this;
		}

		public PageBuilder<T> setTotalElements(Long totalElements) {
			page.totalElements = totalElements;
			return this;
		}

		public PageBuilder<T> setFirst(boolean first) {
			page.first = first;
			return this;
		}

		public PageBuilder<T> setNumberOfElements(Integer numberOfElements) {
			page.numberOfElements = numberOfElements;
			return this;
		}

		public PageBuilder<T> setLast(boolean last) {
			page.last = last;
			return this;
		}

		public PageBuilder<T> setContent(Set<T> content) {
			page.content = content;
			return this;
		}

		public PageDTO<T> build(){
			return new PageDTO<T>(page);
		}
	}
}
