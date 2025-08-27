package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	public CidadeRepository cidadeRepository;
	
	@Autowired
	public EstadoRepository estadoRepository;
	
	public Cidade salva(Cidade cidade) {
		
		Optional<Estado> estado = estadoRepository.findById(cidade.getEstado().getId());
		if (estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não encontrou estado cadastrado com o código %d", cidade.getEstado().getId()));
		}
		cidade.setEstado(estado.get());
		cidadeRepository.save(cidade);
		Optional<Cidade> cidadeSalva = cidadeRepository.findById(cidade.getId());
		return cidadeSalva.get();
	}
	
	public void excluir(Long cidadeId) {
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		if (cidade.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não foi possível encontrar a cozinha de número %d.", cidadeId));
		}
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Não é possível excluir a cozinha de número %d, pois está em uso.", cidadeId));
		}
	}
}
