package br.dev.eabreu.gestaoescolar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import br.dev.eabreu.gestaoescolar.domain.Aluno;
import br.dev.eabreu.gestaoescolar.domain.Matricula;
import br.dev.eabreu.gestaoescolar.domain.Turma;

@Component
public class MatriculaRowMapper implements RowMapper<Matricula> {

	@Override
	public Matricula map(ResultSet resultSet, StatementContext ctx) throws SQLException {
		return Matricula.builder()
				.codigo(resultSet.getInt("codigo"))
				.aluno(Aluno.builder().codigo(resultSet.getInt("codigoAluno")).build())
				.turma(Turma.builder().codigo(resultSet.getInt("codigoTurma")).build())
				.ativo(resultSet.getBoolean("ativo"))
				.criadoEm(resultSet.getTimestamp("criadoEm").toLocalDateTime())
				.atualizadoEm(resultSet.getTimestamp("atualizadoEm").toLocalDateTime())
				.build();
	}
}