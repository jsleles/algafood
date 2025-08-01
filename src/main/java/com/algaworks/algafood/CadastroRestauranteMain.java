package com.algaworks.algafood;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class CadastroRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		List<Restaurante> restaurantes = restauranteRepository.listar();

		Restaurante restaurante1 = new Restaurante("Sem criatividade", BigDecimal.valueOf(3.0)) ;
		Restaurante restaurante2 = new Restaurante("Criando outro Restaurante", BigDecimal.valueOf(4.5)) ;
		
		restauranteRepository.salvar(restaurante1);
		restauranteRepository.salvar(restaurante2);
		
		for (Restaurante restaurante : restaurantes) {
			System.out.println(restaurante);
		}

	}

}
