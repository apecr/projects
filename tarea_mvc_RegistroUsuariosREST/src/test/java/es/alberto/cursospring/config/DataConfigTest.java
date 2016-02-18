package es.alberto.cursospring.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataConfig.class)
public class DataConfigTest {

	
	@Autowired
	private LocalSessionFactoryBean sessionFacory;
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(sessionFacory);
	}
	
}
