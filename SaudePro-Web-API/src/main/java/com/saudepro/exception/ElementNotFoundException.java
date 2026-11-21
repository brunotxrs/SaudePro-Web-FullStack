package com.saudepro.exception;

/**
 *
 * @author bruno-teixeira
 * 
 * Exceção de elemento nao encontrado
 */
public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String mensage) {
	super(mensage);
    }
    
}
