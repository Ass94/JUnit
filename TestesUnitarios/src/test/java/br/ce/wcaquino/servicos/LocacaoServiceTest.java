package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	private LocacaoService service;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void start() {
		service = new LocacaoService();
	}
	
	@After
	public void stop() {
		System.out.println("After");
	}
	
	@Test
	public void deveAlugarFilmeComSucesso() throws Exception {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		// cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
		
		// a��o
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verifica��o
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}

	
	@Test(expected = FilmeSemEstoqueException.class)
	public void deveLancarExcecaoAoAlugarFilmeSemEstoque() throws Exception {
		// cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2", 0, 4.0));
		

		// a��o
		service.alugarFilme(usuario, filmes);
		System.out.println("Forma elegante");
	}
	
	@Test
	public void NaoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		// cen�rio
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2", 1, 4.0));
		
		
		// a��o
		try {
			service.alugarFilme(null, filmes);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usu�rio vazio"));
		}
		System.out.println("Forma robusta");
	}
	
	@Test
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		// cen�rio
		Usuario usuario = new Usuario("Usuario 1");
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");;
		// a��o 
		service.alugarFilme(usuario, null);
		
		System.out.println("Forma nova");
	}
	
	
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado () throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		// cen�rio
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
		// a��o
		Locacao retorno = service.alugarFilme(usuario, filmes);
		
		// verifica��o
		boolean isSegunda =  DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
		Assert.assertTrue(isSegunda);
	}
}