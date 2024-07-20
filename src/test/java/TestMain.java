import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import br.dev.hygino.MainLivros;

public class TestMain {

    @Test
    @Tag("Deve retornar 11 quanfor feita a busca de livros do Brasil")
    public void deveRetornar11QuandoForBuscarPorBrasil() {
        final var listaDeLivros = Factory.bookListFactory();
        final var pais = "Brasil";
        assertEquals(11, MainLivros.totalLivrosCadastradosPorPais(pais, listaDeLivros));
    }
}
