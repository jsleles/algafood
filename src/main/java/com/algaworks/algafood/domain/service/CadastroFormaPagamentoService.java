package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return (formaPagamentoRepository.save(formaPagamento));
	}

	public void excluir(Long formaPagamentoId) {
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formaPagamentoId);
		if (formaPagamento.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não foi possível encontrar a forma de pagamento com código %d", formaPagamentoId));
		}
		try {
			formaPagamentoRepository.deleteById(formaPagamentoId);
		} catch (DataIntegrityViolationException e ){
			throw new EntidadeEmUsoException(String.format("Não foi possível excluir a forma de pagemento de código %d, pois está em uso.",formaPagamentoId));
		}
	}
}
