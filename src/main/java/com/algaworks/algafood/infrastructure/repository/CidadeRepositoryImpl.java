package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository{

	@Autowired
	EntityManager manager;
	
	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	@Transactional
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	@Transactional
	public void remover(Long cidadeId) {
		Cidade cidade = buscar(cidadeId);
        if (cidade == null) {
        	throw new EmptyResultDataAccessException(1);
        }
		manager.remove(cidade);
	}

}
