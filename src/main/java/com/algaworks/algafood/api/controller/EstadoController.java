package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@GetMapping
	public ResponseEntity<List<Estado>> lista (){
		List<Estado> estados = estadoRepository.findAll();
		return ResponseEntity.ok(estados);
		
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado>  busca (@PathVariable  Long estadoId) {
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		if (estado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
        return ResponseEntity.ok(estado.get());		
	}

	@PostMapping
	public ResponseEntity<Estado> incluir(@RequestBody Estado estado) {
		estado = cadastroEstado.salvar(estado);
		return ResponseEntity.status(HttpStatus.CREATED).body(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> altera(@RequestBody Estado estado, @PathVariable Long estadoId) {
		Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);
		if (estadoAtual.isPresent()) {
			estadoAtual.get().setNome(estado.getNome());
			cadastroEstado.salvar(estadoAtual.get());
			return ResponseEntity.ok(estadoAtual.get());
		}
        return ResponseEntity.notFound().build();		
		
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> remover(@PathVariable Long estadoId) {
		try {
			cadastroEstado.excluir(estadoId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException  e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
		
	}
}
