package br.dev.eabreu.gestaoescolar.service;

import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.statement.UnableToExecuteStatementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.eabreu.gestaoescolar.domain.Matricula;
import br.dev.eabreu.gestaoescolar.domain.dto.MatriculaDTO;
import br.dev.eabreu.gestaoescolar.exception.AlunoJaMatriculadoException;
import br.dev.eabreu.gestaoescolar.repository.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	public MatriculaDTO cadastro(MatriculaDTO matricula) {
		try {
			Integer codigoMatricula = matriculaRepository.cadastro(matricula.getAluno(), matricula.getTurma());
			matricula.setCodigo(codigoMatricula);
			return matricula;
		} catch(UnableToExecuteStatementException exception) {
			if(exception.getMessage().contains("duplicate key value")) {
				throw new AlunoJaMatriculadoException();
			}
			
			throw exception;
		}
	}
	
	public MatriculaDTO buscar(Integer codigo) {
		Matricula matricula = matriculaRepository.buscar(codigo);
		return new MatriculaDTO(matricula);
	}
	
	public List<MatriculaDTO> buscarTodasPorAno(Integer ano) {
		List<Matricula> matriculasPorAno = matriculaRepository.buscarTodasPorAno(ano);
		List<MatriculaDTO> matriculasDTOPorAno = new ArrayList<MatriculaDTO>();
		matriculasPorAno.forEach(matricula -> {
			matriculasDTOPorAno.add(new MatriculaDTO(matricula));
		});
		
		return matriculasDTOPorAno;
	}
}