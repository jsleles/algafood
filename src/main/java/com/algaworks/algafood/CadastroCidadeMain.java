package com.algaworks.algafood;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class CadastroCidadeMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

		Estado estado  = new Estado();
		estado.setId(3L);
		Cidade cidade1 = new Cidade("Cidade do Tchê",estado);
		
		estado.setId(2L);
		Cidade cidade2 = new Cidade("Atualizando a cidade ID 2",estado);
		cidade2.setId(2L);

		cidadeRepository.salvar(cidade1);
		cidadeRepository.salvar(cidade2);

		List<Cidade> cidades = cidadeRepository.listar();
		for (Cidade cidade : cidades) {
			System.out.println(cidade);
		}

	}

}
