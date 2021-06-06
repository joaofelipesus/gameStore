package br.com.lopes.gameStore.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import br.com.lopes.gameStore.controllers.exceptions.EntityNotFoundException;
import br.com.lopes.gameStore.controllers.forms.GameForm;
import br.com.lopes.gameStore.models.Game;
import br.com.lopes.gameStore.repositories.CategoryRepository;
import br.com.lopes.gameStore.repositories.ConsoleRepository;
import br.com.lopes.gameStore.repositories.Gamerepository;
import br.com.lopes.gameStore.services.games.UpdateGameService;

@RestController
@RequestMapping("/games")
public class GamesController {

	@Autowired
	private Gamerepository gameRepository;

	@Autowired
	private ConsoleRepository consoleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Game> index() {
		return gameRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Game> show(@PathVariable Long id) {
		Game game = findGame(id);
		return ResponseEntity.ok(game);
	}

	@Transactional
	@PostMapping
	public ResponseEntity<Game> create(@Valid @RequestBody GameForm form, UriComponentsBuilder uriBuilder) {
		Game game = form.parse(consoleRepository, categoryRepository);
		gameRepository.save(game);
		URI uri = uriBuilder.path("/games/${id}").build(game.getId());
		return ResponseEntity.created(uri).body(game);
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<Game> update(@PathVariable Long id, @Valid @RequestBody GameForm form) {
		Game game = findGame(id);
		new UpdateGameService(game, form, categoryRepository, consoleRepository).call();
		return ResponseEntity.ok(game);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		findGame(id);
		gameRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	private Game findGame(Long id) {
		Optional<Game> optional = gameRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException();
		}
	}

}
