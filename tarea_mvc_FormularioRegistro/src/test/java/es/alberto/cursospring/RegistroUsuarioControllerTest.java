package es.alberto.cursospring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import es.alberto.cursospring.vo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class RegistroUsuarioControllerTest {

	@Autowired
	private RegistroUsuarioController registroController;

	private ModelMap model = Mockito.mock(ModelMap.class);
	
	private Model model2 = Mockito.mock(Model.class);

	private Usuario user = new Usuario();

	private BindingResult result = Mockito.mock(BindingResult.class);

	@Test
	public void testNotNull() {
		Assert.assertNotNull(registroController);
	}

	@Test
	public void testCargar() {
		Assert.assertEquals(RegistroUsuarioController.CREATE_USER, this.registroController.crear(model));
	}

	@Test
	public void testGuardarKO() {
		Mockito.when(this.result.hasErrors()).thenReturn(true);
		Assert.assertEquals(RegistroUsuarioController.CREATE_USER, this.registroController.guardar(user, result));
	}
	
	@Test
	public void testGuardarOKO() {
		Mockito.when(this.result.hasErrors()).thenReturn(false);
		Assert.assertTrue(this.registroController.guardar(user, result).contains(RegistroUsuarioController.REDIRECT_USUARIO) );
		Assert.assertEquals(RegistroUsuarioController.USER_DETAIL, this.registroController.verDetalle(1L, model2));
	}
	

}
