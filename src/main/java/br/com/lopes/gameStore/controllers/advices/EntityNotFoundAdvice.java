package br.com.lopes.gameStore.controllers.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.lopes.gameStore.controllers.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class EntityNotFoundAdvice {

	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handle(EntityNotFoundException error){
		return ResponseEntity.notFound().build();
	}
}
