package com.algaworks.algafood.infrainstructure.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RestauranteComFreteGratisSpec implements Specification<Restaurante>{

	private static final long serialVersionUID = 4614673164350524470L;

	@Override
	public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		return builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}

	
}
