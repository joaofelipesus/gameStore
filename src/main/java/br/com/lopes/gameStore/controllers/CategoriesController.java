package br.com.lopes.gameStore.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lopes.gameStore.controllers.forms.CategoryForm;
import br.com.lopes.gameStore.models.Category;
import br.com.lopes.gameStore.repositories.CategoryRepository;
import br.com.lopes.gameStore.services.categories.CategoryFinder;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public List<Category> index() {
		return categoryRepository.findAll();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Category> create(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
		Category category = form.toCategory();
		categoryRepository.save(category);
		URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> show(@PathVariable Long id) {
		Category category = new CategoryFinder(id, categoryRepository).call();
		return ResponseEntity.ok(category);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody CategoryForm form) {
		Category category = new CategoryFinder(id, categoryRepository).call();
		category.setName(form.getName());
		return ResponseEntity.ok(category);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		new CategoryFinder(id, categoryRepository).call();
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
