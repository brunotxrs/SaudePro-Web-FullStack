package com.saudepro.dtos;

import jakarta.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record DisponibilidadeRequestDTO(
	
	@NotNull(message = "Informe o ID do médico!")
	UUID medicoId,
	
	@NotNull(message = "Informe o horario de inicio")
	LocalTime horaInicio,
	
	@NotNull(message = "Informe o horario de final")
	LocalTime horaFim,
	
	DayOfWeek diaSemana
){}
