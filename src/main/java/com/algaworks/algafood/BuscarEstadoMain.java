package com.algaworks.algafood;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class BuscarEstadoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

		Estado estado = estadoRepository.buscar(1L);
		System.out.println(estado);
	}

}
