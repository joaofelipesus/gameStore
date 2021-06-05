package br.com.lopes.gameStore.controllers.advices;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.lopes.gameStore.controllers.dtos.AttributeErrorDTO;

@RestControllerAdvice
public class EntityValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	private List<AttributeErrorDTO> errorMessages = new ArrayList<AttributeErrorDTO>();

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<AttributeErrorDTO> handle(MethodArgumentNotValidException error){
		var errorList = error.getBindingResult().getFieldErrors();
		errorList.forEach(attributeError ->  addErrorMessage(attributeError));
		return errorMessages;
	}
	
	private Locale currentLocation() {
		return LocaleContextHolder.getLocale();
	}
	
	private void addErrorMessage(FieldError fieldError) {
		String message = messageSource.getMessage(fieldError, currentLocation());
		AttributeErrorDTO error = new AttributeErrorDTO(fieldError.getField(), message);
		errorMessages.add(error);
	}
	
}
