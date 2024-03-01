package br.dev.eabreu.gestaoescolar.domain;

import java.time.LocalDateTime;

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
public class Matricula {
	
	private Integer codigo;
	
	private Aluno aluno;
	
	private Turma turma;
	
	private Boolean ativo;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;
}
