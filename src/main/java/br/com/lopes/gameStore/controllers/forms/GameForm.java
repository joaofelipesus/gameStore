package br.com.lopes.gameStore.controllers.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.lopes.gameStore.models.Category;
import br.com.lopes.gameStore.models.Console;
import br.com.lopes.gameStore.models.Game;
import br.com.lopes.gameStore.repositories.CategoryRepository;
import br.com.lopes.gameStore.repositories.ConsoleRepository;

public class GameForm {
	@NotBlank
	private String title;
	@NotNull
	private BigDecimal price;
	@NotNull
	private Long categoryId;
	@NotNull
	private Long consoleId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getConsoleId() {
		return consoleId;
	}

	public void setConsoleId(Long consoleId) {
		this.consoleId = consoleId;
	}
	
	public Game parse(ConsoleRepository consoleRepository, CategoryRepository categoryRepository) {
		Game game = new Game();
		game.setTitle(title);
		game.setPrice(price);
		game.setCategory(findCategory(categoryRepository));
		game.setConsole(findConsoele(consoleRepository));
		return game;
	}
	
	private Console findConsoele(ConsoleRepository consoleRepository) {
		return consoleRepository.findById(consoleId).get();
	}
	
	private Category findCategory(CategoryRepository categoryRepository) {
		return categoryRepository.findById(categoryId).get();
	}

}
