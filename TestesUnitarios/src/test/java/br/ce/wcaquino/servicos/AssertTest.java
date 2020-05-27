package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		// inteiro
		Assert.assertEquals("Erro de compara��o", 1, 2); // A string ser� exibida quando houver algum erro de compara��o
		
		// double e float
		// (0.01) delta de compara��o (margem de erro de compara��o)
		Assert.assertEquals(2.0, 2.0, 0.01);
		Assert.assertEquals(0.51234, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		// Tipo primitivo e Objeto equivalente (Wrappers)
		int i = 5;
		Integer i2 = 5;
		// Autoboxing e Unboxing
		Assert.assertEquals(Integer.valueOf(i), i2); // Convertendo tipo primitivo em objeto.
		Assert.assertEquals(i, i2.intValue()); // Convertendo objeto em tipo primitivo
		
		// Strings
		// Importante definir corretamente o esperado e o atual
		Assert.assertEquals("bola", "bola");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		// Verifica se os objetos s�o diferentes usando a nega��o
		Assert.assertNotEquals("bola", "casa"); // passa s�o diferentes
		
		// Analisado pelo pr�prio equals de cada objeto.
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2); // Depende do m�todo equals do objeto Usuario.
		
		// Garantindo que os dois objetos sejam da mesma inst�ncia
		Assert.assertSame(u2, u2); // Sim, s�o da mesma inst�ncia.
		// Assert same na nega��o
		Assert.assertNotSame(u1, u2); // Ok, inst�ncias diferentes
		
		// Verificando se o objeto � nulo
		Assert.assertNull(u3);
		// Nega��o do null
		Assert.assertNotNull(u2); // Ok, n�o � nulo
		
		
		
	}

}
