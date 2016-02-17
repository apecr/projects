package es.alberto.cursospring.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.alberto.cursospring.config.ServletContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ServletContextConfig.class)
public class RegistroUsuarioControllerTest {
	
	@Autowired
	private RegistroUsuarioController rUController;
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(rUController);
	}

}
