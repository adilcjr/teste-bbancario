package br.com.bb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
	
	private long id;
	
	private String name;
	
	@JsonProperty("cat_id")
	private long categoryId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long catId) {
		this.categoryId = catId;
	}

}
