package br.com.magnum.fipe.service;

import br.com.magnum.fipe.dto.AtualizacaoModeloDto;
import br.com.magnum.fipe.dto.ModeloDto;
import br.com.magnum.fipe.model.Modelo;
import br.com.magnum.fipe.model.Modelos;
import br.com.magnum.fipe.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository repository;

    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    public void buscarESalvarModelos(String tipo, String marca)
    {
        String URL = URL_BASE + tipo.toLowerCase() + "/marcas/" + marca + "/modelos";

        var json = consumo.chamarApi(URL);

        var modeloLista = converte.obterDados(json, Modelos.class);

        for (Modelo m : modeloLista.modelos()) {
            repository.save(new Modelo(Long.parseLong(marca), m.getCodigo(), m.getNome(), m.getObservacoes()));
        }
    }

    public List<ModeloDto> listarModeloEObservacoes(String marcaId) {
        return repository
                .findByMarcaId(Long.parseLong(marcaId))
                .stream()
                .map(ModeloDto::new)
                .toList();
    }

    public void atualizar(AtualizacaoModeloDto dto) {
        Modelo modelo = repository.getReferenceById(dto.codigo());
        modelo.atualizarDados(dto);
    }
}
