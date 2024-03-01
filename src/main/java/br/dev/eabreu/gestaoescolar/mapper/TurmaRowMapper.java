package br.dev.eabreu.gestaoescolar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import br.dev.eabreu.gestaoescolar.domain.Turma;
import br.dev.eabreu.gestaoescolar.domain.enumerated.SerieEnum;
import br.dev.eabreu.gestaoescolar.domain.enumerated.TurnoEnum;

@Component
public class TurmaRowMapper implements RowMapper<Turma> {

	@Override
	public Turma map(ResultSet resultSet, StatementContext ctx) throws SQLException {
		return Turma.builder()
				.codigo(resultSet.getInt("codigo"))
				.nome(resultSet.getString("nome"))
				.ano(resultSet.getInt("ano"))
				.serie(SerieEnum.valueOf(resultSet.getString("serie")))
				.turno(TurnoEnum.valueOf(resultSet.getString("turno")))
				.ativo(resultSet.getBoolean("ativo"))
				.criadoEm(resultSet.getTimestamp("criadoEm").toLocalDateTime())
				.atualizadoEm(resultSet.getTimestamp("atualizadoEm").toLocalDateTime())
				.build();
	}
}