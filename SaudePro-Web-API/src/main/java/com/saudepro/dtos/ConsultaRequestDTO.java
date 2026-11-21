package com.saudepro.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 */
public record ConsultaRequestDTO(
	
	@NotNull(message = "Informe o ID do médico!")
	UUID medicoId,
	
	@NotNull(message = "Informe o ID do paciente!")
	UUID pacienteId,
	
	@NotNull(message = "Informe a Data e a Hora!")
	@Future(message = "A consulta deve ser agendada para uma data futura")
	LocalDateTime dataHora,
	
	String observacao
	
	
) {}
