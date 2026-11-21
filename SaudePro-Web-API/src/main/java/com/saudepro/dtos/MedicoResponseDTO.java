package com.saudepro.dtos;

import com.saudepro.entity.MedicoEntity;
import com.saudepro.enums.Sexo;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record MedicoResponseDTO(
    UUID id,
    String nome,
    String sobreNome,
    Sexo sexo,
    String especialidade,
    String crm,
    String telefone,
    String email,
    Instant criadoEm
	
) {
    public MedicoResponseDTO(MedicoEntity medicoEntity){
	this(
	    medicoEntity.getId(),
	    medicoEntity.getNome(),
	    medicoEntity.getSobreNome(),
	    medicoEntity.getSexo(),
	    medicoEntity.getEspecialidade(),
	    medicoEntity.getCrm(),
	    medicoEntity.getTelefone(),
	    medicoEntity.getEmail(),
	    medicoEntity.getCriadoEm()
	);
    }
}
