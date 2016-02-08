package es.alberto.cursospring.binder;

import org.junit.Assert;
import org.junit.Test;


public class NombreMayusculaEditorTest {

	private NombreMayusculaEditor binder = new NombreMayusculaEditor();
	
	@Test
	public void testChange(){
		String text = "hola";
		binder.setAsText(text);
		Assert.assertEquals("HOLA", binder.getValue().toString());
	}
	
	@Test
	public void testChangeNull(){
		String text = null;
		binder.setAsText(text);
		Assert.assertEquals(null, binder.getValue());
	}
}
