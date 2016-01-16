package com.bolsadeideas.ejemplos;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	
	@Test
	public void testMain() throws Exception{
		Main.main(null);
		// Si no ha habido excepciones todo ha ido OK
		Assert.assertTrue(true);
	}

}
