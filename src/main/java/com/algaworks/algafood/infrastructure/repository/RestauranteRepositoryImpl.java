package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@Autowired
	EntityManager manager;
	
	@Override
	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		 Restaurante restaurante = buscar(id);
		 
		 if (restaurante == null) {
		    throw new EmptyResultDataAccessException(1);	 
		 }
		 
         manager.remove(restaurante);
	}

}
