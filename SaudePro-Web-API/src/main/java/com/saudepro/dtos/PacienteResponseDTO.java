package com.saudepro.dtos;

import com.saudepro.entity.PacienteEntity;
import com.saudepro.enums.Sexo;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record PacienteResponseDTO(
   UUID id,
   String nome,
   String sobreNome,
   String cpf,
   LocalDate dataNascimento,
   Sexo sexo,
   boolean primeiroAcesso,
   String telefone,
   String email,
   String observacoes,
   Instant criadoEm
	
) {
    
    public PacienteResponseDTO(PacienteEntity pacienteEntity){
	this(
	    pacienteEntity.getId(),
            pacienteEntity.getNome(),
            pacienteEntity.getSobreNome(),
            pacienteEntity.getCpf(),
            pacienteEntity.getDataNascimento(),
            pacienteEntity.getSexo(),
            pacienteEntity.isPrimeiroAcesso(),
            pacienteEntity.getTelefone(),
            pacienteEntity.getEmail(),
            pacienteEntity.getObservacoes(),
	    pacienteEntity.getCriadoEm()
	);
    }
}
