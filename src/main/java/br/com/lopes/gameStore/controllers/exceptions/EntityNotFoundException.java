package br.com.lopes.gameStore.controllers.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Entity not found on database."; 

	public EntityNotFoundException() {
		super(MESSAGE);
	}
}
