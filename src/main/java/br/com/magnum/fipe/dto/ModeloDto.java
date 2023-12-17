package br.com.magnum.fipe.dto;

import br.com.magnum.fipe.model.Modelo;

public record ModeloDto(Long codigo, String nome, String observacoes) {
    public ModeloDto(Modelo modelo) {
        this(modelo.getCodigo(), modelo.getNome(), modelo.getObservacoes());
    }
}


