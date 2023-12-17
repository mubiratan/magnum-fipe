package br.com.magnum.fipe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoModeloDto(
        @NotNull Long codigo,
        @NotBlank String nome,
        @NotBlank String observacoes) {
}
