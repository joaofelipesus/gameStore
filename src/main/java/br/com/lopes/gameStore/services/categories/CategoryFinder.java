package br.com.lopes.gameStore.services.categories;

import java.util.Optional;

import br.com.lopes.gameStore.controllers.exceptions.EntityNotFoundException;
import br.com.lopes.gameStore.models.Category;
import br.com.lopes.gameStore.repositories.CategoryRepository;

public class CategoryFinder {
	private Long id;
	private CategoryRepository repository;

	public CategoryFinder(Long id, CategoryRepository repository) {
		super();
		this.id = id;
		this.repository = repository;
	}

	public Category call() {
		Optional<Category> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException();
		}
	}
}
