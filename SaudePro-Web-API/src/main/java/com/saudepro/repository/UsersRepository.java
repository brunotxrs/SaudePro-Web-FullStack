package com.saudepro.repository;

import com.saudepro.entity.UsersEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


/**
 *
 * @author bruno-teixeira
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID>{
   
    boolean existsByLogin(String login); 
}
