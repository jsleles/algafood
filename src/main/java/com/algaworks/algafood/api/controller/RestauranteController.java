package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>>  lista(){
		List<Restaurante> restaurante = restauranteRepository.listar();	
        return 	ResponseEntity.ok(restaurante);
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante>  busca(@PathVariable  Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		
		if (restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@RequestBody Restaurante restaurante) {
		 return restauranteRepository.salvar(restaurante);
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> atualizar (@PathVariable Long restauranteId, 
	                                              @RequestBody Restaurante restaurante		) {
		
		Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
		if (restauranteAtual != null) {
			BeanUtils.copyProperties(restaurante, restauranteAtual,"id");
			restauranteAtual =  restauranteRepository.salvar(restauranteAtual);
			return ResponseEntity.ok(restauranteAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> remover (@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		if (Objects.nonNull(restaurante)) {
			try {
				restauranteRepository.remover(restaurante);
				return ResponseEntity.noContent().build();
			} catch (DataIntegrityViolationException d) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
}
