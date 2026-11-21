package com.saudepro.dtos;

import com.saudepro.entity.UsersEntity;
import com.saudepro.enums.Tipo;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author bruno-teixeira
 * 
 * @param ResponseDTO - 
 */
public record UsersResponseDTO(
	UUID id,
	String nome,
	String sobreNome,
	String login,
	Tipo tipo,
	Instant criadoEm
) {
    
    public UsersResponseDTO(UsersEntity usersEntity){
	this(
		usersEntity.getId(),
		usersEntity.getNome(),
		usersEntity.getSobreNome(),
		usersEntity.getLogin(),
		usersEntity.getTipo(),
		usersEntity.getCriadoEm()
	);
    }
}
