package com.saudepro.service;

import com.saudepro.dtos.UsersRequestDTO;
import com.saudepro.dtos.UsersResponseDTO;
import com.saudepro.entity.UsersEntity;
import com.saudepro.exception.ElementAlreadyExistsException;
import com.saudepro.exception.ElementNotFoundException;
import com.saudepro.repository.UsersRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruno-teixeira
 */
@Service
public class UsersService {
    
    private final UsersRepository repository; 
    private final PasswordEncoder passwordEncoder;
    
    public UsersService(UsersRepository ur, PasswordEncoder passwordEncoder){
	this.repository = ur;
	this.passwordEncoder = passwordEncoder;
    }
    
    // Lista todos os usuarios
    @Transactional(readOnly = true)
    public List<UsersResponseDTO> listAllUsers(){
	return repository.findAll().stream()
		.map(UsersResponseDTO::new).toList();
    }
    
    // Criando um novo usuario
    @Transactional
    public UsersResponseDTO createNewUser(UsersRequestDTO urdto){
	
	if(repository.existsByLogin(urdto.login())){
	    throw new ElementAlreadyExistsException("Já existe um usuário com este login!");
	}
	
	UsersEntity usersEntity = new UsersEntity();
	
	if(repository.existsByLogin(urdto.login()) && !usersEntity.getLogin().equals(urdto.login())){
	    throw new ElementAlreadyExistsException("Este login já está em uso por outro usuário!");
	}
	
	usersEntity.setNome(urdto.nome());
	usersEntity.setSobreNome(urdto.sobreNome());
	usersEntity.setLogin(urdto.login());
	usersEntity.setTipo(urdto.tipo());
	
	// criptogranfando a senha
	String encryptedPassword = passwordEncoder.encode(urdto.senha());
	usersEntity.setSenha(encryptedPassword);
	
	UsersEntity newUser = repository.save(usersEntity);
	
	return new UsersResponseDTO(newUser);
	
    }
    
    // atualizando o usuario
    @Transactional
    public UsersResponseDTO updateUser(UUID id, UsersRequestDTO urdto){
	
	UsersEntity entity = repository.findById(id)
		.orElseThrow(() -> new ElementNotFoundException("Usuário não encontrado para atualização!"));
	
	if(repository.existsByLogin(urdto.login()) && !entity.getLogin().equals(urdto.login())){
	    throw new ElementAlreadyExistsException("Este login já está em uso por outro usuário!");
	}
	
	entity.setNome(urdto.nome());
	entity.setSobreNome(urdto.sobreNome());
	entity.setLogin(urdto.login());
	entity.setTipo(urdto.tipo());
	
	// criptogranfando a senha
	String encryptedPassword = passwordEncoder.encode(urdto.senha());
	entity.setSenha(encryptedPassword);
	
	UsersEntity upUser = repository.save(entity);
	
	return new UsersResponseDTO(upUser);
    }
    
    
    // buscando o Usuario pelo ID
    @Transactional(readOnly = true)
    public UsersResponseDTO searchUserById(UUID id){
	UsersEntity entity = repository.findById(id)
		.orElseThrow(() -> new ElementNotFoundException("Usuário não encontrado!"));
	
	return new UsersResponseDTO(entity);
    }
    
    @Transactional
    public UsersResponseDTO deleteUserById(UUID id){
	UsersEntity entity = repository.findById(id)
		.orElseThrow(() -> new ElementNotFoundException("Usuário não encontrado para ser deletado!"));
	
	repository.delete(entity);
	
	return new UsersResponseDTO(entity);
    }
    
    
}
