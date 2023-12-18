package br.com.magnum.fipe.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "marcas")
public class Marca
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String nome;
    @Transient
    private TipoVeiculo tipoVeiculo;

    public Marca(){}
    public Marca(Marca marca) {
        this.codigo = marca.codigo;
        this.nome = marca.nome;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public Long getId()
    {
        return id;
    }
    public Long getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setMarca(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
