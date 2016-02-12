package es.alberto.cursospring.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.alberto.cursospring.config.RootConfig;
import es.alberto.cursospring.vo.Usuario;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class UsuarioDaoTest {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Usuario user = new Usuario();
	
	@Before
	public void setUp(){
		user.setApellido("apellido");
		user.setClave("clave");
		user.setEmail("as@as");
		user.setNombre("test");
		user.setUserName("userName");
	}
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(usuarioDao);
	}
	
	@Test
	@Transactional
	public void testCrud(){
		usuarioDao.save(user);
		List<Usuario> listaUsuarios = usuarioDao.findAll();
		Usuario userBBDD = listaUsuarios.get(0);
		userBBDD.setApellido("newApellido");
		usuarioDao.save(userBBDD);
		userBBDD = usuarioDao.findById(userBBDD.getId());
		Assert.assertEquals("newApellido", userBBDD.getApellido());
		usuarioDao.delete(userBBDD);
		Usuario userNull = usuarioDao.findById(userBBDD.getId());
		Assert.assertNull(userNull);
	}
	
	@Test
	@Transactional
	public void createUser(){
		usuarioDao.save(user);
		List<Usuario> listaUsuarios = usuarioDao.findAll();
		Assert.assertEquals(1, listaUsuarios.size());
	}

}
