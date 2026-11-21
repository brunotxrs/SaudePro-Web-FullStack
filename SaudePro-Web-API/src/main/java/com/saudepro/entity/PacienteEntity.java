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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

/**
 *  
 * @author bruno-teixeira
 * 
 * @param Pacientes
 * 
 */


@Entity
@Table(name="pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class PacienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, length = 250)
    private String nome;
    
    @Column(nullable = false)
    private String sobreNome;

    @CPF(message = "CPF inválido")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private boolean primeiroAcesso = true;
    
    @OneToMany(mappedBy = "paciente")
    private List<ConsultaEntity> consultas = new ArrayList<>();
    
    private String telefone;
    
    @Email(message = "E-mail inválido")
    private String email;
    
    private String observacoes;
    
    // Para registro que foi salvo pela primeira vez no banco de dados
    @Column(nullable = false, updatable = false)
    private Instant criadoEm;

    @PrePersist
    public void prePersist() {
        this.criadoEm = Instant.now();
    }
    
}
