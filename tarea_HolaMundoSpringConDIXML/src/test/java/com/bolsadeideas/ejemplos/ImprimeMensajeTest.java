package com.bolsadeideas.ejemplos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ImprimeMensajeTest {
	
	private static final String TEXTO_HOLA_MUNDO = "Buenos días, Spring! (by Alberto Eyo)";

	@Autowired
	private ImprimeMensaje imprimeMensaje;
	
	@Autowired
	private ProveedorMensaje proveedorMensaje;
	
	private ProveedorSaludo proveedorSaludo;
	
	@Before
	public void setUp(){
		this.proveedorSaludo = Mockito.mock(ProveedorSaludo.class);
		Mockito.when(this.proveedorSaludo.getSaludo()).thenReturn(TEXTO_HOLA_MUNDO);
		this.proveedorMensaje.setProveedorSaludo(proveedorSaludo);
	}
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(imprimeMensaje);
	}
	
	@Test
	public void testSaludo(){
		imprimeMensaje.imprimir();
		Mockito.verify(proveedorSaludo, Mockito.times(1)).getSaludo();
	}

}
