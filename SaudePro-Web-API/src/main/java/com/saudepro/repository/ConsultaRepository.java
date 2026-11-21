package com.saudepro.repository;

import com.saudepro.entity.ConsultaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno-teixeira
 */
@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, UUID>{
    
}
