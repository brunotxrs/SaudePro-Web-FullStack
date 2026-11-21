package com.saudepro.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author bruno-teixeira
 * 
 * @param GlobalExceptionHandler - Central para exceptions
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    
    // Exceção 1: Conflito (409)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ProblemDetail handleElementAlreadyExists(ElementAlreadyExistsException ex){
	ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
		HttpStatus.CONFLICT, ex.getMessage()
	);
	
	problemDetail.setTitle("Conflito de Dados!");
	problemDetail.setProperty("timestamp", Instant.now());
	
	return problemDetail;
    }
    
    
    // Exceção 2: Não encontrado (404)
    @ExceptionHandler(ElementNotFoundException.class)
    public ProblemDetail handleElementNotFoundException(ElementNotFoundException ex){
	ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
		HttpStatus.NOT_FOUND, ex.getMessage()
	);
	
	problemDetail.setTitle("Recurso Não Encontrado");
	problemDetail.setProperty("timestamp", Instant.now());
	
	return problemDetail;
	
    }
    
}
