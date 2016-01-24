package es.alberto.curso;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class Modulo3ControllerTest {

	@Autowired
	private Modulo3Controller controller;

	@Autowired
	private Persona persona;

	private Model model;

	@Before
	public void setUp() {
		this.model = Mockito.mock(Model.class);
	}

	@Test
	public void testNotNull() {
		Assert.assertNotNull(controller);
	}

	@Test
	public void testController() {
		Assert.assertEquals("index", controller.index());
		Assert.assertEquals("home", controller.home(Locale.UK, this.model));
		Assert.assertEquals("index", controller.index());
	}

	@Test
	public void testPersona() {
		Assert.assertEquals(persona, controller.populatePersona());
	}

}
