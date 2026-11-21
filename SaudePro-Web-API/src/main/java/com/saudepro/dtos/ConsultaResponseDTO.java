package com.saudepro.dtos;

import com.saudepro.entity.ConsultaEntity;
import com.saudepro.enums.StatusConsulta;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record ConsultaResponseDTO(
	UUID id,
	UUID medicoId,
	String nomeMedico,
	UUID pacienteId,
	String nomePaciente,
	LocalDateTime dataHora,
	StatusConsulta status,
	String observacao,
	Instant criadoEm
) {
    
    public ConsultaResponseDTO(ConsultaEntity consultaEntity){
	this(
		consultaEntity.getId(),
		consultaEntity.getMedico().getId(),
		consultaEntity.getMedico().getNome(),
		consultaEntity.getPaciente().getId(),
		consultaEntity.getPaciente().getNome(),
		consultaEntity.getDataHora(),
		consultaEntity.getStatus(),
		consultaEntity.getObservacao(),
		consultaEntity.getCriadoEm()
	);
    }
}
