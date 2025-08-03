package com.algaworks.algafood;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class CadastroFormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);

		FormaPagamento formaPagamento1 = new FormaPagamento("Pagamento novo1");
		FormaPagamento formaPagamento2 = new FormaPagamento("Atualizando Pagamento id 1");
		formaPagamento2.setId(1L);
		
		formaPagamentoRepository.salvar(formaPagamento1);
		formaPagamentoRepository.salvar(formaPagamento2);

		
		List<FormaPagamento> formasPagamento = formaPagamentoRepository.listar();
		for (FormaPagamento formaPagamento : formasPagamento) {
			System.out.println(formaPagamento);
		}

	}

}
