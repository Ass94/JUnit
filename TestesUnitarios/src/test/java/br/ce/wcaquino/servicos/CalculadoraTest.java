package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.entidades.Calculadora;
import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	
	private Calculadora calculadora;
	
	@Before
	public void start() {
		this.calculadora = new Calculadora();
	}

	@Test
	public void deveSomarDoisValores() {
		// cen�rio
		int a = 5;
		int b = 3;
		// a��o
		int resultado = calculadora.somar(a, b);
		// verifica��o
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		// cen�rio
		int a = 5;
		int b = 2;
		// a��o
		int resultado = calculadora.subtrair(a, b);
		// verifica��o
		Assert.assertEquals(3, resultado);
	}
	
	@Test 
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		// cen�rio
		int a = 8;
		int b = 2;
		// a��o
		int resultado = calculadora.dividir(a, b);
		// verifica��o
		Assert.assertEquals(4, resultado);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		// cen�rio
		int a = 10;
		int b = 0;
		// a��o
		calculadora.dividir(a, b);
		// verifica��o
	}
}
