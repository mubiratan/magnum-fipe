package br.com.magnum.fipe.service;

import br.com.magnum.fipe.model.Marca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListarMarcasTest {

    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

        @Test
    @DisplayName("Busca as marcas de carros e nao deve retornar vazio")
    void buscarMarcasDeCarros() {
        // Arrange
        final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        String json = consumo.chamarApi(URL_BASE);

        // Act
        List<Marca> marcas = conversor.obterLista(json, Marca.class);

        // Assert
        Assertions.assertEquals(marcas.isEmpty(), false);
    }

    @Test
    @DisplayName("Busca as marcas de motos e nao deve retornar vazio")
    void buscarMarcasDeMotos() {
        // Arrange
        final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/motos/marcas";
        String json = consumo.chamarApi(URL_BASE);

        // Act
        List<Marca> marcas = conversor.obterLista(json, Marca.class);

        // Assert
        Assertions.assertEquals(marcas.isEmpty(), false);
    }

}
