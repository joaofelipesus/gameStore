package br.com.lopes.gameStore.services.consoles;

import java.util.Optional;

import br.com.lopes.gameStore.controllers.exceptions.EntityNotFoundException;
import br.com.lopes.gameStore.models.Console;
import br.com.lopes.gameStore.repositories.ConsoleRepository;

public class ConsoleFinder {
	private Long id;
	private ConsoleRepository repository;

	public ConsoleFinder(Long id, ConsoleRepository repository) {
		super();
		this.id = id;
		this.repository = repository;
	}

	public Console call() {
		Optional<Console> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException();
		}
	}
}
