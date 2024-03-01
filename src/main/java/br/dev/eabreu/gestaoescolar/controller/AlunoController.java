package br.dev.eabreu.gestaoescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.eabreu.gestaoescolar.domain.Aluno;
import br.dev.eabreu.gestaoescolar.repository.AlunoRepository;

@RequestMapping(value = "/aluno")
@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Aluno> buscar(@PathVariable(value = "codigo") Integer codigo) {
		Aluno aluno = alunoRepository.buscar(codigo);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Aluno>> buscarTodos() {
		List<Aluno> alunos = alunoRepository.buscarTodos();
		return ResponseEntity.ok().body(alunos);
	}
}