package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Restaurante () {
	}
	
	public Restaurante (String nome, BigDecimal taxaFrete) {
		this.nome = nome;
		this.taxaFrete = taxaFrete;
	}
}
