package br.com.magnum.fipe.service;

import br.com.magnum.fipe.dto.MarcaDto;
import br.com.magnum.fipe.model.Marca;
import br.com.magnum.fipe.model.TipoVeiculo;
import br.com.magnum.fipe.repository.MarcaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;
    @Autowired
    private EnviaParaFila fila;
    @Autowired
    private ConsumoApi consumo;

    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    public void buscarMarcasFipe() {
        final String topico = "marcas.recebidas";
        String json;

        List<Marca> marcas = null;

        for(TipoVeiculo tipoVeiculo : TipoVeiculo.values()) {
            json = consumo.chamarApi(
                    URL_BASE
                            + tipoVeiculo.name().toLowerCase()
                            + "/marcas");

            marcas = conversor.obterLista(json, Marca.class);

            repository.saveAll(marcas);

            for(Marca marca : marcas) {
                marca.setMarca(tipoVeiculo);
                fila.envia(topico, marca);
            }

            marcas.clear();
        }
    }
    public List<MarcaDto> listar() {
        return repository
                .findAll()
                .stream()
                .map(MarcaDto::new)
                .toList();
    }
}
