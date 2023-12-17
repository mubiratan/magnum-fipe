package br.com.magnum.fipe.model;

import br.com.magnum.fipe.dto.AtualizacaoModeloDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "modelos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long marcaId;
    private Long codigo;
    private String nome;
    private String observacoes;
    @Transient
    private List<Modelo> modelos;

    public Modelo() {}

    public Modelo(Long marcaId, Long codigo, String nome, String observacoes) {
        this.marcaId = marcaId;
        this.codigo = codigo;
        this.nome = nome;
        this.observacoes = observacoes;
    }

    public Modelo(Modelo modelos) {
        this.codigo = modelos.codigo;
        this.nome = modelos.nome;
    }

    public void atualizarDados(AtualizacaoModeloDto dto) {
        this.nome = dto.nome();
        this.observacoes = dto.observacoes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(id, modelo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarcaId() { return marcaId; }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    public String getObservacoes() { return observacoes; }
}
