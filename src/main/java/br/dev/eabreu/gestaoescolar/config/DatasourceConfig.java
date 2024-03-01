package br.dev.eabreu.gestaoescolar.config;

import java.util.List;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import br.dev.eabreu.gestaoescolar.repository.AlunoRepository;
import br.dev.eabreu.gestaoescolar.repository.MatriculaRepository;
import br.dev.eabreu.gestaoescolar.repository.TurmaRepository;

@Configuration
public class DatasourceConfig {

	@Primary
	@Bean("postgresqlDS")
	@ConfigurationProperties(prefix = "spring.datasource.postgresql")
	public DataSource postgreSqlDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public Jdbi jdbi(@Qualifier("postgresqlDS") DataSource datasource, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
		TransactionAwareDataSourceProxy datasourceProxy = new TransactionAwareDataSourceProxy(datasource);
		Jdbi jdbi = Jdbi.create(datasourceProxy);
		jdbiPlugins.forEach(jdbi::installPlugin);
		rowMappers.forEach(jdbi::registerRowMapper);
		
		return jdbi;
	}
	
	@Bean
	public JdbiPlugin sqlObjectPlugin() {
		return new SqlObjectPlugin();
	}
	
	@Bean
	public AlunoRepository alunoRepository(Jdbi jdbi) {
		return jdbi.onDemand(AlunoRepository.class);
	}
	
	@Bean
	public TurmaRepository turmaRepository(Jdbi jdbi) {
		return jdbi.onDemand(TurmaRepository.class);
	}
	
	@Bean
	public MatriculaRepository matriculaRepository(Jdbi jdbi) {
		return jdbi.onDemand(MatriculaRepository.class);
	}
}