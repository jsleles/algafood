package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
    @GetMapping
	public ResponseEntity<List<Cozinha>>   lista() {
        
    	List<Cozinha> cozinha = cozinhaRepository.listar();
    	return ResponseEntity.ok(cozinha);	
	}
    
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> busca(@PathVariable  Long cozinhaId) {
    	Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
        
    	if (cozinha != null) {
    		return ResponseEntity.ok(cozinha);
    	}
    	
//    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	return ResponseEntity.notFound().build();
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
    	return cozinhaRepository.salvar(cozinha);
    }
}
