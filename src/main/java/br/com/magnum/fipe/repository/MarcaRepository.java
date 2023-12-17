package br.com.magnum.fipe.repository;

import br.com.magnum.fipe.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long>
{

}
