package br.com.lopes.gameStore.controllers.forms;

import javax.validation.constraints.NotBlank;

import br.com.lopes.gameStore.models.Category;

public class CategoryForm {

	@NotBlank
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category toCategory() {
		return new Category(name);
	}
}
