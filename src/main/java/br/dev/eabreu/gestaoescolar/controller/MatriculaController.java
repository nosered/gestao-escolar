package br.dev.eabreu.gestaoescolar.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dev.eabreu.gestaoescolar.domain.dto.MatriculaDTO;
import br.dev.eabreu.gestaoescolar.service.MatriculaService;

@RequestMapping("/matricula")
@RestController
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;
	
	@GetMapping
	public ResponseEntity<List<MatriculaDTO>> buscarTodasPorAno(@RequestParam(value = "ano", required = true) Integer ano) {
		List<MatriculaDTO> matriculasPorAno = matriculaService.buscarTodasPorAno(ano);
		return ResponseEntity.ok().body(matriculasPorAno);
	}
	
	@PostMapping(value = "/cadastro")
	public ResponseEntity<MatriculaDTO> cadastro(@RequestBody MatriculaDTO matricula) throws URISyntaxException {
		matricula = matriculaService.cadastro(matricula);
		return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<MatriculaDTO> buscar(@PathVariable(value = "codigo") Integer codigo) {
		MatriculaDTO matricula = matriculaService.buscar(codigo);
		return ResponseEntity.ok().body(matricula);
	}
}