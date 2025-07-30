package com.algaworks.alfafood;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.alfafood.domain.model.Cozinha;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		

		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha("Italiana");
        cadastroCozinha.adicionar(cozinha1);		
		Cozinha cozinha2 = new Cozinha("Japonesa");
        cadastroCozinha.adicionar(cozinha2);		

		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha: cozinhas) {
			System.out.println(cozinha );
		}
		
		
		System.out.println("---------------------------\n");
		
		Cozinha cozinhaConsulta = cadastroCozinha.buscar(3L);
		System.out.println(cozinhaConsulta);
	}

}
