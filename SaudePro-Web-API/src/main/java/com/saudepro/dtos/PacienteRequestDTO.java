package com.saudepro.dtos;

import com.saudepro.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;


/**
 *
 * @author bruno-teixeira
 */
public record PacienteRequestDTO(
	
    @NotBlank(message = "Informe um nome!")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    String nome,
    
    @NotBlank(message = "Informe um Sobrenome!")
    @Size(min = 2, max = 100, message = "O Sobrenome deve ter entre 2 e 100 caracteres")
    String sobreNome,
    
    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    String cpf,
    
    @NotNull(message = "Informe a Data de Nascimento")
    LocalDate dataNascimento,
    
    @NotNull(message = "Informe o sexo")
    Sexo sexo,

    @NotBlank(message = "Informe uma senha")
    String senha,

    String telefone,

    @Email(message = "E-mail inválido")
    String email,

    String observacoes
	
) {}
