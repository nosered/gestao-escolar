package br.dev.eabreu.gestaoescolar.domain.dto;

import br.dev.eabreu.gestaoescolar.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {

	private Integer codigo;
	
	private Integer aluno;
	
	private Integer turma;
	
	public MatriculaDTO(Matricula matricula) {
		this.codigo = matricula.getCodigo();
		this.aluno = matricula.getAluno().getCodigo();
		this.turma = matricula.getTurma().getCodigo();
	}
}