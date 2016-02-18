package es.alberto.cursospring.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataSourceConfig.class)
public class DataSourceConfigTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() throws SQLException{
		Assert.assertNotNull(dataSource.getConnection());
	}

}
