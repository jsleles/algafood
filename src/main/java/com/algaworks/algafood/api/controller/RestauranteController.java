package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping
	public ResponseEntity<List<Restaurante>> lista() {
		List<Restaurante> restaurante = restauranteRepository.findAll();
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> busca(@PathVariable Long restauranteId) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);

		if (restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestaurante.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {

		Long cozinhaId = restaurante.getCozinha().getId();
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);

		if (cozinha.isEmpty()) {
			return ResponseEntity.badRequest()
					.body(String.format("Não existe cozinha cadastrada com o código : %d", cozinhaId));
		}

		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

		if (restauranteAtual.isPresent()) {
			BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id", "formasPagamento","endereco");
			Restaurante restauranteSalvo = cadastroRestaurante.salvar(restauranteAtual.get());
			return ResponseEntity.ok(restauranteSalvo);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> remover(@PathVariable Long restauranteId) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);

		if (restaurante.isPresent()) {
			try {
				cadastroRestaurante.excluir(restauranteId);
				return ResponseEntity.noContent().build();

			} catch (EntidadeEmUsoException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();

			} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

}
