package com.saudepro.repository;

import com.saudepro.entity.MedicoEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno-teixeira
 */

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, UUID>{
}
