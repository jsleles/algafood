package com.algaworks.algafood.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dataCadastro;
		
    @JsonIgnore
	@ManyToMany
	@JoinTable (name="usuario_grupo",
	           joinColumns = @JoinColumn(name="usuario_id"),
	           inverseJoinColumns = @JoinColumn(name="grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();
    
}
