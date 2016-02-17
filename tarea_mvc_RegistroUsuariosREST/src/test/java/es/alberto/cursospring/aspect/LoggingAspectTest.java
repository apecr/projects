package es.alberto.cursospring.aspect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.alberto.cursospring.config.ServletContextConfig;
import es.alberto.cursospring.vo.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ServletContextConfig.class)
public class LoggingAspectTest {
	
	@Autowired
	private LoggingAspect loggingAspect;
	
	private Usuario usuario;
	
	@Before
	public void setUp(){
		usuario = new Usuario();
		usuario.setApellido("apellido");
		usuario.setNombre("nombre");
		usuario.setId(1L);
	}
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(loggingAspect);
	}
	
	@Test
	public void testCallAspect(){
		loggingAspect.logBefore(usuario);
		Assert.assertTrue(true);
	}
	
	

}
