package com.saudepro.exception;

/**
 *
 * @author bruno-teixeira
 * 
 * Exceção de elemento já existente
 */
public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException(String mensage) {
	super(mensage);
    }
    
}
