package com.eliezer.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eliezer.course.services.exception.ResourceNotFoundException;

//anotação para interceptar as execessões que ocorrerem para que esse objeto possa executar um possivel tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	//anotação para ser capaz de interceptar qualquer execessão do tipo ResourceNotFoundException que foi lançada
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
