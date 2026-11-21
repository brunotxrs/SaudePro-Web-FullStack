package com.saudepro.dtos;

import com.saudepro.enums.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author bruno-teixeira
 * 
 * @param RequestDTO 
 */
public record UsersRequestDTO(
    
	@NotBlank(message = "Informe um nome")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
	String nome,
	
	@NotBlank(message = "Informe um sobrenome")
	@Size(min = 2, max = 100, message = "O Sobrenome deve ter entre 2 e 100 caracteres")
	String sobreNome,
	
	@NotBlank(message = "Informe um login!")
	@Size(min = 6, max = 100, message = "O login deve ter entre 6 e 100 caracteres")
	String login,
	
	@NotBlank(message = "Informe uma senha!")
	String senha,
	
	@NotNull(message = "Informe um tipo de Usuario!")
	Tipo tipo // Gerente | Recepcionista | Medico
	
) {}
