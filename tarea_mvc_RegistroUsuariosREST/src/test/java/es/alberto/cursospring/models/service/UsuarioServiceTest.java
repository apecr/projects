package es.alberto.cursospring.models.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.alberto.cursospring.config.RootConfig;
import es.alberto.cursospring.vo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UsuarioServiceTest {

	@Autowired
	private IUsuarioService usuarioService;

	private Usuario user = new Usuario();

	@Before
	public void setUp() {
		user.setApellido("apellido");
		user.setClave("clave");
		user.setEmail("as@as");
		user.setNombre("test");
		user.setUserName("userName");
	}

	@Test
	public void testNotNull() {
		Assert.assertNotNull(usuarioService);
	}

	@Test
	public void testCrud() {
		usuarioService.save(user);
		List<Usuario> listaUsuarios = usuarioService.findAll();
		Usuario userBBDD = listaUsuarios.get(0);
		userBBDD.setApellido("newApellido");
		usuarioService.save(userBBDD);
		userBBDD = usuarioService.findById(userBBDD.getId());
		Assert.assertEquals("newApellido", userBBDD.getApellido());
		usuarioService.delete(userBBDD);
		Usuario userNull = usuarioService.findById(userBBDD.getId());
		Assert.assertNull(userNull);
	}

}
