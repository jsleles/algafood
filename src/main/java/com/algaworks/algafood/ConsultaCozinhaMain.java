package com.algaworks.algafood;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		

		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha("Italiana");
        cadastroCozinha.salvar(cozinha1);		
		Cozinha cozinha2 = new Cozinha("Japonesa");
        cadastroCozinha.salvar(cozinha2);		

        cozinha1 = new Cozinha("Brasileira");
        cozinha1.setId(1L);
        cadastroCozinha.salvar(cozinha1);
        
		Cozinha cozinhaRemove = new Cozinha();
		cozinhaRemove.setId(3L);
		cadastroCozinha.remover(cozinhaRemove.getId());
        
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha: cozinhas) {
			System.out.println(cozinha );
		}
		
		
		System.out.println("---------------------------\n");
		
		Cozinha cozinhaConsulta = cadastroCozinha.buscar(3L);
		System.out.println(cozinhaConsulta);
	}

}
