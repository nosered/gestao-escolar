package br.dev.eabreu.gestaoescolar.domain;

import java.time.LocalDateTime;

import br.dev.eabreu.gestaoescolar.domain.enumerated.SerieEnum;
import br.dev.eabreu.gestaoescolar.domain.enumerated.TurnoEnum;
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
public class Turma {

	private Integer codigo;
	
	private String nome;
	
	private Integer ano;
	
	private SerieEnum serie;
	
	private TurnoEnum turno;
	
	private Boolean ativo;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;
}