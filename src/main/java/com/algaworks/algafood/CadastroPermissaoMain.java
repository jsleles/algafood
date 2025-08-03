package com.algaworks.algafood;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class CadastroPermissaoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);

		Permissao permissao1 = new Permissao("XPTO", "Descricao nova permissao");
		Permissao permissao2 = new Permissao("CON", "Descricao atualizando id 2");
		permissao2.setId(2L);

		permissaoRepository.salvar(permissao1);
		permissaoRepository.salvar(permissao2);

		List<Permissao> permissoes = permissaoRepository.listar();
		for (Permissao permissao : permissoes) {
			System.out.println(permissao);
		}

	}

}
