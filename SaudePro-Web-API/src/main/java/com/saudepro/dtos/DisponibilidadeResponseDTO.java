package com.saudepro.dtos;

import com.saudepro.entity.DisponibilidadeEntity;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record DisponibilidadeResponseDTO(
    UUID id,
    UUID medicoId,
    String nomeMedico,
    LocalTime horaInicio,
    LocalTime horaFim,
    DayOfWeek diaSemana,
    Instant criadoEm
	
) { 
    
    public DisponibilidadeResponseDTO(DisponibilidadeEntity disponibilidadeEntity){
	this(
		disponibilidadeEntity.getId(),
		disponibilidadeEntity.getMedico().getId(),
		disponibilidadeEntity.getMedico().getNome(),
		disponibilidadeEntity.getHoraInicio(),
		disponibilidadeEntity.getHoraFim(),
		disponibilidadeEntity.getDiaSemana(),
		disponibilidadeEntity.getCriadoEm()
	);
    }

}
