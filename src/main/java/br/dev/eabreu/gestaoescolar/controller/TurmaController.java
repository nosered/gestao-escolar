package br.dev.eabreu.gestaoescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.eabreu.gestaoescolar.domain.Turma;
import br.dev.eabreu.gestaoescolar.repository.TurmaRepository;

@RequestMapping(value = "/turma")
@RestController
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Turma> buscar(@PathVariable(value = "codigo") Integer codigo) {
		Turma turma = turmaRepository.buscar(codigo);
		return ResponseEntity.ok().body(turma);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Turma>> buscarTodas() {
		List<Turma> turmas = turmaRepository.buscarTodas();
		return ResponseEntity.ok().body(turmas);
	}
}