package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
    
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha>   tualizar(@PathVariable Long cozinhaId,
    		                 @RequestBody Cozinha cozinha) {
    	Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
    	if (cozinhaAtual != null) {
    		BeanUtils.copyProperties(cozinha, cozinhaAtual,"id");
    		cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
    		return ResponseEntity.ok(cozinhaAtual);
    	}
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover (@PathVariable Long cozinhaId){
    	Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
    	if (cozinha != null) {
            try {
            	cozinhaRepository.remover(cozinha);
	    		return ResponseEntity.noContent().build();
            } catch (DataIntegrityViolationException e) {
            	return ResponseEntity.status(HttpStatus.CONFLICT).build();
            	
            }
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
