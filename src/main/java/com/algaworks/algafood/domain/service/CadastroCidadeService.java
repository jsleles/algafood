package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		Estado estado = estadoRepository.buscar(cidade.getEstado().getId());
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(String.format("Não encontrou estado cadastrado com o código %d", cidade.getEstado().getId()));
		}
		
		cidade.setEstado(estado);
		cidadeRepository.salvar(cidade);
		Cidade cidadeSalva = cidadeRepository.buscar(cidade.getId());
		return cidadeSalva;
	}
	
	
	
}
