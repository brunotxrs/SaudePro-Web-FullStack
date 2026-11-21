package com.saudepro.repository;

import com.saudepro.entity.PacienteEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno-teixeira
 */

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, UUID>{
    
}
