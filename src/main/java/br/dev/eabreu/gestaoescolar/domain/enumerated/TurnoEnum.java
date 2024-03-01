package br.dev.eabreu.gestaoescolar.domain.enumerated;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TurnoEnum {

	M("Manhã"),
	T("Tarde"),
	N("Noite");
	
	@Getter
	private String turno;
}