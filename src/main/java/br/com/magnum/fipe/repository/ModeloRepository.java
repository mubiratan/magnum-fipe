package br.com.magnum.fipe.repository;

import br.com.magnum.fipe.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByMarcaId(Long marcaId);
    Modelo findByCodigo(Long codigo);
}
