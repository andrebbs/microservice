package springHibernate.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springHibernate.api.entities.DetalheDoAtivo;

import java.util.Optional;

public interface DetalheDoAtivoRepository extends JpaRepository<DetalheDoAtivo, Long>{
    Optional<DetalheDoAtivo> findByCategoriaAndTipoAndSubtipo(String categoria, String tipo, String subtipo);
}
