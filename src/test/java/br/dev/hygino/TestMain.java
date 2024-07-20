package br.dev.hygino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.dev.hygino.model.Book;

public class TestMain {
	private List<Book> listaDeLivros;
	private String paisCadastrado;
	private String paisNaoCadastrado;
	private String autorCadastrado;
	private String autorNaoCadastrado;
	//private List<Book> listaDeLivrosBrasileiros;
	private List<String> autoresBrasileiros;

	@BeforeEach
	void setup() {
		listaDeLivros = Factory.bookListFactory();
		paisCadastrado = "Brasil";
		paisNaoCadastrado = "Paraguay";
		autorCadastrado = "Machado de Assis";
		autorNaoCadastrado = "Juca Bala";
		//listaDeLivrosBrasileiros = Factory.BrazilBookListFactory();
		autoresBrasileiros = Factory.listaAutoresBrasileiros();
	}

	@Test
	@DisplayName("Deve retornar 11 quando for feita a busca de livros do Brasil")
	public void shouldReturn11WhenCountryNameIsBrazil() {
		assertEquals(11, MainLivros.totalLivrosCadastradosPorPais(paisCadastrado, listaDeLivros));
	}

	@Test
	@DisplayName("Deve retornar zero se o país não for cadastrado")
	public void shouldReturnZeroWhenCountryDoesNotInBookList() {
		assertEquals(0, MainLivros.totalLivrosCadastradosPorPais(paisNaoCadastrado, listaDeLivros));
	}

	@Test
	@DisplayName("Deve retornar o total de páginas dos livros do autor cadastrado e zero para autor não cadastrado")
	public void shouldReturn494PagesWhenAutorAreMachadoDeAssisAndZeroWhenAuthorNotRegistered() {
		final var totalPaginasAutorCadastrado = MainLivros.totalDePaginasPorAutor(autorCadastrado, listaDeLivros);
		assertEquals(464, totalPaginasAutorCadastrado);

		final var totalPaginasAutorNaoCadastrado = MainLivros.totalDePaginasPorAutor(autorNaoCadastrado, listaDeLivros);
		assertEquals(0, totalPaginasAutorNaoCadastrado);
	}

	@Test
	@DisplayName("Deve retornar a lista com os escritores brasileiros")
	public void shouldReturnBrazilianAuthorList() {
		final var brazilianAuthors = MainLivros.listarAutoresDadoSeuPais(paisCadastrado, listaDeLivros);
		assertEquals(autoresBrasileiros, brazilianAuthors);
	}
}
