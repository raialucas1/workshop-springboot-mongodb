package com.raialucas.workshopmongo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.raialucas.workshopmongo.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandle {
     
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status=HttpStatus.NOT_FOUND;
		StandardError err= new StandardError(Instant.now(), status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}