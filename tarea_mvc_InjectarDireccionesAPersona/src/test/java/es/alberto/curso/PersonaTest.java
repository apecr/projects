package es.alberto.curso;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class PersonaTest {
	
	@Autowired
	private Persona persona;
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(persona);
	}

}
