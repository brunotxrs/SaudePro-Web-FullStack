package com.saudepro.controller;

import com.saudepro.dtos.UsersRequestDTO;
import com.saudepro.dtos.UsersResponseDTO;
import com.saudepro.service.UsersService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno-teixeira
 */
@RestController
@RequestMapping("/usuarios")
public class UsersController {
    
    private final UsersService usersService;
    
    public UsersController(UsersService service){
	this.usersService = service;
    }
    
    // GET listar todos os usuarios
    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> allUsers(){
	List<UsersResponseDTO> usersResponseDTOs = usersService.listAllUsers();
	
	return ResponseEntity.ok(usersResponseDTOs);
    }
    
    // POST criando novo usuario
    @PostMapping
    public ResponseEntity<UsersResponseDTO> createUsers(
	    @RequestBody @Valid UsersRequestDTO requestDTO
    ){
	UsersResponseDTO responseDTO = usersService.createNewUser(requestDTO);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    
    // PUT atualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> updateUsers(@PathVariable UUID id, 
	    @RequestBody @Valid UsersRequestDTO requestDTO
    ){
	UsersResponseDTO responseDTO = usersService.updateUser(id, requestDTO);
	
	return ResponseEntity.ok(responseDTO);
    }
    
    // GET buscar usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> getUsersById(@PathVariable UUID id){
	UsersResponseDTO responseDTO = usersService.searchUserById(id);
	
	return ResponseEntity.ok(responseDTO);
    }
    
    // DELETE deletando o usuario po ID
    @DeleteMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> deleteUsersById(@PathVariable UUID id){
	UsersResponseDTO responseDTO = usersService.deleteUserById(id);
	
	return ResponseEntity.ok(responseDTO);
    }
    
    
}
