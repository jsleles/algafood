package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@GetMapping
	public List<Restaurante> lista(){
        return restauranteRepository.listar();		
	}

	@GetMapping("/{restauranteId}")
	public Restaurante busca(@PathVariable  Long restauranteId) {
		return restauranteRepository.buscar(restauranteId);
		
	}

}
