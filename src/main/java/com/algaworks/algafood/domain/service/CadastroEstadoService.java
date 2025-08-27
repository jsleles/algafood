package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar (Estado estado) {
		return estadoRepository.save(estado);
	}

	public void excluir(Long estadoId) {
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		if (estado.isEmpty() ) {
			throw new EntidadeNaoEncontradaException(String.format("Não foi possível encontrar o estado de número %d.", estadoId));
		}
		
		try {
			estadoRepository.deleteById(estadoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Não é possível excluir o estado de número %d, pois está em uso.", estadoId));
		}
	}
}
