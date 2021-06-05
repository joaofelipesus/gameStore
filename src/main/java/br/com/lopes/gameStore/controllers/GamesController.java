package br.com.lopes.gameStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
