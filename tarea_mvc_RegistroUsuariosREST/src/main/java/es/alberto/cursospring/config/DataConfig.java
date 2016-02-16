package es.alberto.cursospring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.alberto.cursospring.vo.Usuario;

@Configuration
@Import({ DataSourceConfig.class })
@EnableTransactionManagement
public class DataConfig {

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	@Value("${hibernate.generate_statistics}")
	private String hibernateGenerateStatistics;

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Class<?>[] listaClases = new Class<?>[1];
		listaClases[0] = Usuario.class;
		sessionFactory.setAnnotatedClasses(listaClases);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", hibernateDialect);
		props.setProperty("hibernate.show_sql", hibernateShowSql);
		props.setProperty("hibernate.generate_statistics", hibernateGenerateStatistics);
		return props;
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory().getObject());		
		return hibernateTemplate;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(){
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

}
