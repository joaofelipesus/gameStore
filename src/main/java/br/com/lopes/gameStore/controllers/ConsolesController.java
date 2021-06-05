package br.com.lopes.gameStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lopes.gameStore.models.Console;
import br.com.lopes.gameStore.repositories.ConsoleRepository;

@RestController
@RequestMapping("/consoles")
public class ConsolesController {

	@Autowired
	private ConsoleRepository consoleRepository;
	
	@GetMapping
	public List<Console> index(){
		return consoleRepository.findAll();
	}
}
