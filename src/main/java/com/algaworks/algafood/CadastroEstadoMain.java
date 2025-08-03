package com.algaworks.algafood;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class CadastroEstadoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

		Estado estado1 = new Estado("MG");
		Estado estado2 = new Estado("XXX");
		estado2.setId(3L);

		estadoRepository.salvar(estado1);
		estadoRepository.salvar(estado2);

		List<Estado> estados = estadoRepository.listar();
		for (Estado estado : estados) {
			System.out.println(estado);
		}

	}

}
