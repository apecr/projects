package es.alberto.cursospring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
public class DataSourceConfig {

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.username}")
	private String jdbcUsername;

	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Value("${jdbc.initLocation}")
	private String jdbcInitLocation;

	@Value("${jdbc.dataLocation}")
	private String jdbcDataLocation;

	/**
	 * Property placeholder configurer needed to process @Value annotations
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource basicDataSource() {
		DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
		basicDataSource.setDriverClassName(jdbcDriverClassName);
		basicDataSource.setUsername(jdbcUsername);
		basicDataSource.setPassword(jdbcPassword);
		basicDataSource.setUrl(jdbcUrl);
		return basicDataSource;
	}

	@Bean
	public ResourceDatabasePopulator populator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		Resource sqlScriptResource = (Resource) new ClassPathResource(jdbcInitLocation);
		populator.addScript(sqlScriptResource);
		sqlScriptResource = (Resource) new ClassPathResource(jdbcDataLocation);
		populator.addScript(sqlScriptResource);
		DatabasePopulatorUtils.execute(populator, basicDataSource());
		return populator;
	}

}
