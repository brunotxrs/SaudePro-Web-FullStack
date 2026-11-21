package com.saudepro.dtos;

import com.saudepro.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author bruno-teixeira
 */
public record MedicoRequestDTO(
	@NotBlank(message = "Informe um nome!")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
	String nome,
	
	@NotBlank(message = "Informe um Sobrenome!")
	@Size(min = 2, max = 100, message = "O Sobrenome deve ter entre 2 e 100 caracteres")
	String sobreNome,
	
	@NotNull(message = "Informe o sexo")
	Sexo sexo,
	
	@NotBlank(message = "Informe a especialidade!")
	String especialidade,
	
	@NotBlank(message = "Informe o CRM!")
	@Size(max = 20, message = "O CRM deve ter no máximo 20 caracteres")
	String crm,
	
	String telefone,
	
	@Email(message = "E-mail inválido")
	String email
	
) {}
