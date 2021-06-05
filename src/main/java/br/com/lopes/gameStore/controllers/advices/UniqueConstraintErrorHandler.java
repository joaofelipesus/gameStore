package br.com.lopes.gameStore.controllers.advices;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UniqueConstraintErrorHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public String handle(ConstraintViolationException error) {
		return "Operação não pode ser realizada, pois fére cláusula de integridade";
	}
	
}
