package br.com.magnum.fipe.dto;

import br.com.magnum.fipe.model.Marca;

public record MarcaDto(Long codigo, String nome) {
    public MarcaDto(Marca marca) {
        this(marca.getCodigo(), marca.getNome());
    }
}
