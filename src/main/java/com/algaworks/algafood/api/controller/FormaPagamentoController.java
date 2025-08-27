package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formaPagamentos")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@GetMapping
	public ResponseEntity<List<FormaPagamento>> listar() {
		List<FormaPagamento> formaPagamentos = formaPagamentoRepository.findAll();
		return ResponseEntity.ok(formaPagamentos);
	}

	@GetMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento>  busca(@PathVariable Long formaPagamentoId) {
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formaPagamentoId);
		
		if (formaPagamento.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(formaPagamento.get());
	}

	@PostMapping
	public ResponseEntity<FormaPagamento> incluir (@RequestBody FormaPagamento formaPagamento ) {
		formaPagamento  = cadastroFormaPagamentoService.salvar(formaPagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);		
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	public ResponseEntity<?> remover (@PathVariable Long formaPagamentoId) {
        try {
        	cadastroFormaPagamentoService.excluir(formaPagamentoId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
	}
   	
	@PutMapping("/{formaPagamentoId}")
   	public ResponseEntity<?> salvar(@RequestBody FormaPagamento formaPagamento, @PathVariable Long formaPagamentoId) {
   		Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(formaPagamentoId);
    	if (formaPagamentoAtual.isPresent()) {
    		BeanUtils.copyProperties(formaPagamento,formaPagamentoAtual.get(),"id");
    		try {
    			FormaPagamento formaPagamentoSalva = cadastroFormaPagamentoService.salvar(formaPagamentoAtual.get());
    			return ResponseEntity.ok(formaPagamentoSalva);		
    		} catch (EntidadeNaoEncontradaException e) {
    			return ResponseEntity.badRequest().body(e.getMessage());
    		}
    	}
    	return ResponseEntity.notFound().build();
   	}      
	
}
