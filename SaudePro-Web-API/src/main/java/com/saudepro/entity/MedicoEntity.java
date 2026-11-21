package com.saudepro.entity;

import com.saudepro.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author bruno-teixeira
 * 
 * @param Medicos
 * 
 */


@Entity
@Table(name="medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "crm")
public class MedicoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, length = 250)
    private String nome;
    
    @Column(nullable = false)
    private String sobreNome;

    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;
    
    @Column(nullable = false, length = 50)
    private String especialidade;
    
    @Column(nullable = false, unique = true, length = 20)
    private String crm;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(length = 100)
    @Email(message = "E-mail inválido")
    private String email;
   
    @OneToMany(mappedBy = "medico")
    private List<ConsultaEntity> consultas = new ArrayList<>();
    
    @OneToMany(mappedBy = "medico")
    private List<DisponibilidadeEntity> disponibilidades = new ArrayList<>();
    
    // Para registro que foi salvo pela primeira vez no banco de dados
    @Column(nullable = false, updatable = false)
    private Instant criadoEm;

    @PrePersist
    public void prePersist() {
        this.criadoEm = Instant.now();
    }
}

