package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {
	

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String nome;

	@Column(name="taxa_frete")
	private BigDecimal taxaFrete;
	
 	@ManyToOne
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;
 	
 	@ManyToMany
 	@JoinTable (name="restaurante_forma_pagamento",
 	     joinColumns = @JoinColumn(name="restaurante_id"),
 	     inverseJoinColumns = @JoinColumn(name="forma_pagamento_id"))
 	private List<FormaPagamento> formasPagamento = new ArrayList<>();

	public Restaurante () {
	}
	
	public Restaurante (String nome, BigDecimal taxaFrete) {
		this.nome = nome;
		this.taxaFrete = taxaFrete;
	}
}
