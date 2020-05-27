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
		// cenário
		int a = 5;
		int b = 3;
		// ação
		int resultado = calculadora.somar(a, b);
		// verificação
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		// cenário
		int a = 5;
		int b = 2;
		// ação
		int resultado = calculadora.subtrair(a, b);
		// verificação
		Assert.assertEquals(3, resultado);
	}
	
	@Test 
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		// cenário
		int a = 8;
		int b = 2;
		// ação
		int resultado = calculadora.dividir(a, b);
		// verificação
		Assert.assertEquals(4, resultado);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		// cenário
		int a = 10;
		int b = 0;
		// ação
		calculadora.dividir(a, b);
		// verificação
	}
}
