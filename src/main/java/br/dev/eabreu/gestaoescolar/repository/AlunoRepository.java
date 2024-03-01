package br.dev.eabreu.gestaoescolar.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import br.dev.eabreu.gestaoescolar.domain.Aluno;

@UseClasspathSqlLocator
public interface AlunoRepository {
	
	@SqlQuery
	public Aluno buscar(@Bind(value = "codigo") Integer codigo);

	@SqlQuery
	public List<Aluno> buscarTodos();
}