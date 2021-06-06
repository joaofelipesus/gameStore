package br.com.lopes.gameStore.services.games;

import br.com.lopes.gameStore.controllers.forms.GameForm;
import br.com.lopes.gameStore.models.Category;
import br.com.lopes.gameStore.models.Console;
import br.com.lopes.gameStore.models.Game;
import br.com.lopes.gameStore.repositories.CategoryRepository;
import br.com.lopes.gameStore.repositories.ConsoleRepository;
import br.com.lopes.gameStore.services.categories.CategoryFinder;
import br.com.lopes.gameStore.services.consoles.ConsoleFinder;

public class UpdateGameService {
	private Game game;
	private GameForm form;
	private CategoryRepository categoryRepository;
	private ConsoleRepository consoleRepository;

	public UpdateGameService(Game game, GameForm form, CategoryRepository categoryRepository, ConsoleRepository consoleRepository) {
		super();
		this.game = game;
		this.form = form;
		this.categoryRepository = categoryRepository;
		this.consoleRepository = consoleRepository;
	}

	public void call() {
		game.setTitle(form.getTitle());
		game.setPrice(form.getPrice());
		game.setCategory(findCategory());
		game.setConsole(findConsole());
	}
	
	private Console findConsole() {
		return new ConsoleFinder(form.getConsoleId(), consoleRepository).call();
	}
	
	private Category findCategory() {
		return new CategoryFinder(form.getCategoryId(), categoryRepository).call();
	}

}
