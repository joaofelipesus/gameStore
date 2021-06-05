package br.com.lopes.gameStore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lopes.gameStore.controllers.exceptions.EntityNotFoundException;
import br.com.lopes.gameStore.models.Category;
import br.com.lopes.gameStore.models.Game;
import br.com.lopes.gameStore.repositories.Gamerepository;

@RestController
@RequestMapping("/games")
public class GamesController {

	@Autowired
	private Gamerepository gameRepository;
	
	@GetMapping
	public List<Game> index(){
		return gameRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Game> show(@PathVariable Long id) {
		Game game = findGame(id);
		return ResponseEntity.ok(game);
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
