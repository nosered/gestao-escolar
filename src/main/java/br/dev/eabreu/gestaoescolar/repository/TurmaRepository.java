package br.dev.eabreu.gestaoescolar.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import br.dev.eabreu.gestaoescolar.domain.Turma;

@UseClasspathSqlLocator
public interface TurmaRepository {

	@SqlQuery
	public Turma buscar(@Bind(value = "codigo") Integer codigo);
	
	@SqlQuery
	public List<Turma> buscarTodas();
}