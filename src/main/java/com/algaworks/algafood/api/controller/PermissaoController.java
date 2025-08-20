package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	private CadastroPermissaoService cadastroPermissaoService;
	
	@GetMapping
	public ResponseEntity<List<Permissao>> listar() {
		List<Permissao> permissoes = permissaoRepository.findAll();
		return ResponseEntity.ok(permissoes);
	}

	@GetMapping("/{permissaoId}")
	public ResponseEntity<Permissao>  busca(@PathVariable Long permissaoId) {
		Optional<Permissao> permissao = permissaoRepository.findById(permissaoId);
		
		if (permissao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(permissao.get());
	}

	@PostMapping
	public ResponseEntity<Permissao> incluir (@RequestBody Permissao permissao ) {
		permissao = cadastroPermissaoService.salvar(permissao);
		return ResponseEntity.status(HttpStatus.CREATED).body(permissao);		
	}
		
}
