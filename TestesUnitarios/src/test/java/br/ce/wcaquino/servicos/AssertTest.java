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
		Assert.assertEquals("Erro de comparação", 1, 2); // A string será exibida quando houver algum erro de comparação
		
		// double e float
		// (0.01) delta de comparação (margem de erro de comparação)
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
		
		// Verifica se os objetos são diferentes usando a negação
		Assert.assertNotEquals("bola", "casa"); // passa são diferentes
		
		// Analisado pelo próprio equals de cada objeto.
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2); // Depende do método equals do objeto Usuario.
		
		// Garantindo que os dois objetos sejam da mesma instância
		Assert.assertSame(u2, u2); // Sim, são da mesma instância.
		// Assert same na negação
		Assert.assertNotSame(u1, u2); // Ok, instâncias diferentes
		
		// Verificando se o objeto é nulo
		Assert.assertNull(u3);
		// Negação do null
		Assert.assertNotNull(u2); // Ok, não é nulo
		
		
		
	}

}
