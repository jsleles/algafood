package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class Teste {

	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@GetMapping("/nome")
	public List<Cozinha> porNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/restaurante/por-frete")
	public List<Restaurante> porFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurante/por-nome")
	public List<Restaurante> porNome(String nome, Long cozinhaId) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}
	
	
}
