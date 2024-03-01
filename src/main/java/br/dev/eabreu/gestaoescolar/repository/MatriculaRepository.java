package br.dev.eabreu.gestaoescolar.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import br.dev.eabreu.gestaoescolar.domain.Matricula;

@UseClasspathSqlLocator
public interface MatriculaRepository {

	@SqlUpdate
	@GetGeneratedKeys
	public Integer cadastro(@Bind(value = "aluno")Integer codigoAluno, @Bind(value = "turma") Integer codigoTurma);
	
	@SqlQuery
	public Matricula buscar(@Bind(value = "codigo") Integer codigo);
	
	@SqlQuery
	public List<Matricula> buscarTodasPorAno(@Bind(value = "ano") Integer ano);
}