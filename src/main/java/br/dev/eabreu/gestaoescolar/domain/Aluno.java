package br.dev.eabreu.gestaoescolar.domain;

import java.time.LocalDate;
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
public class Aluno {

	private Integer codigo;
	
	private String nome;
	
	private LocalDate dataDeNascimento;
	
	private String responsavel;
	
	private String contato;
	
	private Boolean ativo;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;
}