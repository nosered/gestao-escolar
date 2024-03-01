package br.dev.eabreu.gestaoescolar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import br.dev.eabreu.gestaoescolar.domain.Aluno;

@Component
public class AlunoRowMapper implements RowMapper<Aluno>{

	@Override
	public Aluno map(ResultSet resultSet, StatementContext ctx) throws SQLException {
		return Aluno.builder()
				.codigo(resultSet.getInt("codigo"))
				.nome(resultSet.getString("nome"))
				.dataDeNascimento(resultSet.getDate("dataDeNascimento").toLocalDate())
				.responsavel(resultSet.getString("responsavel"))
				.contato(resultSet.getString("contato"))
				.ativo(resultSet.getBoolean("ativo"))
				.criadoEm(resultSet.getTimestamp("criadoEm").toLocalDateTime())
				.atualizadoEm(resultSet.getTimestamp("atualizadoEm").toLocalDateTime())
				.build();
	}
}