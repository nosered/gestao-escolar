package br.dev.eabreu.gestaoescolar.domain.dto;

import java.time.LocalDate;

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
public class AlunoDTO {

	private Integer codigo;
	
	private String nome;
	
	private LocalDate dataDeNascimento;
	
	private String responsavel;
	
	private String contato;
}