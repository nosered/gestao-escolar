package br.dev.eabreu.gestaoescolar.domain.enumerated;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonSerialize(using = SerieSerializer.class)
public enum SerieEnum {

	I1("Infantil I"), I2("Infantil II"), I3("Infantil III"), I4("Infantil IV"), I5("Infantil V"),
	F1("Fundamental 1"), F2("Fundamental 2"), F3("Fundamental 3"), F4("Fundamental 4"), F5("Fundamental 5");
	
	@Getter
	@JsonValue
	private String serie;
}