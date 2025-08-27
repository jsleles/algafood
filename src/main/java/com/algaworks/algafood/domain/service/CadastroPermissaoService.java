package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao salvar(Permissao permissao) {
		return (permissaoRepository.save(permissao));
	}

	public void excluir(Long permissaoId) {
		Optional<Permissao> permissao = permissaoRepository.findById(permissaoId);
		if (permissao.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não foi possível encontrar a permissão com código %d", permissaoId));
		}
		try {
			permissaoRepository.deleteById(permissaoId);
		} catch (DataIntegrityViolationException e ){
			throw new EntidadeEmUsoException(String.format("Não foi possível excluir a permissão de código %d, pois está em uso.",permissaoId));
		}
	}
	
}
